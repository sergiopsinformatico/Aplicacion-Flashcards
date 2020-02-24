package main.java.aplicacionflashcards.controladores;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.CheckUsers;
import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.auxiliares.MD5Photo;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador06Administrador {
	
	/* * * * * *  *
	 *  VARIABLES *
	 * * * * * *  */
	
	ModelAndView vista;
	List<UsuarioDTO> listaUsuarios;
	List<ClubDTO> listaClubes;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAOClub dBClubes;
	UsuarioDTO userAntiguo;
	UsuarioDTO userNuevo;
	Email email;
	MD5Photo md5Photo;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.aplicacionflashcards.controladores.Controlador06Administrador");
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_GEST_USUARIO = "vistaGestionUsuarios";
	
	//Panel Administrador
	@GetMapping(value = "/panelAdministrador")
	public ModelAndView getPanelAdministrador(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			vista = new ModelAndView("vistaPanelAdministrador");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	//Listar Usuarios
	@GetMapping(value = "/gestionUsuariosAdmin")
	public ModelAndView getGestionUsuariosAdmin(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
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
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
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
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
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
	
	@GetMapping(value = "/administradorGeneraNuevaClave")
	public ModelAndView administradorGeneraNuevaClave(@RequestParam("username") String username, HttpServletRequest request){
		
		vista = new ModelAndView(CONST_REDIRECT_INICIO);
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			vista = new ModelAndView(CONST_GEST_USUARIO);
			
			dBUsuario = Broker.getInstanciaUsuario();
			userAntiguo = dBUsuario.getUsuarioDTO(username);
			if(userAntiguo!=null) {
				userNuevo = userAntiguo;
				userNuevo.setClave(GeneratorStrings.randomString(8));
				if(dBUsuario.updateUsuario(userAntiguo, userNuevo)) {
					try {
						email = new Email();
						email.adminGeneraClave(userNuevo);
					}catch(Exception ex) {
						LOGGER.log(Level.INFO, ex.getMessage());
					}
				}
			}
			
		}
		return vista;
		
	}
	
	@GetMapping(value = "/administradorModificaPerfil")
	public ModelAndView administradorModificaPerfil(@RequestParam("username") String username, HttpServletRequest request){
		
		vista = new ModelAndView(CONST_REDIRECT_INICIO);
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			dBUsuario = Broker.getInstanciaUsuario();
			userNuevo = dBUsuario.getUsuarioDTO(username);
			
			if(userNuevo != null && 
			   (!userNuevo.getUsername().equals(""))) {
				vista = new ModelAndView("vistaAdminModificaPerfil");
				vista.addObject("usuarioModificar", userNuevo);
			}
			
			
		}
		return vista;
		
	}
	
	@PostMapping(value = "/modificaUsuarioAdministrador")
	public ModelAndView modificaUsuarioAdministrador(HttpServletRequest request, HttpServletResponse response) {
		userAntiguo = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("inputUsername"));
		
		userNuevo = new UsuarioDTO(request.getParameter("inputUsername"), 
								   request.getParameter("inputEmail"), 
								   request.getParameter("inputClave"));
		userNuevo.setEmailFoto(request.getParameter("inputEmailAvatar"));
		userNuevo.setRol(userAntiguo.getRol());
		userNuevo.setActivadaCuenta(userAntiguo.isActivadaCuenta());
		userNuevo.setNombreApellidos(request.getParameter("inputNyA"));
		userNuevo.setCiudad(request.getParameter("inputCiudad"));
		userNuevo.setPais(request.getParameter("inputPais"));
		
		
		if(userNuevo.getEmailFoto().equals("")) {
			userNuevo.setFoto("https://www.gravatar.com/avatar/inventado.jpg");
		}else {
			md5Photo = new MD5Photo();
			userNuevo.setFoto("https://www.gravatar.com/avatar/"+md5Photo.getMD5Photo(userNuevo.getEmailFoto())+".jpg");
		}
		
		Broker.getInstanciaUsuario().updateUsuario(userAntiguo, userNuevo);
		
		vista = new ModelAndView("redirect:/gestionUsuariosAdmin.html");
		return vista;
	}
	
	@GetMapping(value = "/administradorEliminaUsuario")
	public ModelAndView administradorEliminaUsuario(@RequestParam("username") String username, HttpServletRequest request){
		
		vista = new ModelAndView(CONST_REDIRECT_INICIO);
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			vista = new ModelAndView(CONST_GEST_USUARIO);
			
			dBUsuario = Broker.getInstanciaUsuario();
			userAntiguo = dBUsuario.getUsuarioDTO(username);
			if(userAntiguo!=null) {
				
				dBUsuario.deleteUsuario(userAntiguo);
				Broker.getInstanciaRelaciones().eliminaRelaciones(userAntiguo.getUsername());
				Broker.getInstanciaPuntos().eliminarPuntos(userAntiguo.getUsername());
				Broker.getInstanciaNotificaciones().deleteObjectNotificaciones(userAntiguo.getUsername());
			}
			
		}
		
		return vista;
		
	}
	
	//Listar Clubes
	@GetMapping(value = "/gestionClubesAdmin")
	public ModelAndView gestionClubesAdmin(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
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
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			dBClubes = Broker.getInstanciaClub();
			listaClubes = dBClubes.todosClubesCreados();
			
		}else {
			listaClubes = new LinkedList<>();
		}
		
		return listaClubes;
		
	}
	
	@GetMapping(value = "/administradorEliminaClub")
	public ModelAndView administradorEliminaClub(@RequestParam("idClub") String idClub, HttpServletRequest request){
		
		if(CheckUsers.isUsuarioLogueado(request) && CheckUsers.isAdministrador(request)) {
			
			dBClubes = Broker.getInstanciaClub();
			dBClubes.eliminaClub(idClub);
			vista = new ModelAndView("vistaGestionClubes");
			
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		
		return vista;
		
	}
}
