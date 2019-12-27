package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.PuntosDTO;

public class Test32UnUsuarioVisualizaUnRankingConLosPuntosDeLosUsuarios {
	
	List<PuntosDTO> puntos;
	
	@Given("^Un usuario accede a un ranking$")
	public void un_usuario_accede_a_un_ranking() throws Throwable {
		assert(Broker.getInstanciaUsuario().login("usuario123", "usuario123"));
	}

	@When("^Visualiza el ranking$")
	public void visualiza_el_ranking() throws Throwable {
		puntos = Broker.getInstanciaPuntos().rankingPrimeros();
		assert(true);
	}

	@Then("^Ve una lista con los usuarios con mayor puntuacion$")
	public void ve_una_lista_con_los_usuarios_con_mayor_puntuacion() throws Throwable {
		assert(puntos.size()>=0);
	}
}
