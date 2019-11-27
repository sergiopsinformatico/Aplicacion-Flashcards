package main.java.aplicacionflashcards.db.mongodb;

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

import main.java.aplicacionflashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

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
	
	//Constantes
	static final String CONST_USERNAME = "username";
	static final String CONST_EMAIL = "email";
	static final String CONST_CLAVE = "clave";
	static final String CONST_NyA = "nombreApellidos";
	static final String CONST_CIUDAD = "ciudad";
	static final String CONST_EMAIL_FOTO = "emailFoto";
	
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
				append(CONST_USERNAME, user.getUsername()).
				append(CONST_EMAIL, user.getEmail()).
				append(CONST_CLAVE, user.getClave()).
				append("rol", user.getRol()).
				append("cuentaActivada", user.isActivadaCuenta());
		
		try {
			if(user.getNombreApellidos()!=null || !user.getNombreApellidos().equalsIgnoreCase("")) {
				doc = doc.append(CONST_NyA, user.getNombreApellidos());
			}
		}catch(Exception ex) {
			doc = doc.append(CONST_NyA, "");
		}
		
		try {
			if(user.getCiudad()!=null || !user.getCiudad().equalsIgnoreCase("")) {
				doc = doc.append(CONST_CIUDAD, user.getCiudad());
			}
		}catch(Exception ex) {
			doc = doc.append(CONST_CIUDAD, "");
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
				doc = doc.append(CONST_EMAIL_FOTO, user.getEmailFoto());
			}
		}catch(Exception ex) {
			doc = doc.append("foto", "");
			doc = doc.append(CONST_EMAIL_FOTO, "");
		}
		
		return doc;
	}
	
	private UsuarioDTO documentToUsuarioDTO(Document doc) {
		usuarioDB = new UsuarioDTO(doc.getString(CONST_USERNAME), doc.getString(CONST_EMAIL), doc.getString(CONST_CLAVE));
		usuarioDB.setRol(doc.getString("rol"));
		usuarioDB.setActivadaCuenta(doc.getBoolean("cuentaActivada"));
		try {
			if(doc.getString(CONST_NyA)!=null || (!doc.getString(CONST_NyA).equalsIgnoreCase(""))) {
				usuarioDB.setNombreApellidos(doc.getString(CONST_NyA));
			}
		}catch(Exception ex) {
			usuarioDB.setNombreApellidos("");
		}
		
		try {
			if(doc.getString(CONST_CIUDAD)!=null || (!doc.getString(CONST_CIUDAD).equalsIgnoreCase(""))) {
				usuarioDB.setCiudad(doc.getString(CONST_CIUDAD));
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
				usuarioDB.setEmailFoto(doc.getString(CONST_EMAIL_FOTO));
			}
		}catch(Exception ex) {
			usuarioDB.setFoto("");
			usuarioDB.setEmailFoto("");
		}
		
		return usuarioDB;
	}
	
	//Comprobar si existe el email
	public boolean existEmail (String email) {
		criteriosBusqueda = new BsonDocument().append(CONST_EMAIL, new BsonString(email));
		resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
		return resultadosBusqueda.iterator().hasNext();
	}
	
	//Comprobar si existe el nombre de usuario
	public boolean existUsername (String username) {
		criteriosBusqueda = new BsonDocument().append(CONST_USERNAME, new BsonString(username));
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
				            append(CONST_USERNAME, new BsonString(usernameEmail)).
				            append(CONST_CLAVE, new BsonString(clave));
		resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
		if(resultadosBusqueda.iterator().hasNext()) {
			return true;
		}else {
			criteriosBusqueda = new BsonDocument().
		            append(CONST_EMAIL, new BsonString(usernameEmail)).
		            append(CONST_CLAVE, new BsonString(clave));
			resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
			return resultadosBusqueda.iterator().hasNext();
		}
		
	}
	
	//Get usuario
	public UsuarioDTO getUsuarioDTO(String usernameEmail) {
		criteriosBusqueda = new BsonDocument().
	            append(CONST_USERNAME, new BsonString(usernameEmail));
		resultadosBusqueda = coleccionUsuarios.find(criteriosBusqueda);
		
		if(!(resultadosBusqueda.iterator().hasNext())) {
			criteriosBusqueda = new BsonDocument().
		            append(CONST_EMAIL, new BsonString(usernameEmail));
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
				criteriosBusqueda = new BsonDocument().append(CONST_EMAIL, new BsonString(userAntiguo.getEmail()));
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
		return getListByField(CONST_USERNAME);
	}
	
	public List<String> getListEmail() {
		return getListByField(CONST_EMAIL);
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
			criteriosBusqueda = new BsonDocument().append(CONST_EMAIL, new BsonString(user.getEmail()));
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
				if(!(doc.getString(CONST_USERNAME).equals(username))){
					listaUsers.add(getUsuarioDTO(doc.getString(CONST_USERNAME)));
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
