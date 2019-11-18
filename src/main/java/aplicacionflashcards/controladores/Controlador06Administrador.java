package main.java.aplicacionflashcards.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador06Administrador {
	
	//Variables
	ModelAndView vista;
	List<UsuarioDTO> listaUsuarios;
	List<ClubDTO> listaClubes;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAOClub dBClubes;
	UsuarioDTO userAntiguo;
	UsuarioDTO userNuevo;
	
	//Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_ADMIN = "Administrador";
	static final String CONST_GEST_USUARIO = "vistaGestionUsuarios";
	
	/*
	@GetMapping(value = "/panelAdministrador")
	public ModelAndView getPanelAdministrador(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			vista = new ModelAndView("vistaPanelAdministrador");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	@GetMapping(value = "/gestionUsuariosAdmin")
	public ModelAndView getGestionUsuariosAdmin(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			vista = new ModelAndView(CONST_GEST_USUARIO);
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
		
	@GetMapping(value = "/getUsuariosAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getUsuariosAdmin(@RequestParam("username") String username, HttpServletRequest request){
		
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			dBUsuario = Broker.getInstanciaUsuario();
			listaUsuarios = dBUsuario.getAllUsuarios(username);
			
		}else {
			listaUsuarios = new LinkedList<>();
		}
		
		return listaUsuarios;
		
	}
	
	@GetMapping(value = "/administradorCambiaRol")
	public ModelAndView administradorCambiaRol(@RequestParam("username") String username, @RequestParam("rol") String rol,
			HttpServletRequest request){
		
		vista = new ModelAndView(CONST_REDIRECT_INICIO);
		
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			vista = new ModelAndView(CONST_GEST_USUARIO);
			
			dBUsuario = Broker.getInstanciaUsuario();
			userAntiguo = dBUsuario.getUsuarioDTO(username);
			if(userAntiguo!=null) {
				userNuevo = userAntiguo;
				userNuevo.setRol(rol);
				dBUsuario.updateUsuario(userAntiguo, userNuevo);
			}
			
		}
		return vista;
		
	}
	
	@GetMapping(value = "/administradorEliminaUsuario")
	public ModelAndView administradorEliminaUsuario(@RequestParam("username") String username, HttpServletRequest request){
		
		vista = new ModelAndView(CONST_REDIRECT_INICIO);
		
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			vista = new ModelAndView(CONST_GEST_USUARIO);
			
			dBUsuario = Broker.getInstanciaUsuario();
			userAntiguo = dBUsuario.getUsuarioDTO(username);
			if(userAntiguo!=null) {
				dBUsuario.deleteUsuario(userAntiguo);
				Broker.getInstanciaRelaciones().eliminaRelaciones(userAntiguo.getUsername());
			}
			
		}
		
		return vista;
		
	}
	
	@GetMapping(value = "/gestionClubesAdmin")
	public ModelAndView gestionClubesAdmin(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			vista = new ModelAndView("vistaGestionClubes");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	@GetMapping(value = "/getClubesAdmin", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesAdmin(HttpServletRequest request){
		
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			dBClubes = Broker.getInstanciaClub();
			listaClubes = dBClubes.todosClubesCreados();
			
		}else {
			listaClubes = new LinkedList<>();
		}
		
		return listaClubes;
		
	}
	
	@GetMapping(value = "/administradorEliminaClub")
	public ModelAndView administradorEliminaClub(@RequestParam("idClub") String idClub, HttpServletRequest request){
		
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("") &&
				   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getRol().equals(CONST_ADMIN)) {
			
			dBClubes = Broker.getInstanciaClub();
			dBClubes.eliminaClub(idClub);
			vista = new ModelAndView("vistaGestionClubes");
			
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		
		return vista;
		
	}*/
}
