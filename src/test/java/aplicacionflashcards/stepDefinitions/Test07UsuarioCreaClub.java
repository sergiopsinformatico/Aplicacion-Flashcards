package test.java.aplicacionflashcards.stepDefinitions;

import java.util.LinkedList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;

public class Test07UsuarioCreaClub {
	
	ClubDTO club;
	Fecha fecha;
	List<String> miembros;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAOClub dBClub;
	
	@Given("^Un usuario no encuentra club$")
	public void un_usuario_no_encuentra_club() throws Throwable {
		
		dBUsuario = Broker.getInstanciaUsuario();
	    dBClub = Broker.getInstanciaClub();
		
		fecha =new Fecha();
		miembros = new LinkedList<String>();
		miembros.add("user1Test");
	    
		club = new ClubDTO ("idEjemploClub", "Club Pruebas", "Pruebas BDD", 
				"user1Test", miembros, fecha.fechaHoy());
	    
	    assert(dBUsuario.existUsername("user1Test") && (!dBClub.existeIdClub(club.getIdClub())));	    
	}

	@When("^Crea un club$")
	public void crea_un_club() throws Throwable {
		assert(dBClub.insertaClub(club));
	}

	@Then("^Existe el club$")
	public void existe_el_club() throws Throwable {
	    assert(dBClub.existeIdClub(club.getIdClub()));
	}
}
