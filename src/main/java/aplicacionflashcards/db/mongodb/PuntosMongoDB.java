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
    PuntosDTO aux;
    CifradoCaesar caesar;
    LinkedList<PuntosDTO> listaOriginal;
    LinkedList<PuntosDTO> listaAuxiliar;
    boolean isPuesto;
	
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
		listaOriginal = new LinkedList<>();
		iterador = coleccionPuntos.find().iterator();
		while(iterador.hasNext()) {
			doc = iterador.next();
			usuario = new PuntosDTO(doc.getString("usuario"), doc.getInteger("puntos"));
			if(listaOriginal.size()==0) {
				listaOriginal.add(usuario);
			}else {
				aux = listaOriginal.get(listaOriginal.size()-1);
				if(aux.getPuntos()>=usuario.getPuntos()) {
					listaOriginal.add(usuario);
				}else {
					listaAuxiliar = new LinkedList<>();
					isPuesto = false;
					while(!listaOriginal.isEmpty()) {
						aux = listaOriginal.removeFirst();
						if((!isPuesto) && (usuario.getPuntos() >= aux.getPuntos())) {
							listaAuxiliar.add(usuario);
							listaAuxiliar.add(aux);
							isPuesto = true;
						}else {
							listaAuxiliar.add(aux);
						}
					}
					listaOriginal = listaAuxiliar;
				}
			}
		}
		return listaOriginal;
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
