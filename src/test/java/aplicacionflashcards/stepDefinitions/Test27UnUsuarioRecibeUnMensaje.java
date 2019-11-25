package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class Test27UnUsuarioRecibeUnMensaje {
	
	List<MensajeDTO> listaMensajes;
	
	@Given("^Un usuario que ha iniciado sesion$")
	public void un_usuario_que_ha_iniciado_sesion() throws Throwable {
		
		assert(Broker.getInstanciaUsuario().login("usuario123", "usuario123"));
	}

	@When("^Recibe un mensaje$")
	public void recibe_un_mensaje() throws Throwable {
	    listaMensajes = Broker.getInstanciaMensaje().mensajesRecibidos("usuario123");
	    assert(true);
	}

	@Then("^Puede verlo$")
	public void puede_verlo() throws Throwable {
	    assert(listaMensajes.size()>0);
	}
}
