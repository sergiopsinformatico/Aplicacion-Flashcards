package test.java.aplicacionflashcards.stepDefinitions;

import java.util.LinkedList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.RelacionesUsuariosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test14UsuarioRechazaPeticionAmistad {
	
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	UsuarioDTO user1;
	UsuarioDTO user2;
	RelacionesUsuariosDTO relacion;
	List<String> lista;
	int indice;
	boolean encontrado;
	
	@Given("^Un usuario recibe una peticion de amistad$")
	public void un_usuario_recibe_una_peticion_de_amistad() throws Throwable {
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		
		user2 = new UsuarioDTO("user4Test", "user4Test@email.com", "user4Test");
		user2.setRol("Usuario");
		relacion = new RelacionesUsuariosDTO("user4Test", new LinkedList<String>(),
											 new LinkedList<String>(), new LinkedList<String>(),
											 new LinkedList<String>(), new LinkedList<String>());
		dBUsuario.insertUsuario(user2);
		dBRelaciones.creaRelaciones(relacion);
		
		user2 = null;
		
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user4Test");
	    
	    assert(user1!=null && user2!=null && 
	    	   dBRelaciones.enviarPeticionAmistad(user1.getUsername(), user2.getUsername()));
	}

	@When("^Rechaza la peticion$")
	public void rechaza_la_peticion() throws Throwable {
	    lista = dBRelaciones.getPeticionesRecibidas("user4Test");
	    encontrado = false;
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user1Test")) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    if(encontrado) {
	    	assert(dBRelaciones.rechazarInvitacion("user4Test", "user1Test"));
	    }else {
	    	assert(false);
	    }
	}

	@Then("^No son amigos$")
	public void no_son_amigos() throws Throwable {
		encontrado = false;
	    lista = dBRelaciones.getAmigos("user1Test");
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user4Test")) {
	    		indice = lista.size();
	    		encontrado = true;
	    	}
	    }
	    if(encontrado) {
	    	dBUsuario.deleteUsuario(dBUsuario.getUsuarioDTO("user4Test"));
	    	dBRelaciones.eliminaRelaciones("user4Test");
	    	assert(false);
	    }else {
	    	lista = dBRelaciones.getAmigos("user4Test");
	    	for(indice=0; indice<lista.size(); indice++) {
	    		if(lista.get(indice).equals("user1Test")) {
	    			encontrado = true;
	    			indice = lista.size();
	    		}
	    	}
	    	dBUsuario.deleteUsuario(dBUsuario.getUsuarioDTO("user4Test"));
	    	dBRelaciones.eliminaRelaciones("user4Test");
	    	assert(!encontrado);
	    }
	   
	}
}
