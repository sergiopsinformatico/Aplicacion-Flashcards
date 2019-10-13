package main.java.aplicacionFlashcards.db.mongoDB;

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

import main.java.aplicacionFlashcards.auxiliares.Fecha;
import main.java.aplicacionFlashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAORecuperarCuenta;
import main.java.aplicacionFlashcards.dto.RecuperarCuentaDTO;

public class RecuperarCuentaMongoDB implements InterfaceDAORecuperarCuenta {
	
	//Variables
			MongoClientURI uri; 
		    MongoClient client;
		    MongoDatabase db;
		    MongoCollection<Document> coleccionRecuperarCuenta;
		    Document doc;
		    Bson criteriosBusqueda;
		    FindIterable<Document> resultadosBusqueda;
		    MongoCursor<Document>iterador;
		    Fecha fecha;
		    String comparaFecha;
		  	
		    //Logger
		    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.RecuperarCuentaMongoDB");
			
			public RecuperarCuentaMongoDB() {
				connection();
			}
			
			//Conexion con la BD
		    private void connection() {
		    	try {
					uri  = new MongoClientURI(PropertiesConfig.getProperties("conexionMongoDB")); 
			        client = new MongoClient(uri);
			        db = client.getDatabase(uri.getDatabase());
			        coleccionRecuperarCuenta = db.getCollection(PropertiesConfig.getProperties("colRecuperarCuenta"));
				}catch(Exception ex) {
					LOGGER.log(Level.INFO, ex.getMessage());
				}
		    }
		
		public boolean insertaRC(RecuperarCuentaDTO recupera) {
			
			criteriosBusqueda = new BsonDocument().append("username", new BsonString(recupera.getUsername()));
			
			doc = new Document().append("username", recupera.getUsername()).
					             append("keySecurity", recupera.getKey()).
					             append("fechaExpira", recupera.getFechaExpira());
			
			try {
				coleccionRecuperarCuenta.deleteOne(criteriosBusqueda);
				coleccionRecuperarCuenta.insertOne(doc);
				return true;
			}catch(Exception ex) {
				return false;
			}
		}
		
		public boolean leerRC(String username, String key) {
			
			criteriosBusqueda = new BsonDocument().append("username", new BsonString(username)).
					                               append("keySecurity", new BsonString(key));
			
			iterador = coleccionRecuperarCuenta.find(criteriosBusqueda).iterator();
			
			return iterador.hasNext();
			
		}
		
		public boolean existeSolicitudUsuario(String username) {
			criteriosBusqueda = new BsonDocument().append("username", new BsonString(username));
			
			iterador = coleccionRecuperarCuenta.find(criteriosBusqueda).iterator();
			
			return iterador.hasNext();
		}
		
		public boolean eliminarRC(String username) {
			try {
				criteriosBusqueda = new BsonDocument().append("username", new BsonString(username));
				coleccionRecuperarCuenta.deleteOne(criteriosBusqueda);
				return true;
			}catch (Exception ex) {
				return false;
			}
		}
		
		public boolean comprobarSolicitudesCaducadas() {
			try {
				fecha = new Fecha();
				iterador = coleccionRecuperarCuenta.find().iterator();
				while(iterador.hasNext()) {
					doc = iterador.next();
					comparaFecha = fecha.compararFechas(doc.getString("fechaExpira"), fecha.fechaHoy());
					if( comparaFecha!= null && Integer.parseInt(comparaFecha) < 0) {
						eliminarRC(doc.getString("username"));
						iterador = coleccionRecuperarCuenta.find().iterator();
					}
				}
				return true;
			}catch(Exception ex) {
				return false;
			}
		}
	
}