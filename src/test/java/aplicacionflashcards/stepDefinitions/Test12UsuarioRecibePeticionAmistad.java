package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test12UsuarioRecibePeticionAmistad {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user1;
	UsuarioDTO user2;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	boolean encontrado;
	List<String> lista;
	int indice;
	
	@Given("^Un usuario del sistema$")
	public void un_usuario_del_sistema() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user3Test");
	    assert(user1!=null && user2!=null);
	}

	@When("^Otro usuario le haya enviado una peticion de amistad$")
	public void otro_usuario_le_haya_enviado_una_peticion_de_amistad() throws Throwable {
		dBRelaciones = Broker.getInstanciaRelaciones();
	    lista = dBRelaciones.getPeticionesAmistadEnviadas(user1.getUsername());
	    encontrado = false;
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals(user2.getUsername())) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    assert(encontrado);
	}

	@Then("^Este usuario la recibe$")
	public void este_usuario_la_recibe() throws Throwable {
		lista = dBRelaciones.getPeticionesRecibidas(user2.getUsername());
	    encontrado = false;
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals(user1.getUsername())) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    assert(encontrado);
	}
}
