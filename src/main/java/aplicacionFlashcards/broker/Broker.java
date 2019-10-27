package main.java.aplicacionFlashcards.broker;

import main.java.aplicacionFlashcards.db.dao.InterfaceDAOActivaCuenta;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOEliminarCuenta;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAORecuperarCuenta;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionFlashcards.db.mongoDB.ActivarCuentaMongoDB;
import main.java.aplicacionFlashcards.db.mongoDB.ClubMongoDB;
import main.java.aplicacionFlashcards.db.mongoDB.EliminarCuentaMongoDB;
import main.java.aplicacionFlashcards.db.mongoDB.RecuperarCuentaMongoDB;
import main.java.aplicacionFlashcards.db.mongoDB.RelacionesUsuariosMongoDB;
import main.java.aplicacionFlashcards.db.mongoDB.UsuariosMongoDB;

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
}