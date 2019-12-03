package main.java.aplicacionflashcards.controladores;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionflashcards.dto.RelacionesUsuariosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@RestController
@SessionAttributes("usuario")
public class Controlador01RegistroUsuarios {
	
	//Variables
	List<String> listaUsernames;
	List<String> listaEmails;
	ModelAndView vista;
	UsuarioDTO user;
	UsuarioDTO user2;
	RelacionesUsuariosDTO relacion;
	Fecha fecha;
	String codigoActivacion;
	Email correo;
	/*Constantes*/
	static final String CONST_USUARIO = "usuario";
	static final String CONST_MENSAJE = "mensaje";
	static final String CONST_REDIRECT_IS = "redirect:/iniciarSesion.html";
	static final String CONST_INPUT_EMAIL_AVATAR = "inputEmailAvatar";
	static final String CONST_INPUT_NYA = "inputNyA";
	static final String CONST_INPUT_CIUDAD = "inputCiudad";
	static final String CONST_INPUT_PAIS = "inputPais";
	
	/* * * * * * * * * * * * * *
	 *  REGISTRO DE USUARIOS   *
	 * * * * * * * * * * * * * */
	
	//Obtener la vista de registro
	
	@GetMapping(value = "/registro")
	public ModelAndView registroGet(HttpServletRequest request, HttpServletResponse response) {
				
		//1-Comprobar activaciones caducadas
		Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
		//2-Eliminar cuentas pasados 14 dias
		Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
		//3-Eliminar solicitudes de restablecimiento de Claves
		Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
		
		if(request.getSession().getAttribute(CONST_USUARIO)==null || 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()==null||
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista = new ModelAndView("vistaRegistro");
			
			if(request.getParameter(CONST_MENSAJE)!= null && (!request.getParameter(CONST_MENSAJE).equals(""))) {
				vista.addObject(CONST_MENSAJE, request.getParameter(CONST_MENSAJE));
			}
			
		}else {
			
			vista = new ModelAndView("redirect:/inicio.html");
			
		}
		
		return vista;
	}
	
