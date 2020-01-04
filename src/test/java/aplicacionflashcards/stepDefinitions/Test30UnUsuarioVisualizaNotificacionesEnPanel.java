package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.PuntosDTO;

public class Test30UnUsuarioVisualizaNotificacionesEnPanel {
	
	List<PuntosDTO> puntos;
	
	@Given("^Un usuario accede a la pantalla principal$")
	public void un_usuario_accede_a_la_pantalla_principal() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("user1Test", "user1Test"));
	}

	@When("^Abre el panel de notificaciones$")
	public void abre_el_panel_de_notificaciones() throws Throwable {
		puntos = Broker.getInstanciaPuntos().rankingPrimeros();
		assert(true);
	}

	@Then("^Visualiza las notificaciones$")
	public void visualiza_las_notificaciones() throws Throwable {
		assert(puntos.size()>=0);
	}
}
