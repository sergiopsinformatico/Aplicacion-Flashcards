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
import main.java.aplicacionflashcards.db.dao.InterfaceDAOMensaje;
import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class MensajeMongoDB implements InterfaceDAOMensaje {
	
	//Variables	
	MongoClientURI uri; 
    MongoClient client;
    MongoDatabase db;
    MongoCollection<Document> coleccionMensajes;
    Document doc;
    Bson criteriosBusqueda;
    FindIterable<Document> resultadosBusqueda;
    LinkedList<ActivaCuentaDTO> lista;
    MongoCursor<Document> iterador;
    List<MensajeDTO> listaMensajes;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.MensajeMongoDB");
	
	public MensajeMongoDB() {
		connection();
	}
	
	//Conexion con la BD
    private void connection() {
    	try {
			uri  = new MongoClientURI(PropertiesConfig.getProperties("conexionMongoDB")); 
	        client = new MongoClient(uri);
	        db = client.getDatabase(uri.getDatabase());
	        coleccionMensajes = db.getCollection(PropertiesConfig.getProperties("colMensajes"));
		}catch(Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
    }

	@Override
	public boolean enviaMensaje(MensajeDTO mensaje) {
		try {
			doc = new Document().append("idMensaje", mensaje.getIdMensaje()).
					append("remitente", mensaje.getRemitente()).
					append("destinatario", mensaje.getDestinatario()).
					append("mensaje",mensaje.getMensaje());
			coleccionMensajes.insertOne(doc);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public List<MensajeDTO> mensajesEnviados(String username) {
		return null;
	}

	@Override
	public List<MensajeDTO> mensajesRecibidos(String username) {
		listaMensajes = new LinkedList<MensajeDTO>();
		
		criteriosBusqueda = new BsonDocument().append("destinatario", new BsonString(username));
		iterador = coleccionMensajes.find(criteriosBusqueda).iterator();
		while(iterador.hasNext()) {
			doc = iterador.next();
			listaMensajes.add(new MensajeDTO(doc.getString("idMensaje"), 
											 doc.getString("remitente"), 
											 doc.getString("destinatario"),
											 doc.getString("mensaje")));
		}
		
		return listaMensajes;
	}

	@Override
	public boolean eliminarMensaje(String idMensaje) {
		return false;
	}

}
