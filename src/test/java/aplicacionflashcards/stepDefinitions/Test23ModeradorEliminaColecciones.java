package test.java.aplicacionflashcards.stepDefinitions;

import java.util.LinkedList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.TarjetaDTO;

public class Test23ModeradorEliminaColecciones {
	
	FlashcardsDTO flashcard;
	List<TarjetaDTO> tarjetas;
	TarjetaDTO tarjeta;
	List<FlashcardsDTO> listaFlashcards;
	FlashcardsDTO coleccion;
	
	
	@Given("^Un moderador lista las colecciones$")
	public void un_moderador_lista_las_colecciones() throws Throwable {
		tarjeta = new TarjetaDTO("anverso", "reverso");
		
		tarjetas = new LinkedList<>();
		tarjetas.add(tarjeta);
		
		flashcard = new FlashcardsDTO("flash12345", "flashEjemplo", "tema5", "user1Test", 
				tarjetas, "publico", "");
		
		flashcard.setFechaCreacion("2019/10/01");
		flashcard.setEvaluada(true);
		flashcard.setEvaluador("");
		
		
	    Broker.getInstanciaFlashcards().crearFlashcards(flashcard);
	    
	    listaFlashcards = Broker.getInstanciaFlashcards().listarTodasColecciones();
	    assert(Broker.getInstanciaUsuario().getUsuarioDTO("moderadorTest").getRol().equals("Moderador"));
	}

	@When("^Considere oportuno eliminar una coleccion$")
	public void considere_oportuno_eliminar_una_coleccion() throws Throwable {
	    assert(listaFlashcards.size()>=1);
	}

	@Then("^Elimina la coleccion$")
	public void elimina_la_coleccion() throws Throwable {
		Broker.getInstanciaFlashcards().eliminarFlashcard("flash12345");
		coleccion = Broker.getInstanciaFlashcards().leerFlashcard("flash12345");
		assert(coleccion == null);
	}
	
}
