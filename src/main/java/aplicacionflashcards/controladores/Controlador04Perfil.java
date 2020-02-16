package main.java.aplicacionflashcards.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.CheckUsers;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOFlashcards;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOPuntos;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador04Perfil {
	
	/* * * * * * * 
     * VARIABLES *
	 * * * * * * */
	
	
	ModelAndView vista;
	UsuarioDTO user;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelacion;
	InterfaceDAOPuntos dBPuntos;
	InterfaceDAOFlashcards dBFlashcards;
		
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_MENSAJE = "mensaje";
	
	/*Ver Perfil*/
	@GetMapping(value = "/verPerfil")
	public ModelAndView verPerfil(@RequestParam("usuarioPerfil") String userPerfil, HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			dBUsuario = Broker.getInstanciaUsuario();
			user = dBUsuario.getUsuarioDTO(userPerfil);
			
			if(user != null) {
				vista = new ModelAndView("vistaPerfil");
				
				if(!(user.getUsername().equals(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()))){
					dBRelacion = Broker.getInstanciaRelaciones();
					user.setTipoRelacion(dBRelacion.tipoRelacion(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername(), user.getUsername()));
				}
				
				vista.addObject("perfil", user);
				
				//Puntos
				dBPuntos = Broker.getInstanciaPuntos();
				vista.addObject("userPuntos", dBPuntos.getPuntos(user.getUsername()).getPuntos());
				
				//Numero Amigos
				dBRelacion = Broker.getInstanciaRelaciones();
				vista.addObject("userAmigos", dBRelacion.getAmigos(user.getUsername()).size());
				
				//Numero Colecciones Creadas
				dBFlashcards = Broker.getInstanciaFlashcards();
				vista.addObject("userColecciones", dBFlashcards.coleccionesCreadasVisibles(user.getUsername()).size());
				
				if(request.getParameter(CONST_MENSAJE)!= null && (!request.getParameter(CONST_MENSAJE).equals(""))) {
					vista.addObject(CONST_MENSAJE, request.getParameter(CONST_MENSAJE));
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