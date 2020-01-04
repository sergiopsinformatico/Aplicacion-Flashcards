package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test17UsuarioDesbloqueaUsuario {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user1;
	UsuarioDTO user2;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	boolean encontrado;
	int indice;
	List<String> lista;
	
	@Given("^Un usuario quiere desbloquear a uno bloqueado$")
	public void un_usuario_quiere_desbloquear_a_uno_bloqueado() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user3Test");
	    assert(user1!=null && user2!=null);
	}

	@When("^Lo desbloquea$")
	public void lo_desbloquea() throws Throwable {
	    dBRelaciones = Broker.getInstanciaRelaciones();
		assert(dBRelaciones.desbloquearUsuario("user1Test", "user3Test"));
	}

	@Then("^El usuario queda desbloqueado$")
	public void el_usuario_queda_desbloqueado() throws Throwable {
		encontrado = false;
	    lista = dBRelaciones.getBloqueadores("user3Test");
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user1Test")) {
	    		encontrado = true;
	    		indice= lista.size();
	    	}
	    }
	    if(!encontrado) {
	    	encontrado = false;
	    	lista = dBRelaciones.getBloqueados("user1Test");
	    	for(indice=0; indice<lista.size(); indice++) {
		    	if(lista.get(indice).equals("user3Test")) {
		    		encontrado = true;
		    		indice= lista.size();
		    	}
		    }
	    	assert(!encontrado);
	    }else {
	    	assert(false);
	    }	    
	}
}
