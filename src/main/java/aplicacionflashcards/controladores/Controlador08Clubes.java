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
import main.java.aplicacionflashcards.db.dao.InterfaceDAONotificaciones;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOPuntos;
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.ClubDTO;
import main.java.aplicacionflashcards.dto.FlashcardsDTO;
import main.java.aplicacionflashcards.dto.NotificacionesDTO;
import main.java.aplicacionflashcards.dto.PuntosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador08Clubes {
	
	/* * * * * *  *
	 *  VARIABLES *
	 * * * * * *  */
	
	ModelAndView vista;
	ClubDTO club;
	InterfaceDAOClub dBClub;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAOPuntos dBPuntos;
	PuntosDTO puntos;
	String idClub;
	Fecha fecha;
	List<String> miembros;
	List<String> bloqueados;
	List<UsuarioDTO> usuariosMiembros;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	InterfaceDAONotificaciones dBNotificaciones;
	NotificacionesDTO notificaciones;
	int indice;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_VER_CLUBES = "redirect:/verClubes.html";
	static final String CONST_REDIRECT_VER_CLUB = "redirect:/verClub.html?idClub=";
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  FUNCIONALIDAD: CREAR, VER Y FORMAR PARTE DE LOS CLUBES *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
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
		return dBClub.getTodosClubes(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
	}
	
	@GetMapping(value = "/getClubesCreados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesCreados(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getMisClubes(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
	}
	
	@GetMapping(value = "/getClubesPertenezco", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ClubDTO> getClubesPertenezco(HttpServletRequest request, HttpServletResponse response){
		dBClub = Broker.getInstanciaClub();
		return dBClub.getClubesPertenezco(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
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
			miembros.add(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
			
			bloqueados = new LinkedList<>();
			
			club = new ClubDTO(idClub, request.getParameter("nombre"), request.getParameter("tema"),
					((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), 
					miembros, fecha.fechaHoy(), bloqueados);
			
			vista = new ModelAndView("vistaClubes");
			
			if(dBClub.insertaClub(club)) {
				
				dBPuntos = Broker.getInstanciaPuntos();
				puntos = dBPuntos.getPuntos(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
				puntos.setPuntos(puntos.getPuntos() + 2);
				dBPuntos.actualizaPuntos(puntos);
				
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
		vista = new ModelAndView(CONST_REDIRECT_VER_CLUBES);
		return vista;
	}
	
	@GetMapping(value = "/verClub")
	public ModelAndView verClubGet(@RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView("vistaClub");
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		vista.addObject("club", club);
		return vista;
	}
	
	@GetMapping(value = "/getUsuariosClub", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getUsuariosClub(@RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		dBClub = Broker.getInstanciaClub();
		dBUsuario = Broker.getInstanciaUsuario();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		miembros = club.getMiembros();
		usuariosMiembros = new LinkedList<>();
		for(indice=0; indice<miembros.size(); indice++) {
			usuariosMiembros.add(dBUsuario.getUsuarioDTO(miembros.get(indice)));
		}
		return usuariosMiembros;
	}
	
	@GetMapping(value = "/unirmeClub")
	public ModelAndView unirmeClub(@RequestParam("idClub") String idClub, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView(CONST_REDIRECT_VER_CLUBES);
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		miembros = club.getMiembros();
		miembros.add(username);
		club.setMiembros(miembros);
		dBClub.actualizaClub(club);
		return vista;
	}
	
	@GetMapping(value = "/dejarClub")
	public ModelAndView dejarClub(@RequestParam("idClub") String idClub, @RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		vista = new ModelAndView(CONST_REDIRECT_VER_CLUBES);
		dBClub = Broker.getInstanciaClub();
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
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
		vista = new ModelAndView(CONST_REDIRECT_VER_CLUBES);
		dBClub = Broker.getInstanciaClub();
		dBClub.eliminaClub(idClub);
		return vista;
	}
	
	@GetMapping(value = "/getColeccionesClub", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<FlashcardsDTO> getColeccionesClub(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {
		return Broker.getInstanciaFlashcards().coleccionesClub(id);
	}
	
	@GetMapping(value = "/adminAsignaAdminClub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView adminAsignaAdminClub(@RequestParam("usuario") String usuario, @RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		club.setAdministrador(usuario);
		dBClub.actualizaClub(club);
		return new ModelAndView(CONST_REDIRECT_VER_CLUB+idClub);
	}
	
	@GetMapping(value = "/adminEliminaUserClub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView adminEliminaUserClub(@RequestParam("usuario") String usuario, @RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		miembros = club.getMiembros();
		for(indice=0; indice<miembros.size(); indice++) {
			if(miembros.get(indice).equals(usuario)) {
				miembros.remove(indice);
				indice = miembros.size();
			}
		}
		club.setMiembros(miembros);
		dBClub.actualizaClub(club);
		return new ModelAndView(CONST_REDIRECT_VER_CLUB+idClub);
	}
	
	@GetMapping(value = "/adminBloqueaUserClub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView adminBloqueaUserClub(@RequestParam("usuario") String usuario, @RequestParam("idClub") String idClub, HttpServletRequest request, HttpServletResponse response) {
		club = dBClub.leerClub(idClub, ((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		miembros = club.getMiembros();
		for(indice=0; indice<miembros.size(); indice++) {
			if(miembros.get(indice).equals(usuario)) {
				miembros.remove(indice);
				indice = miembros.size();
			}
		}
		club.setMiembros(miembros);
		
		bloqueados = club.getBloqueados();
		bloqueados.add(usuario);
		club.setBloqueados(bloqueados);
		
		dBClub.actualizaClub(club);
		return new ModelAndView(CONST_REDIRECT_VER_CLUB+idClub);
	}
	
	//Metodo auxiliar get usernames en vista registro
	@GetMapping(value = "/getAmigosClubes", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<String> getAmigosClubes(HttpServletRequest request, HttpServletResponse response){
		dBRelaciones = Broker.getInstanciaRelaciones();
		return dBRelaciones.getAmigos(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
	}
	
	@GetMapping(value = "/invitarClub", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView invitarClub(@RequestParam("usuario") String usuario, @RequestParam("invita") String invita, @RequestParam("idClub") String idClub, @RequestParam("nClub") String nClub, HttpServletRequest request, HttpServletResponse response){
		dBNotificaciones = Broker.getInstanciaNotificaciones();
		dBNotificaciones.insertarNotificacion(usuario, "Invitación de " + invita + " para que se una al club "+nClub);
		return new ModelAndView(CONST_REDIRECT_VER_CLUB+idClub);
	}
	
}
