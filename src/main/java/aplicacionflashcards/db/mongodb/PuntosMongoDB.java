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
import main.java.aplicacionflashcards.db.dao.InterfaceDAOPuntos;
import main.java.aplicacionflashcards.dto.PuntosDTO;

public class PuntosMongoDB implements InterfaceDAOPuntos {
	
	//Variables	
	MongoClientURI uri; 
    MongoClient client;
    MongoDatabase db;
    MongoCollection<Document> coleccionPuntos;
    Document doc;
    Bson criteriosBusqueda;
    FindIterable<Document> resultadosBusqueda;
    MongoCursor<Document> iterador;
    PuntosDTO usuario;
    CifradoCaesar caesar;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.flashcards.db.mongodb.PuntosMongoDB");
	
	public PuntosMongoDB() {
		connection();
	}
	
	//Conexion con la BD
    private void connection() {
    	try {
    		caesar = new CifradoCaesar();
			uri  = new MongoClientURI(caesar.decryptText(PropertiesConfig.getProperties("conexionMongoDB"))); 
	        client = new MongoClient(uri);
	        db = client.getDatabase(uri.getDatabase());
	        coleccionPuntos = db.getCollection(caesar.decryptText(PropertiesConfig.getProperties("colPuntos")));
		}catch(Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}
    }
    
    @Override
    public PuntosDTO getPuntos(String usuario) {
    	criteriosBusqueda = new BsonDocument().append("usuario", new BsonString(usuario));
    	iterador = coleccionPuntos.find(criteriosBusqueda).iterator();
    	if(iterador.hasNext()) {
    		doc = iterador.next();
    		return new PuntosDTO(doc.getString("usuario"), doc.getInteger("puntos"));
    	}else {
    		return new PuntosDTO("",0);
    	}
    }

	@Override
	public boolean actualizaPuntos(PuntosDTO ptosUsuario) {
		usuario = getPuntos(ptosUsuario.getUsuario());
		if(!(usuario.getUsuario().equals(""))) {
			return (deletePuntos(ptosUsuario.getUsuario()) && createPuntos(ptosUsuario));
		}else {
			return createPuntos(ptosUsuario);
		}
	}

	@Override
	public List<PuntosDTO> rankingPrimeros() {
		return new LinkedList<>();
	}
	
	public boolean eliminarPuntos(String usuario) {
		return deletePuntos(usuario);
	}
	
	private boolean deletePuntos(String usuario) {
		criteriosBusqueda = new BsonDocument().append("usuario", new BsonString(usuario));
		return coleccionPuntos.deleteOne(criteriosBusqueda).getDeletedCount()==1;
	}
	
	private boolean createPuntos(PuntosDTO ptosUsuario) {
		try {
			doc = new Document().
				  append("usuario", ptosUsuario.getUsuario()).
				  append("puntos", ptosUsuario.getPuntos());
			coleccionPuntos.insertOne(doc);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
}
