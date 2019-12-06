package main.java.aplicacionflashcards.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador04Perfil {
	
	//Variables
	ModelAndView vista;
	UsuarioDTO user;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelacion;
	//Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_MENSAJE = "mensaje";
	
	/*Ver Perfil*/
	@GetMapping(value = "/verPerfil")
	public ModelAndView verPerfil(@RequestParam("usuarioPerfil") String userPerfil, HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
			((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
			((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			dBUsuario = Broker.getInstanciaUsuario();
			user = dBUsuario.getUsuarioDTO(userPerfil);
			
			if(user != null) {
				vista = new ModelAndView("vistaPerfil");
				
				if(!(user.getUsername().equals(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()))){
					dBRelacion = Broker.getInstanciaRelaciones();
					user.setTipoRelacion(dBRelacion.tipoRelacion(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), user.getUsername()));
				}
				
				vista.addObject("perfil", user);
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