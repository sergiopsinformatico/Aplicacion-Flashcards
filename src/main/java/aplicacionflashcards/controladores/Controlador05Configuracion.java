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

import main.java.aplicacionflashcards.auxiliares.CheckUsers;
import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.MD5Photo;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.EliminarCuentaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador05Configuracion {
	
	/* * * * * * * *  *
	 *  CONFIGURACION *
	 * * * * * * * *  */
	
	ModelAndView vista;
	UsuarioDTO userAntiguo;
	UsuarioDTO userNuevo;
	Fecha fecha;
	Email email;
	EliminarCuentaDTO elimina;
	MD5Photo md5Photo;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_MENSAJE = "mensaje";
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.aplicacionflashcards.controladores.Controlador05Configuracion");
	
    //Obtener Configuracion
	@GetMapping(value = "/configuracion")
	public ModelAndView modificarPerfil(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			vista = new ModelAndView("vistaConfiguracion");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	//Modificar Usuarios
	@PostMapping(value = "/modificaUsuario")
	public ModelAndView modificaUsuario(HttpServletRequest request, HttpServletResponse response) {
		userAntiguo = (UsuarioDTO)request.getSession().getAttribute(CONST_USUARIO);
		
		userNuevo = new UsuarioDTO(request.getParameter("inputUsername"), 
								   request.getParameter("inputEmail"), 
								   request.getParameter("inputClave"));
		userNuevo.setNombreApellidos(request.getParameter("inputNyA"));
		userNuevo.setCiudad(request.getParameter("inputCiudad"));
		userNuevo.setPais(request.getParameter("inputPais"));
		userNuevo.setEmailFoto(request.getParameter("inputEmailAvatar"));
		userNuevo.setRol(userAntiguo.getRol());
		userNuevo.setActivadaCuenta(userAntiguo.isActivadaCuenta());
		
		
		if(userNuevo.getEmailFoto().equals("")) {
			userNuevo.setFoto("https://www.gravatar.com/avatar/inventado.jpg");
		}else {
			md5Photo = new MD5Photo();
			userNuevo.setFoto("https://www.gravatar.com/avatar/"+md5Photo.getMD5Photo(userNuevo.getEmailFoto())+".jpg");
		}
		
		if(Broker.getInstanciaUsuario().updateUsuario(userAntiguo, userNuevo)) {
			vista = new ModelAndView("redirect:/verPerfil.html?usuarioPerfil="+userNuevo.getUsername());
			vista.addObject(CONST_MENSAJE, "Perfil Actualizado");
			vista.addObject(CONST_USUARIO, userNuevo);
		}else {
			vista = new ModelAndView("redirect:/verPerfil.html?usuarioPerfil="+userNuevo.getUsername());
			vista.addObject(CONST_MENSAJE, "Hubo un fallo y no se pudo modificar el perfil");
		}
		return vista;
	}
	
	@GetMapping(value = "/modificaUsuario")
	public ModelAndView modificaUsuarioGet(HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/configuracion.html");
		return vista;
	}
	
	//Eliminar Cuenta
	@GetMapping(value = "/eliminarCuenta")
	public ModelAndView eliminarCuenta(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			fecha = new Fecha();
			elimina = new EliminarCuentaDTO(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), fecha.fechaEliminarCuenta());
			
			Broker.getInstanciaEliminarCuenta().insertaEliminado(elimina);
			
			try {
				
				email = new Email();
				email.eliminarCuenta(elimina, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getEmail());
				
			}catch(Exception ex) {
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
			vista.addObject(CONST_MENSAJE,"Su cuenta se eliminara de forma definitiva en 14 dias.");
			vista.addObject(CONST_USUARIO, null);
			request.getSession().setAttribute(CONST_USUARIO, null);
			
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
}
