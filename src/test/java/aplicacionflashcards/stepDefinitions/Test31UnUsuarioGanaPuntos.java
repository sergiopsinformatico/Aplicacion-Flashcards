package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.PuntosDTO;

public class Test31UnUsuarioGanaPuntos {
	
	PuntosDTO puntosUsuario;
	
	@Given("^Un usuario realiza una accion$")
	public void un_usuario_realiza_una_accion() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("user1Test", "user1Test"));
	}

	@When("^Consigue un objetivo$")
	public void consigue_un_objetivo() throws Throwable {
		puntosUsuario = new PuntosDTO("user1Test",150);
		assert(Broker.getInstanciaPuntos().actualizaPuntos(puntosUsuario));
	}

	@Then("^Gana puntos$")
	public void gana_puntos() throws Throwable {
		puntosUsuario = Broker.getInstanciaPuntos().getPuntos("user1Test");
		assert(!(puntosUsuario.getUsuario().equals("")));
	}
}
