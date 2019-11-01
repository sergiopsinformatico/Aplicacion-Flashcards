package test.java.aplicacionFlashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionFlashcards.broker.Broker;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionFlashcards.dto.ClubDTO;

public class Test10AdministradorEliminaClub {
	InterfaceDAOClub dBClub;
	ClubDTO club;
	
	@Given("^Un administrador quiere eliminar el club$")
	public void un_administrador_de_un_club_quiere_eliminar_el_club() throws Throwable {
	    dBClub = Broker.getInstanciaClub();
	    club = dBClub.leerClub("idEjemploClub", "usuario456");
	    if(club!=null) {
	    	assert(club.getAdministrador().equals("usuario123"));
	    }else {
	    	assert(false);
	    }
	}

	@When("^Elimina el club$")
	public void elimina_el_club() throws Throwable {
	    assert(dBClub.eliminaClub(club.getIdClub()));
	}

	@Then("^El club ya no existe$")
	public void el_club_ya_no_existe() throws Throwable {
	    assert(!dBClub.existeIdClub(club.getIdClub()));
	}
}