package test.java.aplicacionflashcards.stepDefinitions;

import java.util.LinkedList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.RelacionesUsuariosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test08UsuarioSeUneAClub {
	
	ClubDTO club;
	RelacionesUsuariosDTO relacion;
	InterfaceDAOClub dBClub;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	UsuarioDTO user;
	List<String> miembros;
	boolean encontrado;
	int indice;
	
	@Given("^Un usuario encuentra un club$")
	public void un_usuario_encuentra_un_club() throws Throwable {
		
		dBUsuario = Broker.getInstanciaUsuario();
		user = new UsuarioDTO("user3Test", "user3Test@email.com", "user3Test");
		user.setRol("Usuario");
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		relacion = new RelacionesUsuariosDTO("user3Test", new LinkedList<String>(),  
				   new LinkedList<String>(), new LinkedList<String>(),
				   new LinkedList<String>(), new LinkedList<String>());
		
	    dBClub = Broker.getInstanciaClub();
	    club = dBClub.leerClub("idEjemploClub", "user1Test");
	    
	    assert(dBUsuario.insertUsuario(user) && dBRelaciones.creaRelaciones(relacion) && club!=null);
	}

	@When("^Solicita unirse$")
	public void solicita_unirse() throws Throwable {
		miembros = club.getMiembros();
		miembros.add("user3Test");
		club.setMiembros(miembros);
		assert(dBClub.actualizaClub(club));
	}

	@Then("^Forma parte de este club$")
	public void forma_parte_de_este_club() throws Throwable {
		club = dBClub.leerClub("idEjemploClub", "user3Test");
		encontrado = false;
		miembros = club.getMiembros();
		for(indice=0; indice<miembros.size(); indice++) {
			if(miembros.get(indice).equals("user3Test")) {
				encontrado = true;
				indice = miembros.size();
			}
		}
		assert(encontrado);
	}
}
