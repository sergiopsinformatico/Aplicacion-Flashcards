package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOMensaje;
import main.java.aplicacionflashcards.dto.MensajeDTO;

public class Test26UnUsuarioEnviaUnMensaje {
	
	MensajeDTO mensaje;
	InterfaceDAOMensaje mensajeDB;
	
	@Given("^Un usuario crea un mensaje$")
	public void un_usuario_crea_un_mensaje() throws Throwable {
	    mensaje = new MensajeDTO("mensaje-idMensaje", null, null, null, null);
	    mensajeDB = Broker.getInstanciaMensaje();
	    assert(true);
	}

	@When("^Escribe ese mensaje$")
	public void escribe_ese_mensaje() throws Throwable {
	    mensaje.setRemitente("user3Test");
	    mensaje.setDestinatario("user1Test");
	    mensaje.setAsunto("Hola");
	    mensaje.setMensaje("Hola");
	    assert(true);
	}

	@Then("^Envia el mensaje a otro usuario$")
	public void envia_el_mensaje_a_otro_usuario() throws Throwable {
	    assert(mensajeDB.enviaMensaje(mensaje));
	}
	
}
