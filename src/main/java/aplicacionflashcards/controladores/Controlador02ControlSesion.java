package main.java.aplicacionflashcards.controladores;

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
public class Controlador02ControlSesion {
	ModelAndView vista;
	InterfaceDAOUsuario dBUsuario;
	UsuarioDTO user;
	EliminarCuentaDTO eliminado;
	Email email;
	
	//Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_MENSAJE = "mensaje";
	static final String CONST_VIEW_IS = "vistaIniciarSesion";
	static final String CONST_REDIRECT = "redirect:/inicio.html";
	
	//Index o pagina principal logueado
	@GetMapping(value = "/inicio")
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)==null || 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()==null||
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			vista = new ModelAndView("index");
			if(request.getParameter(CONST_MENSAJE)!= null && (!request.getParameter(CONST_MENSAJE).equals(""))) {
				vista.addObject(CONST_MENSAJE, request.getParameter(CONST_MENSAJE));
			}
		}else {
			vista =  new ModelAndView("vistaPrincipal");
			if(request.getParameter(CONST_MENSAJE)!= null && (!request.getParameter(CONST_MENSAJE).equals(""))) {
				vista.addObject(CONST_MENSAJE, request.getParameter(CONST_MENSAJE));
			}
		}
		return vista;
	}
	
	//Iniciar Sesion
	@GetMapping(value = "/acceder")
	public ModelAndView iniciarSesion(HttpServletRequest request, HttpServletResponse response) {
		
		//Comprobaciones
		
		//1-Comprobar activaciones caducadas
		Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
		
		//2-Eliminar cuentas pasados 14 dias
		Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
		
		//3-Eliminar solicitudes de restablecimiento de Claves
		Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
		
		//Vista Iniciar Sesion
		
		if(request.getSession().getAttribute(CONST_USUARIO)==null || 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()==null||
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista =  new ModelAndView(CONST_VIEW_IS);
			
			if(request.getParameter(CONST_MENSAJE)!= null && (!request.getParameter(CONST_MENSAJE).equals(""))) {
				vista.addObject(CONST_MENSAJE, request.getParameter(CONST_MENSAJE));
			}
			
		}else {
			vista = new ModelAndView(CONST_REDIRECT);
			
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
				vista = new ModelAndView(CONST_REDIRECT);
				if(Broker.getInstanciaEliminarCuenta().leerEliminado(eliminado)) {
					Broker.getInstanciaEliminarCuenta().eliminarEliminado(eliminado);
					vista.addObject(CONST_MENSAJE, "Su cuenta ha sido reactivada");
					email = new Email();
					email.reactivacionCuenta(user);
				}
				vista.addObject(CONST_USUARIO, user);
			}else {
				vista = new ModelAndView(CONST_VIEW_IS);
				vista.addObject(CONST_MENSAJE, "Su cuenta aun no ha sido activada. Por favor, revise su email para activar la cuenta.");
			}
		}else {
			vista = new ModelAndView(CONST_VIEW_IS);
			vista.addObject(CONST_MENSAJE, "El usuario y/o la clave son incorrectos.");
		}
		return vista;
	}
	
	//Cerrar Sesion
	@GetMapping(value = "/cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request, HttpServletResponse response) {	
		vista = new ModelAndView(CONST_REDIRECT);
		request.getSession().setAttribute(CONST_USUARIO, null);
		vista.addObject(CONST_USUARIO,null);
		return vista;
	}
}