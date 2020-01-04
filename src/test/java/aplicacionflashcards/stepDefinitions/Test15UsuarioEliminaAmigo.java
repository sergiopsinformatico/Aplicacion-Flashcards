package test.java.aplicacionflashcards.stepDefinitions;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test15UsuarioEliminaAmigo {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user1;
	UsuarioDTO user2;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	boolean encontrado;
	List<String> lista;
	int indice;
	
	@Given("^Un usuario no quiere tener a un usuario de amigo$")
	public void un_usuario_no_quiere_tener_a_un_usuario_de_amigo() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user1 = dBUsuario.getUsuarioDTO("user1Test");
	    user2 = dBUsuario.getUsuarioDTO("user3Test");
	    dBRelaciones = Broker.getInstanciaRelaciones();
	    assert(user1!=null && user2!=null);
	}

	@When("^Elimina al amigo$")
	public void elimina_al_amigo() throws Throwable {
	    assert(dBRelaciones.eliminarAmigo("user1Test", "user3Test"));
	}

	@Then("^Ya no son amigos$")
	public void ya_no_son_amigos() throws Throwable {
	    lista = dBRelaciones.getAmigos("user1Test");
	    encontrado = false;
	    for(indice=0; indice<lista.size(); indice++) {
	    	if(lista.get(indice).equals("user3Test")) {
	    		encontrado = true;
	    		indice = lista.size();
	    	}
	    }
	    if(encontrado) {
	    	assert(false);
	    }else {
	    	lista = dBRelaciones.getAmigos("user3Test");
		    encontrado = false;
		    for(indice=0; indice<lista.size(); indice++) {
		    	if(lista.get(indice).equals("user1Test")) {
		    		encontrado = true;
		    		indice = lista.size();
		    	}
		    }
		    assert(!encontrado);
	    }
	}
}
