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

import main.java.aplicacionflashcards.auxiliares.CifradoCaesar;
import main.java.aplicacionflashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOMensaje;
import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class MensajeMongoDB implements InterfaceDAOMensaje {
	
	/* * * * * * *
	 * VARIABLES *
	 * * * * * * */
	
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
    CifradoCaesar caesar;
    
    /* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_ID_MENSAJE = "idMensaje";
	static final String CONST_REMITENTE = "remitente";
	static final String CONST_DESTINATARIO = "destinatario";
	static final String CONST_ASUNTO = "asunto";
	static final String CONST_MENSAJE = "mensaje";
    
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.MensajeMongoDB");
	
    /* * * * * * * * * * * *
	 * COLECCION: MENSAJES *
	 * * * * * * * * * * * */
    
	public MensajeMongoDB() {
		connection();
	}
	
	//Conexion con la BD
    private void connection() {
    	try {
    		caesar = new CifradoCaesar();
			uri  = new MongoClientURI(caesar.decryptText(PropertiesConfig.getProperties("conexionMongoDB"))); 
	        client = new MongoClient(uri);
	        db = client.getDatabase(uri.getDatabase());
	        coleccionMensajes = db.getCollection(caesar.decryptText(PropertiesConfig.getProperties("colMensajes")));
		}catch(Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
    }

	@Override
	public boolean enviaMensaje(MensajeDTO mensaje) {
		try {
			doc = new Document().append(CONST_ID_MENSAJE, mensaje.getIdMensaje()).
					append(CONST_REMITENTE, mensaje.getRemitente()).
					append(CONST_DESTINATARIO, mensaje.getDestinatario()).
					append(CONST_ASUNTO, mensaje.getAsunto()).
					append(CONST_MENSAJE,mensaje.getMensaje());
			coleccionMensajes.insertOne(doc);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

	@Override
	public List<MensajeDTO> mensajesEnviados(String username) {
		listaMensajes = new LinkedList<>();
		
		criteriosBusqueda = new BsonDocument().append(CONST_REMITENTE, new BsonString(username));
		iterador = coleccionMensajes.find(criteriosBusqueda).iterator();
		while(iterador.hasNext()) {
			doc = iterador.next();
			if(doc.getString(CONST_ID_MENSAJE).startsWith(username+"-")) {
				listaMensajes.add(new MensajeDTO(doc.getString(CONST_ID_MENSAJE), 
												 doc.getString(CONST_REMITENTE), 
												 doc.getString(CONST_DESTINATARIO),
												 doc.getString(CONST_ASUNTO),
												 doc.getString(CONST_MENSAJE)));
			}
			
		}
		
		return listaMensajes;
	}

	@Override
	public List<MensajeDTO> mensajesRecibidos(String username) {
		listaMensajes = new LinkedList<>();
		
		criteriosBusqueda = new BsonDocument().append(CONST_DESTINATARIO, new BsonString(username));
		iterador = coleccionMensajes.find(criteriosBusqueda).iterator();
		while(iterador.hasNext()) {
			doc = iterador.next();
			if(doc.getString(CONST_ID_MENSAJE).startsWith(username+"-")) {
				listaMensajes.add(new MensajeDTO(doc.getString(CONST_ID_MENSAJE), 
												 doc.getString(CONST_REMITENTE), 
												 doc.getString(CONST_DESTINATARIO),
												 doc.getString(CONST_ASUNTO),
												 doc.getString(CONST_MENSAJE)));
			}
			
		}
		
		return listaMensajes;
	}

	@Override
	public boolean eliminarMensaje(String idMensaje) {
		criteriosBusqueda = new BsonDocument().append(CONST_ID_MENSAJE, new BsonString(idMensaje));
		return coleccionMensajes.deleteOne(criteriosBusqueda).getDeletedCount()==1;
	}
	
	@Override
	public MensajeDTO verMensaje(String idMensaje) {
		criteriosBusqueda = new BsonDocument().append(CONST_ID_MENSAJE, new BsonString(idMensaje));
		iterador = coleccionMensajes.find(criteriosBusqueda).iterator();
		if(iterador.hasNext()) {
			doc = iterador.next();
			return new MensajeDTO(doc.getString(CONST_ID_MENSAJE), 
								  doc.getString(CONST_REMITENTE), 
								  doc.getString(CONST_DESTINATARIO),
								  doc.getString(CONST_ASUNTO),
								  doc.getString(CONST_MENSAJE));
		}else {
			return new MensajeDTO("","","","","");
		}
	}
	
	public boolean existeIdMensaje(String idMensaje) {
		criteriosBusqueda = new BsonDocument().append(CONST_ID_MENSAJE, new BsonString(idMensaje));
		return coleccionMensajes.find(criteriosBusqueda).iterator().hasNext();
	}

}
