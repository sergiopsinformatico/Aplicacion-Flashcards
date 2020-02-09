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
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.auxiliares.MD5Photo;
import main.java.aplicacionflashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionflashcards.dto.PuntosDTO;
import main.java.aplicacionflashcards.dto.RelacionesUsuariosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador01RegistroUsuarios {
	
	/* * * * * * * 
	 * VARIABLES *
	 * * * * * * */
	
	ModelAndView vista;
	List<String> listaUsernames;
	List<String> listaEmails;
	UsuarioDTO user;
	UsuarioDTO user2;
	RelacionesUsuariosDTO relacion;
	Fecha fecha;
	String codigoActivacion;
	Email correo;
	MD5Photo md5;
	
	//Logger
    private static final Logger LOGGER = Logger.getLogger("main.java.aplicacionflashcards.controladores.Controlador01RegistroUsuarios");
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String USUARIO = "usuario";
	static final String MENSAJE = "mensaje";
	static final String REDIRECTIS = "redirect:/iniciarSesion.html";
	static final String EMAILAVATAR= "inputEmailAvatar";
	static final String NYA= "inputNyA";
	static final String CIUDAD = "inputCiudad";
	static final String PAIS = "inputPais";
	
	/* * * * * * * * * 
     * CONTROLADORES *
	 * * * * * * * * */
	
	/* * * * * * * * * * * * * * * *  *
	 * FUNCIONALIDAD 1: CREAR CUENTA  *
	 * * * * * * * * * * * * * * * *  */
	
	/*Obtener la vista del registro*/
	@GetMapping(value = "/registro")
	public ModelAndView registroGet(HttpServletRequest request, HttpServletResponse response) {
				
		//1-Comprobar activaciones caducadas
		Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
		
		//2-Eliminar cuentas pasados 14 dias
		Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
		
		//3-Eliminar solicitudes de restablecimiento de Claves
		Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
		
		if(CheckUsers.isUsuarioNoLogueado(request)) {
			
			vista = new ModelAndView("vistaRegistro");
			
			if(request.getParameter(MENSAJE)!= null && (!request.getParameter(MENSAJE).equals(""))) {
				vista.addObject(MENSAJE, request.getParameter(MENSAJE));
			}
			
		}else {
			
			vista = new ModelAndView("redirect:/inicio.html");
			
		}
		
		return vista;
	}
	
	/* Obtener los usernames de los usuarios para la comprobacion en el registro */
	@GetMapping(value = "/getUsernames", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> listUsernames(){
		listaUsernames = Broker.getInstanciaUsuario().getListUsername();
		listaUsernames.add("user1Test");
		listaUsernames.add("user2Test");
		listaUsernames.add("user3Test");
		listaUsernames.add("user4Test");
		listaUsernames.add("adminTest");
		listaUsernames.add("moderadorTest");
		return listaUsernames;
	}	
	
	/* Obtener los emails de los usuarios para la comprobacion en el registro */
	@GetMapping(value = "/getEmails", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> listEmails(){
		listaEmails = Broker.getInstanciaUsuario().getListEmail();
		listaEmails.add("user1Test@email.com");
		listaEmails.add("user2Test@email.com");
		listaEmails.add("user3Test@email.com");
		listaEmails.add("user4Test@email.com");
		listaEmails.add("adminTest@email.com");
		listaEmails.add("moderadorTest@email.com");
		return listaEmails;
	}
	
	/* Crear usuario - POST */
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
		   Broker.getInstanciaRelaciones().creaRelaciones(relacion) && Broker.getInstanciaPuntos().actualizaPuntos(new PuntosDTO(user.getUsername(), 0))) {
			
			try {
				
				correo = new Email();
				correo.activarCuenta(user,PropertiesConfig.getProperties("baseURL")+"/activaCuenta.html?username="+user.getUsername()+"&codigo="+codigoActivacion);
				
			}catch(Exception ex) {
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
			vista = new ModelAndView("vistaIniciarSesion");
			vista.addObject(MENSAJE, "Para finalizar el registro, revise su email "+user.getEmail()+" y siga los pasos para activar la cuenta.");
			
		}else {
			
			vista = new ModelAndView("vistaRegistro");
			vista.addObject(MENSAJE, "Hubo un fallo en el registro. Por favor, vuelva a intentar registrarse pasado unos minutos.");
			
		}
		
		return vista;
	}
	
	/* Crear usuario - GET */
	@GetMapping(value = "/crearCuenta")
	public ModelAndView registrarUsuarioGet(HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/registro.html");
		return vista;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * *  *
	 * FUNCIONALIDAD 2: ACTIVAR NUEVA CUENTA  *
	 * * * * * * * * * * * * * * * * * * * *  */
	
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
			
			try {
				
				correo = new Email();
				correo.confirmaCuentaCreada(user2);
				
			}catch(Exception ex) {
				LOGGER.log(Level.INFO, ex.getMessage());
			}
			
		}else if(Broker.getInstanciaActivaCuenta().existeActivacionUsuario(username)) {
			vista = new ModelAndView("redirect:/inicio.html");
			vista.addObject(MENSAJE, "Hay una activacion pendiente para "+username+", pero ese codigo no es el correcto.");
		}else {
			user = Broker.getInstanciaUsuario().getUsuarioDTO(username);
			if(user!=null && user.isActivadaCuenta()) {
				vista = new ModelAndView(REDIRECTIS);
				vista.addObject(MENSAJE, "Su cuenta ya fue activada");
			}else {
				vista = new ModelAndView("redirect:/registro.html");
				vista.addObject(MENSAJE, "Ha expirado la activacion de su cuenta. Es necesario que se vuelva a registrar.");
			}
		}
		return vista;
	}
	
	/*Incluir datos personales: avatar, nombre y apellidos, ciudad y pais*/
	@PostMapping(value = "/infoExtra")
	public ModelAndView activar(HttpServletRequest request, HttpServletResponse response){
		user = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));
		user2 = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));
		md5 = new MD5Photo();

		//Eleccion foto perfil
		if(request.getParameter(EMAILAVATAR)!=null && (!request.getParameter(EMAILAVATAR).equals(""))) {
			user2.setEmailFoto(request.getParameter(EMAILAVATAR));
			user2.setFoto("https://www.gravatar.com/avatar/"+md5.getMD5Photo(user2.getEmailFoto())+".jpg");
		}else {
			user2.setEmailFoto("");
			user2.setFoto("https://www.gravatar.com/avatar/hashNoDisponible.jpg");
		}
		
		if(request.getParameter(NYA)!=null && (!request.getParameter(NYA).equals(""))) {
			user2.setNombreApellidos(request.getParameter(NYA));
		}
		if(request.getParameter(CIUDAD)!=null && (!request.getParameter(CIUDAD).equals(""))) {
			user2.setCiudad(request.getParameter(CIUDAD));
		}
		if(request.getParameter(PAIS)!=null && (!request.getParameter(PAIS).equals(""))) {
			user2.setPais(request.getParameter(PAIS));
		}
		Broker.getInstanciaUsuario().updateUsuario(user, user2);
		vista = new ModelAndView(REDIRECTIS);
		vista.addObject(MENSAJE, "Registro completado con exito.");
		return vista;
	}
	
	@GetMapping(value = "/infoExtra")
	public ModelAndView activarGet(HttpServletRequest request, HttpServletResponse response){
		vista = new ModelAndView(REDIRECTIS);
		return vista;
	}
	
	
}