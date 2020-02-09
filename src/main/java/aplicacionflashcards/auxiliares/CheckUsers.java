package main.java.aplicacionflashcards.auxiliares;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.SessionAttributes;

import main.java.aplicacionflashcards.dto.UsuarioDTO;

@SessionAttributes("usuario")
public class CheckUsers {
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	//static final String USUARIO = "usuario";
	
	public static boolean isUsuarioNoLogueado(HttpServletRequest request) {
		return (request.getSession().getAttribute("usuario")==null || 
			   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()==null||
			   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals(""));
	}
	
	public static boolean isUsuarioLogueado(HttpServletRequest request) {
		return (request.getSession().getAttribute("usuario")!=null && 
			   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()!=null && 
			   (!((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername().equals("")));
	}
	
	public static boolean isAdministrador(HttpServletRequest request) {
		return ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getRol().equals("Administrador");
	}
	
	public static boolean isModerador(HttpServletRequest request) {
		return ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getRol().equals("Moderador");
	}
	
	
	
}
