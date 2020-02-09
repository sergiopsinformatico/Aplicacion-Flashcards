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

import main.java.aplicacionflashcards.auxiliares.CheckUsers;
import main.java.aplicacionflashcards.auxiliares.Fecha;
import main.java.aplicacionflashcards.auxiliares.GeneratorStrings;
import main.java.aplicacionflashcards.broker.Broker;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOClub;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador08Clubes {
	
	//Variables
	ModelAndView vista;
	ClubDTO club;
	InterfaceDAOClub dBClub;
	InterfaceDAOUsuario dBUsuario;
	String idClub;
	Fecha fecha;
	List<String> miembros;
	List<UsuarioDTO> usuariosMiembros;
	int indice;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	/*Constantes
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_INICIO = "redirect:/inicio.html";
	static final String CONST_REDIRECT_VER_CLUBES = "redirect:/verClubes.html";*/
	
	@GetMapping(value = "/verClubes")
	public ModelAndView getClubes(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			vista = new ModelAndView("vistaClubes");
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/getTodosClubes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getTodosClubes(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getTodosClubes(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
	}
	
	@GetMapping(value = "/getClubesCreados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesCreados(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getMisClubes(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
	}
	
	@GetMapping(value = "/getClubesPertenezco", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesPertenezco(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getClubesPertenezco(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
	}
	
	@PostMapping(value = "/crearClub")
	public ModelAndView crearClubes(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			dBClub = Broker.getInstanciaClub();
			fecha = new Fecha();
			
			do {
				
				idClub = GeneratorStrings.randomString(10);
				
			}while(dBClub.existeIdClub(idClub));
			
			miembros = new LinkedList<>();
			miembros.add(((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
			
			club = new ClubDTO(idClub, request.getParameter("nombre"), request.getParameter("tema"),
					((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername(), 
					miembros, fecha.fechaHoy());
			
			vista = new ModelAndView("vistaClubes");
			
			if(dBClub.insertaClub(club)) {
				vista.addObject("mensaje", "Se ha creado el club "+club.getNombreClub()+" correctamente");
			}else {
				vista.addObject("mensaje", "Error al crear el club");
			}
			
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	@GetMapping(value = "/crearClub")
	public ModelAndView crearClubesGet(HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/verClubes.html");
		return vista;
	}
	
	@GetMapping(value = "/verClub")
	public ModelAndView verClubGet(@RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("vistaClub");
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		vista.addObject("club", club);
		return vista;
	}
	
	@GetMapping(value = "/getUsuariosClub", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getUsuariosClub(@RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		dBClub = Broker.getInstanciaClub();
		dBUsuario = Broker.getInstanciaUsuario();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		miembros = club.getMiembros();
		usuariosMiembros = new LinkedList<>();
		for(indice=0; indice<miembros.size(); indice++) {
			usuariosMiembros.add(dBUsuario.getUsuarioDTO(miembros.get(indice)));
		}
		return usuariosMiembros;
	}
	
	@GetMapping(value = "/unirmeClub")
	public ModelAndView unirmeClub(@RequestParam("idClub") String idClub, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/verClubes.html");
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		miembros = club.getMiembros();
		miembros.add(username);
		club.setMiembros(miembros);
		dBClub.actualizaClub(club);
		return vista;
	}
	
	@GetMapping(value = "/dejarClub")
	public ModelAndView dejarClub(@RequestParam("idClub") String idClub, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/verClubes.html");
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		miembros = club.getMiembros();
		
		for(indice=0; indice<miembros.size(); indice++) {
			if(miembros.get(indice).equals(username)) {
				miembros.remove(indice);
				indice = miembros.size();
			}
		}
		
		club.setMiembros(miembros);
		dBClub.actualizaClub(club);
		return vista;
	}
	
	@GetMapping(value = "/borrarClub")
	public ModelAndView borrarClub(@RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("redirect:/verClubes.html");
		dBClub = Broker.getInstanciaClub();
		dBClub.eliminaClub(idClub);
		return vista;
	}
	
	@GetMapping(value = "/eliminarUsuarioClub")
	public ModelAndView eliminarUsuarioClub(@RequestParam("idClub") String idClub, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("vistaClub");
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		miembros = club.getMiembros();
		
		for(indice=0; indice<miembros.size(); indice++) {
			if(miembros.get(indice).equals(username)) {
				miembros.remove(indice);
				indice = miembros.size();
			}
		}
		
		club.setMiembros(miembros);
		dBClub.actualizaClub(club);
		
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute("usuario"))).getUsername());
		vista.addObject("club", club);
		return vista;
	}
	
	@GetMapping(value = "/getColeccionesClub", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> getColeccionesClub(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		return Broker.getInstanciaFlashcards().coleccionesClub(id);
	}
}
