package main.java.aplicacionflashcards.controladores;

import java.security.MessageDigest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.EliminarCuentaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador05Configuracion {
	
	//Variables
	ModelAndView vista;
	UsuarioDTO userAntiguo;
	UsuarioDTO userNuevo;
	Fecha fecha;
	Email email;
	EliminarCuentaDTO elimina;
	
	/*Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_MENSAJE = "mensaje";
	*/
	
	@GetMapping(value = "/configuracion")
	public ModelAndView modificarPerfil(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute("usuario")!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()!=null && 
		   (!((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals(""))) {
			
			vista = new ModelAndView("vistaConfiguracion");
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	@PostMapping(value = "/modificaUsuario")
	public ModelAndView modificaUsuario(HttpServletRequest request, HttpServletResponse response) {
		userAntiguo = (UsuarioDTO)request.getSession().getAttribute("usuario");
		
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
			userNuevo.setFoto("https://www.gravatar.com/avatar/"+getMD5Photo(userNuevo.getEmailFoto())+".jpg");
		}
		
		if(Broker.getInstanciaUsuario().updateUsuario(userAntiguo, userNuevo)) {
			vista = new ModelAndView("redirect:/verPerfil.html?usuarioPerfil="+userNuevo.getUsername());
			vista.addObject("mensaje", "Perfil Actualizado");
			vista.addObject("usuario", userNuevo);
		}else {
			vista = new ModelAndView("redirect:/verPerfil.html?usuarioPerfil="+userNuevo.getUsername());
			vista.addObject("mensaje", "Hubo un fallo y no se pudo modificar el perfil");
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
		if(request.getSession().getAttribute("usuario")!=null && 
		  ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()!=null && 
		  ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals("")) {
			
			fecha = new Fecha();
			elimina = new EliminarCuentaDTO(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername(), fecha.fechaEliminarCuenta());
			
			Broker.getInstanciaEliminarCuenta().insertaEliminado(elimina);
			
			try {
				/*
				email = new Email();
				email.eliminarCuenta(elimina, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getEmail());
				*/
			}catch(Exception ex) {
				
			}
			
			vista = new ModelAndView("redirect:/inicio.html");
			vista.addObject("mensaje","Su cuenta se eliminara de forma definitiva en 14 dias.");
			vista.addObject("usuario", null);
			request.getSession().setAttribute("usuario", null);
			
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	private String getMD5Photo(String photoFile){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(photoFile.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< bytes.length ;i++){
	            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	        }
			return sb.toString();
		}catch(Exception ex) {
			return "inventado";
		}
	}
}
