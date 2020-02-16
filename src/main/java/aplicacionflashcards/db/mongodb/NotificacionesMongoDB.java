package main.java.aplicacionflashcards.db.mongodb;

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
import com.mongodb.client.MongoDatabase;

import main.java.aplicacionflashcards.auxiliares.CifradoCaesar;
import main.java.aplicacionflashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionflashcards.db.dao.InterfaceDAONotificaciones;
import main.java.aplicacionflashcards.dto.NotificacionesDTO;

public class NotificacionesMongoDB implements InterfaceDAONotificaciones {
	
	//Variables
	MongoClientURI uri; 
    MongoClient client;
    MongoDatabase db;
    MongoCollection<Document> coleccionNotificaciones;
    Document doc;
    Bson criteriosBusqueda;
    FindIterable<Document> resultadosBusqueda;
    NotificacionesDTO eNotificaciones;
    List<String> notificaciones;
    int indice;
    boolean foundNotificacion;
	CifradoCaesar caesar;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.NotificacionesMongoDB");
	
	public NotificacionesMongoDB() {
		connection();
	}
	
	//Conexion con la BD
    private void connection() {
    	try {
    		caesar = new CifradoCaesar();
			uri  = new MongoClientURI(caesar.decryptText(PropertiesConfig.getProperties("conexionMongoDB"))); 
	        client = new MongoClient(uri);
	        db = client.getDatabase(uri.getDatabase());
	        coleccionNotificaciones = db.getCollection(caesar.decryptText(PropertiesConfig.getProperties("colNotificaciones")));
		}catch(Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
    }

	public boolean createObjectNotificaciones(NotificacionesDTO notificacion) {
		try {
			
			doc = new Document().append("usuario", notificacion.getUsuario()).
						append("listaNotificaciones", notificacion.getListaNotificaciones());
			coleccionNotificaciones.insertOne(doc);
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}

	public boolean deleteObjectNotificaciones(String usuario) {
		return deleteObjectNotificacionUsuario(usuario);
	}

	public boolean insertarNotificacion(String usuario, String notificacion) {
		try {
			eNotificaciones = getNotificacionUsuario(usuario);
			if(eNotificaciones!=null) {
				notificaciones = eNotificaciones.getListaNotificaciones();
				
				foundNotificacion = false;
				
				for(indice=0; indice<notificaciones.size(); indice++) {
					if(notificaciones.get(indice).equals(notificacion)) {
						foundNotificacion = true;
					}
				}
				
				if(!foundNotificacion) {
					notificaciones.add(notificacion);
					eNotificaciones.setListaNotificaciones(notificaciones);
					updateNotificacionUsuario(eNotificaciones);
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
				
		}catch(Exception ex) {
			return false;
		}
	}

	public boolean eliminarNotificacion(String usuario, int indiceNotificacion) {
		try {
			
			eNotificaciones = getNotificacionUsuario(usuario);
			if(eNotificaciones!=null) {
				notificaciones = eNotificaciones.getListaNotificaciones();
				notificaciones.remove(indiceNotificacion);			
				eNotificaciones.setListaNotificaciones(notificaciones);
				updateNotificacionUsuario(eNotificaciones);
				return true;
			}else {
				return false;
			}
			
		}catch(Exception ex) {
			return false;
		}
	}

	public NotificacionesDTO getNotificaciones(String usuario) {
		return getNotificacionUsuario(usuario);
	}
	
	private NotificacionesDTO getNotificacionUsuario(String usuario) {
		try {
			
			criteriosBusqueda = new BsonDocument().append("usuario", new BsonString(usuario));
			resultadosBusqueda = coleccionNotificaciones.find(criteriosBusqueda);
			if(resultadosBusqueda.iterator().hasNext()) {
				doc = resultadosBusqueda.iterator().next();
				return new NotificacionesDTO(doc.getString("usuario"), 
						                     (List<String>)doc.get("listaNotificaciones"));
			}else {
				return null;
			}
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	private boolean deleteObjectNotificacionUsuario(String usuario) {
		try {
			
			criteriosBusqueda = new BsonDocument().append("usuario", new BsonString(usuario));
			coleccionNotificaciones.deleteOne(criteriosBusqueda);
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	private boolean updateNotificacionUsuario(NotificacionesDTO notificacion) {
		try {
			
			deleteObjectNotificacionUsuario(notificacion.getUsuario());
			createObjectNotificaciones(notificacion);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

}
