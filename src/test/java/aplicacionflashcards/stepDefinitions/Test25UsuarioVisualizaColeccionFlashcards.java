package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;

public class Test25UsuarioVisualizaColeccionFlashcards {
	
	FlashcardsDTO flashcard;
	
	
	@Given("^Un usuario localiza una coleccion$")
	public void un_usuario_localiza_una_coleccion() throws Throwable {
	    assert(Broker.getInstanciaUsuario().login("user1Test", "user1Test"));
	}

	@When("^La abre$")
	public void la_abre() throws Throwable {
	    flashcard = Broker.getInstanciaFlashcards().leerFlashcard("flash12345");
	    assert(true);
	}

	@Then("^Puede ver las tarjetas y los datos acerca de esta$")
	public void puede_ver_las_tarjetas_y_los_datos_acerca_de_esta() throws Throwable {
		Broker.getInstanciaFlashcards().eliminarFlashcard("flash12345");
		Broker.getInstanciaUsuario().deleteUsuario(Broker.getInstanciaUsuario().getUsuarioDTO("moderadorTest"));
	    assert(flashcard != null);
	}
	
}
