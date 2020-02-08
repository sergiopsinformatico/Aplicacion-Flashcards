package main.java.aplicacionflashcards.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import main.java.aplicacionflashcards.auxiliares.Email;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.ActivaCuentaDTO;
import main.java.aplicacionflashcards.dto.EliminarCuentaDTO;
import main.java.aplicacionflashcards.dto.RecuperarCuentaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador02RecuperarCuenta {
	
   /* * * * * * * 
    * VARIABLES *
	* * * * * * */
	
	Fecha fecha;
	ModelAndView vista;
	UsuarioDTO user;
	UsuarioDTO userAntiguo;
	UsuarioDTO userNuevo;
	List<ActivaCuentaDTO> listaAC;
	List<EliminarCuentaDTO> listaEl;
	int indice;
	String compara;
	String keySecure;
	Email email;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String VISTARECUPERARCUENTA = "vistaRecuperarCuenta";
	static final String MENSAJE = "mensaje";
	static final String USERNAME = "username";
	
	@GetMapping(value = "/recuperaCuenta")
	public ModelAndView recuperaCuenta(HttpServletRequest request, HttpServletResponse response) {
		
		//Comprobaciones
		
		//1-Comprobar activaciones caducadas
		Broker.getInstanciaActivaCuenta().comprobarActivacionesCaducadas();
		
		//2-Eliminar cuentas pasados 14 dias
		Broker.getInstanciaEliminarCuenta().comprobarCuentasAEliminar();
		
		//3-Eliminar solicitudes de restablecimiento de Claves
		Broker.getInstanciaRecuperarCuenta().comprobarSolicitudesCaducadas();
				
		return new ModelAndView(VISTARECUPERARCUENTA);
	}
	
	@PostMapping(value = "/recuperaClave")
	public ModelAndView recuperaClave(HttpServletRequest request, HttpServletResponse response) {
		user = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter("inputUsernameEmail"));
		vista = new ModelAndView(VISTARECUPERARCUENTA);
		if(user==null || user.getUsername()==null || user.getUsername().equals("")) {
			vista.addObject(MENSAJE, "No existe ninguna cuenta cuyo username o email sea "+request.getParameter("inputUsernameEmail"));
			return vista;
		}else {
			try {
				email = new Email();
				fecha = new Fecha();
				keySecure = GeneratorStrings.randomString(10);
				Broker.getInstanciaRecuperarCuenta().insertaRC(new RecuperarCuentaDTO(user.getUsername(), keySecure, fecha.fechaRecuperarCuenta()));
				email.recuperarClave(user,keySecure);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			
			vista.addObject(MENSAJE, "Se ha enviado un email a " + user.getEmail() +" con los pasos para cambiar la clave.");
			return vista;
		}
	}
	
	@GetMapping(value = "/recuperaClave")
	public ModelAndView recuperaClaveGet(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:/recuperaCuenta.html");
	}
	
	@GetMapping(value = "/restableceClave")
	public ModelAndView restableceClave(@RequestParam(USERNAME) String username, @RequestParam("keySecurity") String keySecurity) {
		if(Broker.getInstanciaRecuperarCuenta().leerRC(username, keySecurity)) {
			vista = new ModelAndView("vistaRestablecimientoClave");
			vista.addObject(USERNAME, username);
		}else if(Broker.getInstanciaRecuperarCuenta().existeSolicitudUsuario(username)) {
			vista = new ModelAndView(VISTARECUPERARCUENTA);
			vista.addObject(MENSAJE, "Solicito un restablecimiento de la clave, pero el codigo no es valido");
		}else {
			vista = new ModelAndView(VISTARECUPERARCUENTA);
			vista.addObject(MENSAJE, "El enlace ha expirado. Por favor, vuelva a solicitar la recuperacion de la clave");
		}
		return vista;
	}
	
	@PostMapping(value = "/cambioClave")
	public ModelAndView cambioClave(HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/inicio.html");
		userAntiguo = Broker.getInstanciaUsuario().getUsuarioDTO(request.getParameter(USERNAME));
		userNuevo = userAntiguo;
		userNuevo.setClave(request.getParameter("inputNuevaClave"));
		if(Broker.getInstanciaUsuario().updateUsuario(userAntiguo, userNuevo)) {
			Broker.getInstanciaRecuperarCuenta().eliminarRC(request.getParameter(USERNAME));
			vista.addObject(MENSAJE, "Se ha actualizado su clave correctamente");
		}else {
			vista.addObject(MENSAJE, "Error. No se pudo actualizar su clave");
		}
		return vista;
	}
	
	@GetMapping(value = "/cambioClave")
	public ModelAndView cambioClaveGet(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("redirect:/inicio.html");
	}
}