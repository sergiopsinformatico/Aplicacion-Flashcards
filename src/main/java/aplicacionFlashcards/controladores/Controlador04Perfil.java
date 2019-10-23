package main.java.aplicacionFlashcards.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionFlashcards.broker.Broker;
import main.java.aplicacionFlashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionFlashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador04Perfil {
	
	//Variables
		ModelAndView vista;
		UsuarioDTO user;
		InterfaceDAOUsuario dBUsuario;
		
		/*Constantes
		static final String CONST_USUARIO = "usuario";
		static final String CONST_MENSAJE = "mensaje";*/
		
		//Ver Perfil
		@RequestMapping(value = "/verPerfil", method = RequestMethod.GET)
		public ModelAndView verPerfil(@RequestParam("usuarioPerfil") String userPerfil, HttpServletRequest request, HttpServletResponse response) {
			if(request.getSession().getAttribute("usuario")!=null && 
				((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()!=null && 
				((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()!="") {
				
				dBUsuario = Broker.getInstanciaUsuario();
				user = dBUsuario.getUsuarioDTO(userPerfil);
				
				if(user != null) {
					vista = new ModelAndView("vistaPerfil");					
					vista.addObject("perfil", user);
					if(request.getParameter("mensaje")!= null && (!request.getParameter("mensaje").equals(""))) {
						vista.addObject("mensaje", request.getParameter("mensaje"));
					}
				}else {
					vista = new ModelAndView("redirect:/inicio.html");
				}
				
			}else {
				vista = new ModelAndView("redirect:/inicio.html");
			}
			return vista;
		}
}