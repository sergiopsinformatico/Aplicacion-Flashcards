package main.java.aplicacionFlashcards.db.mongoDB;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import main.java.aplicacionFlashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionFlashcards.dto.UsuarioDTO;

public class UsuariosMongoDB implements InterfaceDAOUsuario{
	
	//Variables
		MongoClientURI uri; 
	    MongoClient client;
	    MongoDatabase db;
	    MongoCollection<Document> coleccionUsuarios;
	    MongoCursor<Document> iterator;
		Document doc;
		Bson criteriosBusqueda;
		FindIterable<Document> resultadosBusqueda;
		UsuarioDTO usuarioDB;
		LinkedList<String> lista;
		List<UsuarioDTO> listaInicial;
		LinkedList<UsuarioDTO> listaUsers;
		LinkedList<UsuarioDTO> listaUsersRelacion;
		List<String> bloqueadores;
		
		//Logger
		private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.UsuariosMongoDB");
		
	    
	    //Constructor
	    public UsuariosMongoDB() {
			connection();
		}
	    
	    //Conexion con la BD
	    private void connection() {
	    	try {
				uri  = new MongoClientURI(PropertiesConfig.getProperties("conexionMongoDB")); 
		        client = new MongoClient(uri);
		        db = client.getDatabase(uri.getDatabase());
		        coleccionUsuarios = db.getCollection(PropertiesConfig.getProperties("colUsuarios"));
			}catch(Exception ex) {
				LOGGER.log(Level.INFO, ex.getMessage());
			}
	    }
		
		//Insertar Usuario
		public boolean insertUsuario(UsuarioDTO user) {
			if((!existEmail(user.getEmail())) && (!existUsername(user.getUsername())) && claveIsCorrect(user.getClave()) && usernameIsCorrect(user.getUsername())) {
				coleccionUsuarios.insertOne(usuarioDTOToDocument(user));
				return true;
			}else {
				return false;
			}
		}
		
		private Document usuarioDTOToDocument(UsuarioDTO user) {
			doc = new Document().
					append("username", user.getUsername()).
					append("email", user.getEmail()).
					append("clave", user.getClave()).
					append("rol", user.getRol()).
					append("cuentaActivada", user.isActivadaCuenta());
			
			try {
				if(user.getNombreApellidos()!=null || !user.getNombreApellidos().equalsIgnoreCase("")) {
					doc = doc.append("nombreApellidos", user.getNombreApellidos());
				}
			}catch(Exception ex) {
				doc = doc.append("nombreApellidos", "");
			}
			
			try {
				if(user.getCiudad()!=null || !user.getCiudad().equalsIgnoreCase("")) {
					doc = doc.append("ciudad", user.getCiudad());
				}
			}catch(Exception ex) {
				doc = doc.append("ciudad", "");
			}
			
			try {
				if(user.getPais()!=null || !user.getPais().equalsIgnoreCase("")) {
					doc = doc.append("pais", user.getPais());
				}
			}catch(Exception ex) {
				doc = doc.append("pais", "");
			}
			
			try {
				if(user.getFoto()!=null || !user.getFoto().equalsIgnoreCase("")) {
					doc = doc.append("foto", user.getFoto());
					doc = doc.append("emailFoto", user.getEmailFoto());
				}
			}catch(Exception ex) {
				doc = doc.append("foto", "");
				doc = doc.append("emailFoto", "");
			}
			
			return doc;
		}
		
		private UsuarioDTO documentToUsuarioDTO(Document doc) {
			usuarioDB = new UsuarioDTO(doc.getString("username"), doc.getString("email"), doc.getString("clave"));
			usuarioDB.setRol(doc.getString("rol"));
			usuarioDB.setActivadaCuenta(doc.getBoolean("cuentaActivada"));
			try {
				if(doc.getString("nombreApellidos")!=null || (!doc.getString("nombreApellidos").equalsIgnoreCase(""))) {
					usuarioDB.setNombreApellidos(doc.getString("nombreApellidos"));
				}
			}catch(Exception ex) {
				usuarioDB.setNombreApellidos("");
			}
			
			try {
				if(doc.getString("ciudad")!=null || (!doc.getString("ciudad").equalsIgnoreCase(""))) {
					usuarioDB.setCiudad(doc.getString("ciudad"));
				}
			}catch(Exception ex) {
				usuarioDB.setCiudad("");
			}
			
			try {
				if(doc.getString("pais")!=null || (!doc.getString("pais").equalsIgnoreCase(""))) {
					usuarioDB.setPais(doc.getString("pais"));
				}
			}catch(Exception ex) {
				usuarioDB.setPais("");
			}
			
			try {
				if(doc.getString("foto")!=null || (!doc.getString("foto").equalsIgnoreCase(""))) {
					usuarioDB.setFoto(doc.getString("foto"));
					usuarioDB.setEmailFoto(doc.getString("emailFoto"));
				}
			}catch(Exception ex) {
				usuarioDB.setFoto("");
				usuarioDB.setEmailFoto("");
			}
			
			return usuarioDB;
		}
		
		//Comprobar si existe el email
		public boolean existEmail (String email) {
			criteriosBusqueda = new BsonDocument().append("email", new BsonString(email));
			resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			return resultadosBusqueda.iterator().hasNext();
		}
		
		//Comprobar si existe el nombre de usuario
		public boolean existUsername (String username) {
			criteriosBusqueda = new BsonDocument().append("username", new BsonString(username));
			resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			return resultadosBusqueda.iterator().hasNext();
		}
		
