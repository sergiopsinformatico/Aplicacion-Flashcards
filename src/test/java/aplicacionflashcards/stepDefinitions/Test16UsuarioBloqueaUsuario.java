package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test16UsuarioBloqueaUsuario {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user1;
	UsuarioDTO user2;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	List<String> lista;
	boolean encontrado;
	int indice;
	
	@Given("^Un usuario no quiere que otro usuario sea su amigo$")
	public void un_usuario_no_quiere_que_otro_usuario_sea_su_amigo() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user3Test");
	    assert(user1!=null && user2!=null);
	}

	@When("^Bloquea$")
	public void bloquea() throws Throwable {
	    dBRelaciones = Broker.getInstanciaRelaciones();
	    assert(dBRelaciones.bloquearUsuario("user1Test", "user3Test"));
	}

	@Then("^El usuario bloqueado no ve su perfil$")
	public void el_usuario_bloqueado_no_ver_su_perfil() throws Throwable {
		encontrado = false;
	    lista = dBRelaciones.getBloqueadores("user3Test");
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user1Test")) {
	    		encontrado = true;
	    		indice= lista.size();
	    	}
	    }
	    if(encontrado) {
	    	encontrado = false;
	    	lista = dBRelaciones.getBloqueados("user1Test");
	    	for(indice=0; indice<lista.size(); indice++) {
		    	if(lista.get(indice).equals("user3Test")) {
		    		encontrado = true;
		    		indice= lista.size();
		    	}
		    }
	    	assert(encontrado);
	    }else {
	    	assert(false);
	    }	    
	}
}
