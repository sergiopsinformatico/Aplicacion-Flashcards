package main.java.aplicacionflashcards.auxiliares;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.SessionAttributes;

import main.java.aplicacionflashcards.dto.UsuarioDTO;

@SessionAttributes("usuario")
public class CheckUsers {
	
	/* * * * * * * * * * * *  *
	 *  Comprobacion de Roles *
	 * * * * * * * * * * * *  */
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String USUARIO = "usuario";
	
	/* * * * * * * * 
     * CONSTRUCTOR *
	 * * * * * * * */
	
	private CheckUsers() {}
	
	/* * * * * * 
     * METODOS *
	 * * * * * */
	
	public static boolean isUsuarioNoLogueado(HttpServletRequest request) {
		return (request.getSession().getAttribute(USUARIO)==null || 
			   ((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getUsername()==null||
			   ((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getUsername().equals(""));
	}
	
	public static boolean isUsuarioLogueado(HttpServletRequest request) {
		return (request.getSession().getAttribute(USUARIO)!=null && 
			   ((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getUsername()!=null && 
			   (!((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getUsername().equals("")));
	}
	
	public static boolean isAdministrador(HttpServletRequest request) {
		return ((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getRol().equals("Administrador");
	}
	
	public static boolean isModerador(HttpServletRequest request) {
		return ((UsuarioDTO)(request.getSession().getAttribute(USUARIO))).getRol().equals("Moderador");
	}
	
	
	
}
