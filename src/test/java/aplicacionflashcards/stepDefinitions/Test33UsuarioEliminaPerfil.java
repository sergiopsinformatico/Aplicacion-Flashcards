package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOPuntos;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test33UsuarioEliminaPerfil {
	
	
	UsuarioDTO user;
	UsuarioDTO user2;
	
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	InterfaceDAOPuntos dBPuntos;
	
	@Given("^Una persona quiere eliminar su perfil$")
	public void una_persona_quiere_eliminar_su_perfil() throws Throwable {
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBPuntos = Broker.getInstanciaPuntos();
		
		user = new UsuarioDTO("user1Test", "user1Test@email.com", "user1Test");
		user.setRol("Usuario");
		user.setNombreApellidos("Pepito");
		
		user2 = new UsuarioDTO("user3Test", "user3Test@email.com", "user3Test");
		user2.setRol("Usuario");
		user2.setNombreApellidos("Pepito");
		
		assert(dBUsuario.login(user.getEmail(), user.getClave()) && 
			   dBUsuario.login(user2.getEmail(), user2.getClave()));
	}

	@When("^Da a eliminar$")
	public void da_a_eliminar() throws Throwable {
	    assert(dBUsuario.deleteUsuario(user) && dBRelaciones.eliminaRelaciones(user.getUsername()) && dBPuntos.eliminarPuntos(user.getUsername()) &&
	    	   dBUsuario.deleteUsuario(user2) && dBRelaciones.eliminaRelaciones(user2.getUsername()));
	}

	@Then("^Elimina su perfil$")
	public void elimina_su_perfil() throws Throwable {
	    assert(!dBUsuario.existEmail(user.getEmail()) && !dBUsuario.existUsername(user.getUsername()) &&
	    	   !dBUsuario.existEmail(user2.getEmail()) && !dBUsuario.existUsername(user2.getUsername()));
	}
	
}