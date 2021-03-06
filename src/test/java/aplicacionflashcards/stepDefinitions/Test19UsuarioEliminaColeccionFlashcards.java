package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;

public class Test19UsuarioEliminaColeccionFlashcards {
	
	FlashcardsDTO coleccion;
	
	@Given("^Un usuario quiere eliminar una coleccion de Flashcards$")
	public void un_usuario_quiere_eliminar_una_coleccion_de_Flashcards() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("user1Test", "user1Test"));
	}

	@When("^Encuentra la coleccion$")
	public void encuentra_la_coleccion() throws Throwable {
	    coleccion = Broker.getInstanciaFlashcards().leerFlashcard("flash12345");
	    assert(coleccion.getAutorColeccion().equals("user1Test"));
	}

	@Then("^La elimina$")
	public void la_elimina() throws Throwable {
		Broker.getInstanciaFlashcards().eliminarFlashcard("flash12345");
		coleccion = Broker.getInstanciaFlashcards().leerFlashcard("flash12345");
		assert(coleccion == null);
	}
}