		//Comprobar si es correcta la restriccion del nombre de usuario
		public boolean usernameIsCorrect(String username) {
			if(!(username.length()>=5 && username.length()<=15)) {
				return false;
			}
			for(int indice=0; indice<username.length(); indice++) {
				if(!((username.charAt(indice)>='0' && username.charAt(indice)<='9') ||
					 (username.charAt(indice)>='a' && username.charAt(indice)<='z') ||
					 (username.charAt(indice)>='A' && username.charAt(indice)<='Z'))) {
					return false;
				}
			}
			return true;
		}
		
		//Comprobar si es correcta la restriccion de la clave
		public boolean claveIsCorrect(String clave) {
			if(!(clave.length()>=5 && clave.length()<=20)) {
				return false;
			}
			for(int indice=0; indice<clave.length(); indice++) {
				if(!((clave.charAt(indice)>='0' && clave.charAt(indice)<='9') ||
					 (clave.charAt(indice)>='a' && clave.charAt(indice)<='z') ||
					 (clave.charAt(indice)>='A' && clave.charAt(indice)<='Z'))) {
					return false;
				}
			}
			return true;
		}
		
		//Login Usuario
		public boolean login(String usernameEmail, String clave) {
			criteriosBusqueda = new BsonDocument().
					            append("username", new BsonString(usernameEmail)).
					            append("clave", new BsonString(clave));
			resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			if(resultadosBusqueda.iterator().hasNext()) {
				return true;
			}else {
				criteriosBusqueda = new BsonDocument().
			            append("email", new BsonString(usernameEmail)).
			            append("clave", new BsonString(clave));
				resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
				return resultadosBusqueda.iterator().hasNext();
			}
			
		}
		
		//Get usuario
		public UsuarioDTO getUsuarioDTO(String usernameEmail) {
			criteriosBusqueda = new BsonDocument().
		            append("username", new BsonString(usernameEmail));
			resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			
			if(!(resultadosBusqueda.iterator().hasNext())) {
				criteriosBusqueda = new BsonDocument().
			            append("email", new BsonString(usernameEmail));
				resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			}
			
			if(!(resultadosBusqueda.iterator().hasNext())) {
				return null;
			}
			
			doc = resultadosBusqueda.iterator().next();
			usuarioDB = documentToUsuarioDTO(doc);
			
			return usuarioDB;
			
		}
		
		public boolean updateUsuario(UsuarioDTO userAntiguo, UsuarioDTO userNuevo) {
			
			boolean actualiza = false;
			
			if((userAntiguo.getUsername().equals(userNuevo.getUsername()) && (userAntiguo.getEmail().equals(userNuevo.getEmail()) || (!existEmail(userNuevo.getEmail())))) ||
			   (userAntiguo.getEmail().equals(userNuevo.getEmail()) && (!existUsername(userNuevo.getUsername()))) ||
			   (!existUsername(userNuevo.getUsername()) && !existEmail(userNuevo.getEmail()))) {
				actualiza = true;
			}
			
			if(actualiza) {
				try {
					criteriosBusqueda = new BsonDocument().append("email", new BsonString(userAntiguo.getEmail()));
					coleccionUsuarios.deleteOne(criteriosBusqueda);
					coleccionUsuarios.insertOne(usuarioDTOToDocument(userNuevo));
					return true;
				}catch(Exception ex) {
					return false;
				}
			}
			
			return false;
		}
		
		public List<String> getListUsername() {		
			return getListByField("username");
		}
		
		public List<String> getListEmail() {
			return getListByField("email");
		}
		
		private List<String> getListByField(String field){
			iterator = coleccionUsuarios.find().iterator();
			lista = new LinkedList<>();
			
			if(iterator!=null) {
				while(iterator.hasNext()) {
					doc = iterator.next();
					lista.add(doc.getString(field));
				}
			}
			
			return lista;
		}
		
		public boolean deleteUsuario(UsuarioDTO user) {
			try {
				criteriosBusqueda = new BsonDocument().append("email", new BsonString(user.getEmail()));
				coleccionUsuarios.deleteOne(criteriosBusqueda);
				return true;
			}catch(Exception ex) {
				LOGGER.log(Level.INFO, ex.getMessage());
				return false;
			}
		}
		
		public List<UsuarioDTO> getAllUsuarios(String username){
			listaUsers = new LinkedList<>();
			iterator = coleccionUsuarios.find().iterator();
			if(iterator!=null) {
				while(iterator.hasNext()) {
					doc = iterator.next();
					if(!(doc.getString("username").equals(username))){
						listaUsers.add(getUsuarioDTO(doc.getString("username")));
					}
				}
			}
			return listaUsers;
		}
		
		public List<UsuarioDTO> getUsuariosRelacion(String username){
			listaInicial = getAllUsuarios(username);		
			
			listaUsersRelacion = new LinkedList<>();
			
			boolean encontrado;
			for(int indice=0; indice<listaInicial.size(); indice++) {
				encontrado = false;
				for(int indiceDos=0; indiceDos<bloqueadores.size(); indiceDos++) {
					if(listaInicial.get(indice).getUsername().equals(bloqueadores.get(indiceDos))) {
						encontrado = true;
						break;
					}
				}
				if(!encontrado) {
					listaUsersRelacion.add(listaInicial.get(indice));
				}
			}
			
			return listaUsersRelacion;
		}
	
}