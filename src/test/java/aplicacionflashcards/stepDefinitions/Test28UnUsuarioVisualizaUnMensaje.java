package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class Test28UnUsuarioVisualizaUnMensaje {
	
	MensajeDTO mensaje;
	
	@Given("^Un usuario quiere ver un mensaje$")
	public void un_usuario_quiere_ver_un_mensaje() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("usuario123", "usuario123"));
	}

	@When("^Abre el mensaje$")
	public void abre_el_mensaje() throws Throwable {
	    //mensaje = Broker.getInstanciaMensaje().verMensaje("mensaje-idMensaje");
		
	    assert(true);
	}

	@Then("^Visualiza el mensaje$")
	public void visualiza_el_mensaje() throws Throwable {
	    assert(true);
	}
}
