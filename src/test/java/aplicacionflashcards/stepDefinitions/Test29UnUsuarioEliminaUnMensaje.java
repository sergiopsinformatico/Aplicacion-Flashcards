package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class Test29UnUsuarioEliminaUnMensaje {
	
	MensajeDTO mensaje;
	
	@Given("^Un usuario quiere eliminar un mensaje$")
	public void un_usuario_quiere_eliminar_un_mensaje() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("user1Test", "user1Test"));
	}

	@When("^Borra el mensaje$")
	public void borra_el_mensaje() throws Throwable {
		 assert(Broker.getInstanciaMensaje().eliminarMensaje("user1Test-idMensaje"));
	}

	@Then("^Mensaje borrado$")
	public void mensaje_borrado() throws Throwable {
		mensaje=Broker.getInstanciaMensaje().verMensaje("user1Test-idMensaje");
		assert(mensaje.getDestinatario().equals("") &&
			   mensaje.getIdMensaje().equals("") &&
			   mensaje.getMensaje().equals("") &&
			   mensaje.getRemitente().equals(""));
	}
}
