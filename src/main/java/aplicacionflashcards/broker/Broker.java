package main.java.aplicacionflashcards.broker;

import main.java.aplicacionflashcards.db.dao.InterfaceDAOActivaCuenta;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOEliminarCuenta;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOFlashcards;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOMensaje;
import main.java.aplicacionflashcards.db.dao.InterfaceDAONotificaciones;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOPuntos;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORecuperarCuenta;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.db.mongodb.ActivarCuentaMongoDB;
import main.java.aplicacionflashcards.db.mongodb.ClubMongoDB;
import main.java.aplicacionflashcards.db.mongodb.EliminarCuentaMongoDB;
import main.java.aplicacionflashcards.db.mongodb.FlashcardsMongoDB;
import main.java.aplicacionflashcards.db.mongodb.MensajeMongoDB;
import main.java.aplicacionflashcards.db.mongodb.NotificacionesMongoDB;
import main.java.aplicacionflashcards.db.mongodb.PuntosMongoDB;
import main.java.aplicacionflashcards.db.mongodb.RecuperarCuentaMongoDB;
import main.java.aplicacionflashcards.db.mongodb.RelacionesUsuariosMongoDB;
import main.java.aplicacionflashcards.db.mongodb.UsuariosMongoDB;

public class Broker {
	
	private Broker() {
		throw new IllegalStateException("Broker no se instancia");
	}
	
	public static InterfaceDAOUsuario getInstanciaUsuario() {
		return new UsuariosMongoDB();
	}
	
	public static InterfaceDAOActivaCuenta getInstanciaActivaCuenta() {
		return new ActivarCuentaMongoDB();
	}
	
	public static InterfaceDAOEliminarCuenta getInstanciaEliminarCuenta() {
		return new EliminarCuentaMongoDB();
	}
	
	public static InterfaceDAORecuperarCuenta getInstanciaRecuperarCuenta() {
		return new RecuperarCuentaMongoDB();
	}
	
	public static InterfaceDAOClub getInstanciaClub() {
		return new ClubMongoDB();
	}
	
	public static InterfaceDAORelacionesUsuarios getInstanciaRelaciones() {
		return new RelacionesUsuariosMongoDB();
	}
	
	public static InterfaceDAOFlashcards getInstanciaFlashcards() {
		return new FlashcardsMongoDB();
	}
	
	public static InterfaceDAOMensaje getInstanciaMensaje() {
		return new MensajeMongoDB();
	}
	
	public static InterfaceDAOPuntos getInstanciaPuntos() {
		return new PuntosMongoDB();
	}
	
	public static InterfaceDAONotificaciones getInstanciaNotificaciones() {
		return new NotificacionesMongoDB();
	}
	
}