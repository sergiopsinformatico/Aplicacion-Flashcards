package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test03UsuarioVePerfil {
	UsuarioDTO user, user2;
	InterfaceDAOUsuario dBUsuario;
	
	@Given("^Una persona quiere ver su perfil$")
	public void una_persona_quiere_ver_su_perfil() throws Throwable {
	    dBUsuario = Broker.getInstanciaUsuario();
	    user = new UsuarioDTO("user1Test", "user1Test@email.com", "user1Test");
		user.setRol("Usuario");
	    assert(true);
	}
	
	@When("^Se ha logueado con el username$")
	public void se_loguea_con_el_username() throws Throwable {
	    assert(dBUsuario.login(user.getUsername(), user.getClave()));
	}
	
	@Then("^Ve el perfil con el username$")
	public void ve_el_perfil_con_el_username() throws Throwable {
	    user2 = dBUsuario.getUsuarioDTO(user.getUsername());
	    assert(user2.getClave().equals(user.getClave()));
	}

	@When("^Se ha logueado con el email$")
	public void se_loguea_con_el_email() throws Throwable {
		assert(dBUsuario.login(user.getEmail(), user.getClave()));
	}
	
	@Then("^Ve el perfil con el email$")
	public void ve_el_perfil_con_el_email() throws Throwable {
		user2 = dBUsuario.getUsuarioDTO(user.getEmail());
	    assert(user2.getClave().equals(user.getClave()));
	}
	
}