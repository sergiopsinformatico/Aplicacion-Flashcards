package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test05AdministradorCambiaRol {
	
	InterfaceDAOUsuario dBUsuario;
	
	UsuarioDTO admin;
	UsuarioDTO user;
	UsuarioDTO user2;
	
	@Given("^Un administrador quiere cambiar el rol de un usuario$")
	public void un_administrador_quiere_cambiar_el_rol_de_un_usuario() throws Throwable {
		dBUsuario = Broker.getInstanciaUsuario();
		
		user = new UsuarioDTO("user2Test", "user2Test@email.com", "user2Test");
		user.setRol("Usuario");
		
		admin = new UsuarioDTO("adminTest", "adminTest@email.com", "adminTest");
		admin.setRol("Administrador");
		
	    assert(dBUsuario.insertUsuario(user) && 
	    	   dBUsuario.insertUsuario(admin)); 
	}

	@When("^Localiza a ese usuario$")
	public void localiza_a_ese_usuario() throws Throwable {
		user2 = dBUsuario.getUsuarioDTO("user2Test");
		user2.setRol("Moderador");
	    assert(dBUsuario.updateUsuario(user, user2));
	}

	@Then("^Cambia su rol$")
	public void cambia_su_rol() throws Throwable {
	    user = dBUsuario.getUsuarioDTO("user2Test");
	    assert(user.getRol().equals("Moderador"));
	}
}