	// Metodo auxiliar para obtener los usernames de los usuarios
	@GetMapping(value = "/getUsernames", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> listUsernames(){
		listaUsernames = Broker.getInstanciaUsuario().getListUsername();
		listaUsernames.add("usuario123");
		listaUsernames.add("usuario456");
		return listaUsernames;
	}	
	
	//Metodo auxiliar para obtener los emails de los usuarios
	@GetMapping(value = "/getEmails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> listEmails(){
		listaEmails = Broker.getInstanciaUsuario().getListEmail();
		listaEmails.add("usuario123@email.com");
		listaEmails.add("usuario456@email.com");
		return listaEmails;
	}
	
	//Crear usuario - POST
	@PostMapping(value = "/crearCuenta")
	public ModelAndView registrarUsuarioPost(HttpServletRequest request, HttpServletResponse response) {
		
		user = new UsuarioDTO(request.getParameter("inputUsername"),
							  request.getParameter("inputEmail"),
							  request.getParameter("inputClave"));
		
		user.setNombreApellidos("");
		user.setCiudad("");
		user.setPais("");
		user.setFoto("");
		user.setEmailFoto("");
		user.setRol("Usuario");
		user.setActivadaCuenta(false);
		
		relacion = new RelacionesUsuariosDTO(user.getUsername(), new LinkedList<String>(),  new LinkedList<String>(),
				new LinkedList<String>(),  new LinkedList<String>(),  new LinkedList<String>());
		
		fecha = new Fecha();
		codigoActivacion = GeneratorStrings.randomString(15);
		
		if(Broker.getInstanciaUsuario().insertUsuario(user) &&
		   Broker.getInstanciaActivaCuenta().insertaAC(new ActivaCuentaDTO(user.getUsername(), codigoActivacion, fecha.fechaActivarCuenta())) &&
		   Broker.getInstanciaRelaciones().creaRelaciones(relacion)) {
			
			correo = new Email();
			correo.activarCuenta(user,PropertiesConfig.getProperties("baseURL")+"/activaCuenta.html?username="+user.getUsername()+"&codigo="+codigoActivacion);
			
			vista = new ModelAndView("vistaIniciarSesion");
			vista.addObject(CONST_MENSAJE, "Para finalizar el registro, revise su email "+user.getEmail()+" y siga los pasos para activar la cuenta.");
			
		}else {
			
			vista = new ModelAndView("vistaRegistro");
			vista.addObject(CONST_MENSAJE, "Hubo un fallo en el registro. Por favor, vuelva a intentar registrarse pasado unos minutos.");
			
		}
		
		return vista;
	}
	
	//Crear usuario - GET
	@GetMapping(value = "/crearCuenta")
	public ModelAndView registrarUsuarioGet(HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/registro.html");
		return vista;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
		
	//Activar Cuenta - GET
	@GetMapping(value = "/activaCuenta")
	public ModelAndView activaCuenta(@RequestParam("username") String username, @RequestParam("codigo") String codigo){
		if(Broker.getInstanciaActivaCuenta().activacionCuenta(new ActivaCuentaDTO(username, codigo))) {
			user = Broker.getInstanciaUsuario().getUsuarioDTO(username);
			user2 = Broker.getInstanciaUsuario().getUsuarioDTO(username);
			user2.setActivadaCuenta(true);
			Broker.getInstanciaUsuario().updateUsuario(user, user2);
			Broker.getInstanciaActivaCuenta().eliminaAC(new ActivaCuentaDTO(username, codigo));
			vista = new ModelAndView("vistaActivarCuenta");
			vista.addObject("activa", user2);
			correo = new Email();
			correo.confirmaCuentaCreada(user2);
		}else if(Broker.getInstanciaActivaCuenta().existeActivacionUsuario(username)) {
			vista = new ModelAndView("redirect:/inicio.html");
			vista.addObject(CONST_MENSAJE, "Hay una activacion pendiente para "+username+", pero ese codigo no es el correcto.");
		}else {
			user = Broker.getInstanciaUsuario().getUsuarioDTO(username);
			if(user!=null && user.isActivadaCuenta()) {
				vista = new ModelAndView(CONST_REDIRECT_IS);
				vista.addObject(CONST_MENSAJE, "Su cuenta ya fue activada");
			}else {
				vista = new ModelAndView("redirect:/registro.html");
				vista.addObject(CONST_MENSAJE, "Ha expirado la activacion de su cuenta. Es necesario que se vuelva a registrar.");
			}
		}
		return vista;
	}
	
	@PostMapping(value = "/infoExtra")
	public ModelAndView activar(HttpServletRequest request, HttpServletResponse response){
		user = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));
		user2 = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));

		//Eleccion foto perfil
		if(request.getParameter(CONST_INPUT_EMAIL_AVATAR)!=null && (!request.getParameter(CONST_INPUT_EMAIL_AVATAR).equals(""))) {
			user2.setEmailFoto(request.getParameter(CONST_INPUT_EMAIL_AVATAR));
			user2.setFoto("https://www.gravatar.com/avatar/"+DigestUtils.md5Hex(request.getParameter(CONST_INPUT_EMAIL_AVATAR))+".jpg");
		}else {
			user2.setEmailFoto(request.getParameter(""));
			user2.setFoto("https://www.gravatar.com/avatar/hashNoDisponible.jpg");
		}
		
		if(request.getParameter(CONST_INPUT_NYA)!=null && (!request.getParameter(CONST_INPUT_NYA).equals(""))) {
			user2.setNombreApellidos(request.getParameter(CONST_INPUT_NYA));
		}
		if(request.getParameter(CONST_INPUT_CIUDAD)!=null && (!request.getParameter(CONST_INPUT_CIUDAD).equals(""))) {
			user2.setCiudad(request.getParameter(CONST_INPUT_CIUDAD));
		}
		if(request.getParameter(CONST_INPUT_PAIS)!=null && (!request.getParameter(CONST_INPUT_PAIS).equals(""))) {
			user2.setPais(request.getParameter(CONST_INPUT_PAIS));
		}
		Broker.getInstanciaUsuario().updateUsuario(user, user2);
		vista = new ModelAndView(CONST_REDIRECT_IS);
		vista.addObject(CONST_MENSAJE, "Registro completado con exito.");
		return vista;
	}
	
	@GetMapping(value = "/infoExtra")
	public ModelAndView activarGet(HttpServletRequest request, HttpServletResponse response){
		vista = new ModelAndView(CONST_REDIRECT_IS);
		return vista;
	}	*/
}