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

import main.java.aplicacionflashcards.auxiliares.CheckUsers;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.TarjetaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")

public class Controlador10Moderador {
	
	//Variables
	ModelAndView vista;
	List<FlashcardsDTO> listaColecciones;
	String nombreColeccion;
	FlashcardsDTO flashcard;
	
	/*Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_FLASHCARD_EVALUA = "vistaFlashcardsEvaluar";
	static final String CONST_MENSAJES = "mensajes";*/
	
	/*Moderador Evalua Coleccion*/
	
	@GetMapping(value = "/evaluarColecciones")
	public ModelAndView evaluarColecciones(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) &&
		   (CheckUsers.isModerador(request) ||
		   CheckUsers.isAdministrador(request))) {
			
			vista = new ModelAndView("vistaFlashcardsEvaluar");
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	@GetMapping(value = "/coleccionesSinEvaluar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> coleccionesSinEvaluar(HttpServletRequest request, HttpServletResponse response){
		try {
			listaColecciones = Broker.getInstanciaFlashcards().consultaSinEvaluar(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		}catch(Exception ex) {
			listaColecciones = new LinkedList<>();
		}
		
		return listaColecciones;
	}
	
	@GetMapping(value = "/evaluarColeccion")
	public ModelAndView evaluarColeccion(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) && 
		   (CheckUsers.isAdministrador(request) || 
		   CheckUsers.isModerador(request))) {
			
			vista = new ModelAndView("vistaFlashcardsAnalizarColeccion");
			flashcard = Broker.getInstanciaFlashcards().leerFlashcard(id);
			
			if(flashcard.getTipoCompartir().equals("club")) {
				flashcard.setCompartirCon(Broker.getInstanciaClub().leerClub(flashcard.getCompartirCon(), ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername()).getNombreClub());
			}
			vista.addObject("flashcard", flashcard);
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	@GetMapping(value = "/evaluacionPositiva")
	public ModelAndView evaluacionPositiva(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("vistaFlashcardsEvaluar");
		Broker.getInstanciaFlashcards().valoraPositivamente(id, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		vista.addObject("mensajes", "La coleccion se ha evaluado positivamente");
		return vista;
	}
	
	@GetMapping(value = "/evaluacionNegativa")
	public ModelAndView evaluacionNegativa(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("vistaFlashcardsEvaluar");
		Broker.getInstanciaFlashcards().valoraNegativamente(id);
		vista.addObject("mensajes", "La coleccion se ha evaluado negativamente y por tanto ha sido eliminada");
		return vista;
	}
	
	@GetMapping(value = "/getTarjetasColeccion", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<TarjetaDTO> getTarjetasColeccion(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response){
		
		return Broker.getInstanciaFlashcards().leerFlashcard(id).getTarjetas();
	}
	
	//Moderador Elimina Flashcards
	
	
	@GetMapping(value = "/gestionarFlashcards")
	public ModelAndView gestionarFlashcards(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request) &&
		   (CheckUsers.isModerador(request) ||
		   CheckUsers.isAdministrador(request))) {
			
			vista = new ModelAndView("vistaGestionFlashcards");
			
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		
		return vista;
	}
	
	
	@GetMapping(value = "/getColeccionesModerador", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> getColeccionesModerador(HttpServletRequest request, HttpServletResponse response){
		try {
			listaColecciones = Broker.getInstanciaFlashcards().listarTodasColeccionesModerador();
		}catch(Exception ex) {
			listaColecciones = new LinkedList<>();
		}
		
		return listaColecciones;
	}
	
	
	
	@GetMapping(value = "/eliminaColeccionModerador", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView eliminaColeccionModerador(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response){
		try {
			
			vista = new ModelAndView("vistaGestionFlashcards");
			nombreColeccion = Broker.getInstanciaFlashcards().leerFlashcard(id).getNombreColeccion();
			
			if(Broker.getInstanciaFlashcards().eliminarFlashcard(id)) {
				vista.addObject("mensajes", "Se ha eliminado la coleccion "+nombreColeccion);
			}else {
				vista.addObject("mensajes", "No se pudo eliminar la coleccion "+nombreColeccion);
			}
			
		}catch(Exception ex) {
			vista.addObject("mensajes", "Hubo un problema con la conexion");
		}
		
		return vista;
	}
	
}
