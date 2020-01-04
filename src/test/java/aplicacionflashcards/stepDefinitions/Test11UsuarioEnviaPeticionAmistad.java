package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test11UsuarioEnviaPeticionAmistad {
	
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	UsuarioDTO user1;
	UsuarioDTO user2;
	List<String> lista;
	boolean encontrado;
	int indice;
	
	@Given("^Un usuario conoce a otro$")
	public void un_usuario_conoce_a_otro() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user3Test");
	    assert(user1!=null && user2!=null);
	}

	@When("^Envia una peticion de amistad$")
	public void envia_una_peticion_de_amistad() throws Throwable {
	    dBRelaciones = Broker.getInstanciaRelaciones();
	    assert(dBRelaciones.enviarPeticionAmistad(user1.getUsername(), user2.getUsername()));
	}

	@Then("^El otro usuario recibe una peticion de amistad$")
	public void el_otro_usuario_recibe_una_peticion_de_amistad() throws Throwable {
		encontrado = false;
	    lista = dBRelaciones.getPeticionesRecibidas(user2.getUsername());
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals(user1.getUsername())) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    assert(encontrado);
	}
}
