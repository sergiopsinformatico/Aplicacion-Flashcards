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

import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOFlashcards;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.TarjetaDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")

public class Controlador09Flashcards {
	
	//Variables
	/*ModelAndView vista;
	InterfaceDAOClub dBClub;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	InterfaceDAOFlashcards dBFlashcards;
	List<TarjetaDTO> tarjetas;
	FlashcardsDTO flashcard;
	int indice;
	String idFlashcards;
	Fecha hoy;
	List<FlashcardsDTO> listaColecciones;
	List<ClubDTO> listaClubes;
	List<String[]> tarjetasArray;
	String[] tarjeta;
	//Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_TIPO_COMPARTIR = "tipoCompartir";
	
	
	@GetMapping(value = "/flashcards")
	public ModelAndView flashcards(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista = new ModelAndView("vistaFlashcards");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	@GetMapping(value = "/crearColeccion")
	public ModelAndView crearColeccion(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista = new ModelAndView("vistaFlashcardsCrear");
			tarjetas = new LinkedList<>();
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/getClubesFlashcards", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesFlashcards(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getClubesPertenezco(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/getAmigosFlashcards", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> getAmigosFlashcards(HttpServletRequest request, HttpServletResponse response){
		dBRelaciones = Broker.getInstanciaRelaciones();
		return dBRelaciones.getAmigos(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/addTarjeta", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public boolean addTarjeta(@RequestParam("anverso") String anverso, @RequestParam("reverso") String reverso, HttpServletRequest request, HttpServletResponse response){
		try {
			tarjetas.add(new TarjetaDTO(anverso, reverso));
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/deleteTarjeta", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public boolean deleteTarjeta(@RequestParam("anverso") String anverso, @RequestParam("reverso") String reverso, HttpServletRequest request, HttpServletResponse response){
		try {
			for(indice=0; indice<tarjetas.size(); indice++) {
				if(tarjetas.get(indice).getAnverso().equals(anverso) &&
				   tarjetas.get(indice).getReverso().equals(reverso)) {
					tarjetas.remove(indice);
					indice = tarjetas.size();
				}
			}
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	@PostMapping(value = "/guardarColeccionFlashcards")
	public ModelAndView guardarColeccionFlashcards(HttpServletRequest request, HttpServletResponse response) {
		
		dBFlashcards = Broker.getInstanciaFlashcards();
		idFlashcards = GeneratorStrings.randomString(12);
		
		while(dBFlashcards.existeIdColeccion(idFlashcards)) {
			idFlashcards = GeneratorStrings.randomString(12);
		}
		
		hoy = new Fecha();
		
		if(request.getParameter(CONST_TIPO_COMPARTIR).equals("publico") || request.getParameter(CONST_TIPO_COMPARTIR).equals("privado")) {
			flashcard = new FlashcardsDTO(idFlashcards, request.getParameter("nombreColeccion"), request.getParameter("temaColeccion"), 
					((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), tarjetas, request.getParameter(CONST_TIPO_COMPARTIR), "");
		}else {
			flashcard = new FlashcardsDTO(idFlashcards, request.getParameter("nombreColeccion"), request.getParameter("temaColeccion"),
					((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), tarjetas, request.getParameter(CONST_TIPO_COMPARTIR), request.getParameter("compartirCon"));
		}
		
		flashcard.setFechaCreacion(hoy.fechaHoy());
		flashcard.setEvaluada(false);
		flashcard.setEvaluador("");
		
		vista = new ModelAndView("vistaFlashcards");
		
		if(dBFlashcards.crearFlashcards(flashcard)) {
			vista.addObject("mensaje", "Se ha creado correctamente la coleccion "+flashcard.getNombreColeccion()+". Pendiente de evaluar por un moderador.");
		}else {
			vista.addObject("mensaje", "Ups! Hubo un error al crear la coleccion "+flashcard.getNombreColeccion());
		}
		
		return vista;
	}
	
	
	
	@GetMapping(value = "/verColecciones")
	public ModelAndView verColecciones(HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista = new ModelAndView("vistaFlashcardsColecciones");
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}	
	
	
	
	@GetMapping(value = "/coleccionesVisiblesParaMi", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> coleccionesVisiblesParaMi(HttpServletRequest request, HttpServletResponse response){
		try {
			listaColecciones = Broker.getInstanciaFlashcards().listarColeccionesVisibles(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		}catch(Exception ex) {
			listaColecciones = new LinkedList<>();
		}
		
		return listaColecciones;
	}
	
	@GetMapping(value = "/coleccionesCreadasEvaluadas", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> coleccionesCreadasEvaluadas(HttpServletRequest request, HttpServletResponse response){
		try {
			listaColecciones = Broker.getInstanciaFlashcards().coleccionesCreadasVisibles(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		}catch(Exception ex) {
			listaColecciones = new LinkedList<>();
		}
		
		return listaColecciones;
	}
	
	@GetMapping(value = "/coleccionesCreadasPendienteEvaluar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> coleccionesCreadasPendienteEvaluar(HttpServletRequest request, HttpServletResponse response){
		try {
			listaColecciones = Broker.getInstanciaFlashcards().coleccionesCreadasSinEvaluar(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		}catch(Exception ex) {
			listaColecciones = new LinkedList<>();
		}
		
		return listaColecciones;
	}
	
	@GetMapping(value = "/clubesFlashcards", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> clubesFlashcards(HttpServletRequest request, HttpServletResponse response){
		try {
			listaClubes = Broker.getInstanciaClub().todosClubesCreados();
		}catch(Exception ex) {
			listaClubes = new LinkedList<>();
		}
		
		return listaClubes;
	}
	
	@GetMapping(value = "/verColeccion")
	public ModelAndView verColeccion(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		if(request.getSession().getAttribute(CONST_USUARIO)!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()!=null && 
		   ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername().equals("")) {
			
			vista = new ModelAndView("vistaFlashcardsVisualizar");
			flashcard = Broker.getInstanciaFlashcards().leerFlashcard(id);
			
			if(flashcard.getTipoCompartir().equals("club")) {
				flashcard.setCompartirCon(Broker.getInstanciaClub().leerClub(flashcard.getCompartirCon(), ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername()).getNombreClub());
			}
			vista.addObject("flashcard", flashcard);
		
		}else {
			vista = new ModelAndView(CONST_REDIRECT_INICIO);
		}
		return vista;
	}*/
		
}