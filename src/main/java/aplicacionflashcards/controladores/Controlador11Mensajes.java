package main.java.aplicacionflashcards.controladores;

import java.util.LinkedList;
import java.util.List;

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

import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.dto.MensajeDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador11Mensajes {
	
	List<MensajeDTO> listaMensajes;
	List<String> listaAmigos;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	MensajeDTO mensaje;
	String idMensaje;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_VISTA_PANEL_MENSAJES = "vistaPanelMensajes";
	static final String CONST_REMITENTE = "remitente";
	
	@GetMapping(value = "/panelMensajes")
	public ModelAndView panelMensajes(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView(CONST_VISTA_PANEL_MENSAJES);
	}
	
	@GetMapping(value = "/getMensajesRecibidos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<MensajeDTO> getMensajesRecibidos(@RequestParam("usuario") String usuario, HttpServletRequest request, HttpServletResponse response){
		try {
			listaMensajes = Broker.getInstanciaMensaje().mensajesRecibidos(usuario);
		}catch(Exception ex) {
			listaMensajes = new LinkedList<>();
		}
		
		return listaMensajes;
	}
	
	@GetMapping(value = "/getMensajesEnviados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<MensajeDTO> getMensajesEnviados(@RequestParam("usuario") String usuario, HttpServletRequest request, HttpServletResponse response){
		try {
			listaMensajes = Broker.getInstanciaMensaje().mensajesEnviados(usuario);
		}catch(Exception ex) {
			listaMensajes = new LinkedList<>();
		}
		
		return listaMensajes;
	}
	
	@GetMapping(value = "/getAmigosMensajes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> getAmigosMensajes(HttpServletRequest request, HttpServletResponse response){
		dBRelaciones = Broker.getInstanciaRelaciones();
		return dBRelaciones.getAmigos(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
	}
	
	@PostMapping(value = "/enviarMensaje")
	public ModelAndView enviarMensaje(HttpServletRequest request, HttpServletResponse response){
		
		do {
			idMensaje = request.getParameter(CONST_REMITENTE) + "-" + GeneratorStrings.randomString(5);
		}while(Broker.getInstanciaMensaje().existeIdMensaje(idMensaje));
		
		mensaje = new MensajeDTO(idMensaje, request.getParameter(CONST_REMITENTE), request.getParameter("destinatario"), request.getParameter("mensaje"));
		Broker.getInstanciaMensaje().enviaMensaje(mensaje);
		Broker.getInstanciaNotificaciones().insertarNotificacion(request.getParameter("destinatario"), "Tiene un mensaje nuevo de "+request.getParameter(CONST_REMITENTE));
		
		return new ModelAndView(CONST_VISTA_PANEL_MENSAJES);
	}
	
	@GetMapping(value = "/eliminarMensaje")
	public ModelAndView eliminarMensaje(@RequestParam("idMensaje") String idMensaje, HttpServletRequest request, HttpServletResponse response) {
		Broker.getInstanciaMensaje().eliminarMensaje(idMensaje);
		return new ModelAndView(CONST_VISTA_PANEL_MENSAJES);
	}
	
}
