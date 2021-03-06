package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;

public class Test21ModeradorEvaluaPositivamenteColeccion {
	
	FlashcardsDTO flashcard;
	
	@Given("^El moderador evalua la coleccion$")
	public void el_moderador_evalua_la_coleccion() throws Throwable {
		assert(Broker.getInstanciaUsuario().getUsuarioDTO("moderadorTest").getRol().equals("Moderador"));
	}

	@When("^Lo valora positivamente$")
	public void lo_valora_positivamente() throws Throwable {
	    assert(Broker.getInstanciaFlashcards().valoraPositivamente("flash12345", "moderadorTest"));
	}

	@Then("^La coleccion puede visualizarse$")
	public void la_coleccion_puede_visualizarse() throws Throwable {
	    flashcard = Broker.getInstanciaFlashcards().leerFlashcard("flash12345");
	    assert(flashcard.isEvaluada());
	}
}
