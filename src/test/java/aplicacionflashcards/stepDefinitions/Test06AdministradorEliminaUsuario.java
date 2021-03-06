package test.java.aplicacionflashcards.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

public class Test06AdministradorEliminaUsuario {
	
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO admin;
	UsuarioDTO user;
	UsuarioDTO user2;
	
	@Given("^Un administrador quiere eliminar a un usuario$")
	public void un_administrador_quiere_eliminar_a_un_usuario() throws Throwable {
		dBUsuario = Broker.getInstanciaUsuario();
		user = dBUsuario.getUsuarioDTO("user2Test");
		admin = dBUsuario.getUsuarioDTO("adminTest");
	    assert(admin.getRol().equals("Administrador") && user!=null); 
	}

	@When("^Encuentra a ese usuario$")
	public void encuentra_a_ese_usuario() throws Throwable {
	    assert(dBUsuario.deleteUsuario(user));
	}

	@Then("^Le elimina del sistema$")
	public void le_elimina_del_sistema() throws Throwable {
		user = dBUsuario.getUsuarioDTO("user2Test");
		dBUsuario.deleteUsuario(admin);
		assert(user == null);
	}
}