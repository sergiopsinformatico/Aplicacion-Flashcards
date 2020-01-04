package test.java.aplicacionflashcards.stepDefinitions;

import java.util.LinkedList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.TarjetaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test20ModeradorConsultaColeccionesSinEvaluar {
	
	FlashcardsDTO flashcard;
	List<TarjetaDTO> tarjetas;
	TarjetaDTO tarjeta;
	List<FlashcardsDTO> listaFlashcards;
	boolean encontrado;
	int indice;
	UsuarioDTO moderador;
	InterfaceDAOUsuario dBUsuario;
	FlashcardsDTO eFlashcard;
	
	@Given("^Un moderador consulta las colecciones$")
	public void un_moderador_consulta_las_colecciones() throws Throwable {
		dBUsuario = Broker.getInstanciaUsuario();
		moderador = new UsuarioDTO("moderadorTest", "moderadorTest@email.com", "moderadorTest");
		moderador.setRol("Moderador");
	    assert(dBUsuario.insertUsuario(moderador) &&
	    	   dBUsuario.getUsuarioDTO("moderadorTest").getRol().equals("Moderador"));
	}

	@When("^Busca$")
	public void busca() throws Throwable {
		tarjeta = new TarjetaDTO("anverso", "reverso");
		
		tarjetas = new LinkedList<>();
		tarjetas.add(tarjeta);
		
		flashcard = new FlashcardsDTO("flash12345", "flashEjemplo", "tema5", "user1Test", tarjetas, "publico", "");
		flashcard.setFechaCreacion("2019/10/01");
		flashcard.setEvaluada(false);
		flashcard.setEvaluador("");
		
	    Broker.getInstanciaFlashcards().crearFlashcards(flashcard);
	    
	    listaFlashcards = Broker.getInstanciaFlashcards().consultaSinEvaluar("moderadorTest");
	    
	    assert(true);
	}

	@Then("^Se lista todas sin evaluar$")
	public void se_lista_todas_sin_evaluar() throws Throwable {
	    encontrado = false;
	    for(indice=0; indice<listaFlashcards.size(); indice++) {
	    	eFlashcard = listaFlashcards.get(indice);
	    	if((eFlashcard.isEvaluada() || eFlashcard.getAutorColeccion().equals("moderadorTest"))) {
	    		encontrado = true;
	    		indice = listaFlashcards.size();
	    	}
	    }
	    assert(!encontrado);
	}
}
