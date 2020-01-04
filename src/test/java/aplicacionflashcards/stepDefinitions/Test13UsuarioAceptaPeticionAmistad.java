package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test13UsuarioAceptaPeticionAmistad {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	List<String> lista;
	int indice;
	boolean encontrado;
	
	@Given("^Un usuario recibe una peticion$")
	public void un_usuario_recibe_una_peticion() throws Throwable {
	    dBRelaciones = Broker.getInstanciaRelaciones();
	    dBUsuario = Broker.getInstanciaUsuario();
	    user = dBUsuario.getUsuarioDTO("user3Test");
	    if(user!=null) {
	    	encontrado = false;
	    	lista = dBRelaciones.getPeticionesRecibidas(user.getUsername());
	    	for(indice=0; indice<lista.size(); indice++) {
	    		if(lista.get(indice).equals("user1Test")) {
	    			encontrado = true;
	    			indice = lista.size();
	    		}
	    	}
	    	assert(encontrado);
	    }else {
	    	assert(false);
	    }	    
	}

	@When("^Acepta la peticion$")
	public void acepta_la_peticion() throws Throwable {
	    assert(dBRelaciones.aceptarInvitacion("user3Test", "user1Test"));
	}

	@Then("^Son amigos$")
	public void son_amigos() throws Throwable {
	    encontrado = false;
	    lista = dBRelaciones.getAmigos("user1Test");
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user3Test")) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    if(encontrado) {
	    	encontrado = false;
	    	lista = dBRelaciones.getAmigos("user3Test");
	    	for(indice=0; indice<lista.size(); indice++) {
		    	if(lista.get(indice).equals("user1Test")) {
		    		encontrado = true;
		    		indice = lista.size();
		    	}
		    }
		    assert(encontrado);
	    }else {
	    	assert(false);
	    }
	    
	}
}
