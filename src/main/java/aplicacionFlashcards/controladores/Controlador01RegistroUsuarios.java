package main.java.aplicacionFlashcards.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionFlashcards.auxiliares.Email;
import main.java.aplicacionFlashcards.auxiliares.Fecha;
import main.java.aplicacionFlashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionFlashcards.auxiliares.PropertiesConfig;
import main.java.aplicacionFlashcards.broker.Broker;
import main.java.aplicacionFlashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionFlashcards.dto.UsuarioDTO;

@RestController
@SessionAttributes("usuario")
public class Controlador01RegistroUsuarios {
	
	//Variables
		List<String> listaUsernames;
		List<String> listaEmails;
		ModelAndView vista;
		UsuarioDTO user;
		UsuarioDTO user2;
		Fecha fecha;
		String codigoActivacion;
		Email correo;
		
		/*Constantes
		static final String CONST_USUARIO = "usuario";
		static final String CONST_MENSAJE = "mensaje";
		static final String CONST_REDIRECT_IS = "redirect:/iniciarSesion.html";
		static final String CONST_INPUT_EMAIL_AVATAR = "inputEmailAvatar";
		static final String CONST_INPUT_NYA = "inputNyA";
		static final String CONST_INPUT_CIUDAD = "inputCiudad";
		static final String CONST_INPUT_PAIS = "inputPais";*/
		
		//Registro	
		@RequestMapping(value = "/registro", method = RequestMethod.GET)
		public ModelAndView registroGet(HttpServletRequest request, HttpServletResponse response) {
			
			//Comprobaciones
			
			//1-Comprobar activaciones caducadas
			Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
			
			//2-Eliminar cuentas pasados 14 dias
			Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
			
			//3-Eliminar solicitudes de restablecimiento de Claves
			Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
			
			if(request.getSession().getAttribute("usuario")==null || 
			   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()==null||
			   ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()=="") {
				
				vista = new ModelAndView("vistaRegistro");
				
				if(request.getParameter("mensaje")!= null && (!request.getParameter("mensaje").equals(""))) {
					vista.addObject("mensaje", request.getParameter("mensaje"));
				}
				
			}else {
				
				vista = new ModelAndView("redirect:/inicio.html");
				
			}
			
			return vista;
		}
		
		//Metodo auxiliar get usernames en vista registro
		@RequestMapping(value = "/getUsernames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		@ResponseStatus(HttpStatus.OK)
		public List<String> listUsernames(){
			listaUsernames = Broker.getInstanciaUsuario().getListUsername();
			listaUsernames.add("usuario123");
			listaUsernames.add("usuario456");
			return listaUsernames;
		}	
		
		//Metodo auxiliar get emails en vista registro
		@RequestMapping(value = "/getEmails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		@ResponseStatus(HttpStatus.OK)
		public List<String> listEmails(){
			listaEmails = Broker.getInstanciaUsuario().getListEmail();
			listaEmails.add("usuario123@email.com");
			listaEmails.add("usuario456@email.com");
			return listaEmails;
		}
		
		//Crear usuario - POST
		@RequestMapping(value = "/crearCuenta", method = RequestMethod.POST)
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
			
			fecha = new Fecha();
			codigoActivacion = GeneratorStrings.randomString(15);
			
			if(Broker.getInstanciaUsuario().insertUsuario(user) &&
			   Broker.getInstanciaActivaCuenta().insertaAC(new ActivaCuentaDTO(user.getUsername(), codigoActivacion, fecha.fechaActivarCuenta()))) {
				correo = new Email();
				correo.activarCuenta(user,PropertiesConfig.getProperties("baseURL")+"/activaCuenta.html?username="+user.getUsername()+"&codigo="+codigoActivacion);
				
				vista = new ModelAndView("vistaAcceder");
				vista.addObject("mensaje", "Por favor, revise su email "+user.getEmail()+" para finalizar con su registro.");
				
			}else {
				
				vista = new ModelAndView("vistaRegistro");
				vista.addObject("mensaje", "Hubo un fallo en el registro. Por favor, vuelva a intentar registrarse pasado unos minutos.");
				
			}
			
			return vista;
		}
		
		//Crear usuario - GET
		@RequestMapping(value = "/crearCuenta", method = RequestMethod.GET)
		public ModelAndView registrarUsuarioGet(HttpServletRequest request, HttpServletResponse response) {
			vista = new ModelAndView("redirect:/registro.html");
			return vista;
		}
		
		//Activar Cuenta - GET
		@RequestMapping(value = "/activaCuenta", method = RequestMethod.GET)
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
				vista.addObject("mensaje", "Hay una activacion pendiente para "+username+", pero ese codigo no es el correcto.");
			}else {
				user = Broker.getInstanciaUsuario().getUsuarioDTO(username);
				if(user!=null && user.isActivadaCuenta()) {
					vista = new ModelAndView("redirect:/iniciarSesion.html");
					vista.addObject("mensaje", "Su cuenta ya fue activada");
				}else {
					vista = new ModelAndView("redirect:/registro.html");
					vista.addObject("mensaje", "Ha expirado la activacion de su cuenta. Es necesario que se vuelva a registrar.");
				}
			}
			return vista;
		}
		
		@RequestMapping(value = "/infoExtra", method = RequestMethod.POST)
		public ModelAndView activar(HttpServletRequest request, HttpServletResponse response){
			user = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));
			user2 = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("username"));

			//Eleccion foto perfil
			if(request.getParameter("inputEmailAvatar")!=null && request.getParameter("inputEmailAvatar")!="") {
				user2.setEmailFoto(request.getParameter("inputEmailAvatar"));
				user2.setFoto("https://www.gravatar.com/avatar/"+DigestUtils.md5Hex(request.getParameter("inputEmailAvatar"))+".jpg");
			}else {
				user2.setEmailFoto(request.getParameter(""));
				user2.setFoto("https://www.gravatar.com/avatar/hashNoDisponible.jpg");
			}
			
			if(request.getParameter("inputNyA")!=null && request.getParameter("inputNyA")!="") {
				user2.setNombreApellidos(request.getParameter("inputNyA"));
			}
			if(request.getParameter("inputCiudad")!=null && request.getParameter("inputCiudad")!="") {
				user2.setCiudad(request.getParameter("inputCiudad"));
			}
			if(request.getParameter("inputPais")!=null && request.getParameter("inputPais")!="") {
				user2.setPais(request.getParameter("inputPais"));
			}
			Broker.getInstanciaUsuario().updateUsuario(user, user2);
			vista = new ModelAndView("redirect:/iniciarSesion.html");
			vista.addObject("mensaje", "Registro completado con exito.");
			return vista;
		}
		
		@RequestMapping(value = "/infoExtra", method = RequestMethod.GET)
		public ModelAndView activarGet(HttpServletRequest request, HttpServletResponse response){
			vista = new ModelAndView("redirect:/iniciarSesion.html");
			return vista;
		}	
}