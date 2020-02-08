package main.java.aplicacionflashcards.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.EliminarCuentaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador03ControlSesion {
	
	
	/* * * * * * * 
     * VARIABLES *
	 * * * * * * */
	
	ModelAndView vista;
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user;
	EliminarCuentaDTO eliminado;
	Email email;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.aplicacionflashcards.controladores.Controlador03ControlSesion");
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	
	
	/* * * * * * * * * 
     * CONTROLADORES *
	 * * * * * * * * */	
	
	/* * * * * * * * * * * * * * * * * * * * * *
	 * FUNCIONALIDAD 1: IR A PAGINA PRINCIPAL  *
	 * * * * * * * * * * * * * * * * * * * * * */
	
	/*Control pagina principal de logueado y no logueado*/
	@GetMapping(value = "/inicio")
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("usuario")==null || 
		   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()==null||
		   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals("")) {
			vista = new ModelAndView("index");
			if(request.getParameter("mensaje")!= null && (!request.getParameter("mensaje").equals(""))) {
				vista.addObject("mensaje", request.getParameter("mensaje"));
			}
		}else {
			vista =  new ModelAndView("vistaPrincipal");
			if(request.getParameter("mensaje")!= null && (!request.getParameter("mensaje").equals(""))) {
				vista.addObject("mensaje", request.getParameter("mensaje"));
			}
		}
		return vista;
	}	
	
	/* * * * * * * * * * * * *  * * * * *
	 * FUNCIONALIDAD 2: INICIAR SESION  *
	 * * * * * * * * * * * * *  * * * * */
	
	//Obtener la vista de Inicio de Sesion
	@GetMapping(value = "/iniciarSesion")
	public ModelAndView iniciarSesion(HttpServletRequest request, HttpServletResponse response) {
		
		//1-Comprobar activaciones caducadas
		Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
		
		//2-Eliminar cuentas pasados 14 dias
		Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
		
		//3-Eliminar solicitudes de restablecimiento de Claves
		Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
				
		if(request.getSession().getAttribute("usuario")==null || 
		   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()==null||
		   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals("")) {
			
			vista =  new ModelAndView("vistaIniciarSesion");
			
			if(request.getParameter("mensaje")!= null && (!request.getParameter("mensaje").equals(""))) {
				vista.addObject("mensaje", request.getParameter("mensaje"));
			}
			
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
			
		}
		
		return vista;
	}
	
	
	
	//Acceder
	@PostMapping(value = "/iniciarSesion")
	public ModelAndView loguearPost(HttpServletRequest request, HttpServletResponse response) {
		dBUsuario = Broker.getInstanciaUsuario();
		if(dBUsuario.login(request.getParameter("inputUsernameEmail"), request.getParameter("inputClave"))) {
			user = dBUsuario.getUsuarioDTO(request.getParameter("inputUsernameEmail"));
			
			if(user.isActivadaCuenta()) {
				eliminado = new EliminarCuentaDTO(user.getUsername());
				vista = new ModelAndView("redirect:/inicio.html");
				if(Broker.getInstanciaEliminarCuenta().leerEliminado(eliminado)) {
					Broker.getInstanciaEliminarCuenta().eliminarEliminado(eliminado);
					vista.addObject("mensaje", "Su cuenta ha sido reactivada");
					
					try {
						email = new Email();
						email.reactivacionCuenta(user);
					}catch(Exception ex) {
						LOGGER.log(Level.INFO, ex.getMessage());
					}
					
				}
				vista.addObject("usuario", user);
			}else {
				vista = new ModelAndView("vistaIniciarSesion");
				vista.addObject("mensaje", "Su cuenta aun no ha sido activada. Por favor, revise su email para activar la cuenta.");
			}
		}else {
			vista = new ModelAndView("vistaIniciarSesion");
			vista.addObject("mensaje", "El usuario y/o la clave son incorrectos.");
		}
		return vista;
	}
	
	/* * * * * * * * * * * * *  * * * * *
	 * FUNCIONALIDAD 3: CERRAR SESION   *
	 * * * * * * * * * * * * *  * * * * */
	
	@GetMapping(value = "/cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request, HttpServletResponse response) {	
		vista = new ModelAndView("redirect:/inicio.html");
		request.getSession().setAttribute("usuario", null);
		vista.addObject("usuario",null);
		return vista;
	}
	
}