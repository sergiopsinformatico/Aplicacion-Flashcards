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
import main.java.aplicacionflashcards.db.dao.InterfaceDAORelacionesUsuarios;
import main.java.aplicacionflashcards.db.dao.InterfaceDAOUsuario;
import main.java.aplicacionflashcards.dto.RelacionesUsuariosDTO;
import main.java.aplicacionflashcards.dto.UsuarioDTO;

@Controller
@SessionAttributes("usuario")
public class Controlador07Gente {
	
	/* * * * * *  *
	 *  VARIABLES *
	 * * * * * *  */
	
	ModelAndView vista;
	InterfaceDAOUsuario dBUsuario;
	InterfaceDAORelacionesUsuarios dBRelaciones;
	RelacionesUsuariosDTO relaciones;
	List<UsuarioDTO> lista;
	List<UsuarioDTO> listaTodos;
	List<String> amigos;
	List<String> bloqueadores;
	List<String> bloqueados;
	List<String> pdaEnv;
	List<String> pdaRec;
	UsuarioDTO eUsuario;
	String tipoRelacion;
	int indice;
	int indiceTodos;
	boolean encontrado;
	
	/* * * * * *  * 
     * CONSTANTES *
	 * * * * * *  */
	
	static final String CONST_USUARIO = "usuario";
	static final String CONST_REDIRECT_PERFIL = "redirect:/verPerfil.html?usuarioPerfil=";
	static final String CONST_MENSAJE = "mensaje";
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 *  FUNCIONALIDAD: LISTAR Y VISUALIZAR USUARIOS Y AMIGOS *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	//Ver Gente
	@GetMapping(value = "/verGente")
	public ModelAndView gente(HttpServletRequest request, HttpServletResponse response) {
		if(CheckUsers.isUsuarioLogueado(request)) {
			
			vista = new ModelAndView("vistaGente");
		
		}else {
			vista = new ModelAndView("redirect:/inicio.html");
		}
		return vista;
	}
	
	@GetMapping(value = "/getTodosUsuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getTodosUsuarios(HttpServletRequest request, HttpServletResponse response){
		dBUsuario = Broker.getInstanciaUsuario();
		listaTodos = dBUsuario.getAllUsuarios(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		dBRelaciones = Broker.getInstanciaRelaciones();
		lista = new LinkedList<>();
		
		for(indice=0; indice<listaTodos.size(); indice++) {
			tipoRelacion = dBRelaciones.tipoRelacion(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), listaTodos.get(indice).getUsername());
			if(!(tipoRelacion.equals(""))) {
				eUsuario = listaTodos.get(indice);
				eUsuario.setTipoRelacion(tipoRelacion);
				lista.add(eUsuario);
			}
		}
		
		return lista;
	}
	
	//Listar Amigos
	@GetMapping(value = "/getAmigos", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getAmigos(HttpServletRequest request, HttpServletResponse response){
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		
		amigos = dBRelaciones.getAmigos(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		lista = new LinkedList<>();
		
		for(indice=0; indice<amigos.size(); indice++) {
			eUsuario = dBUsuario.getUsuarioDTO(amigos.get(indice));
			eUsuario.setTipoRelacion("amigo");
			lista.add(eUsuario);
		}
		
		return lista;
	}
	
	@GetMapping(value = "/getPdaRec", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getPdaRec(HttpServletRequest request, HttpServletResponse response){
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		
		pdaRec = dBRelaciones.getPeticionesRecibidas(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		lista = new LinkedList<>();
		
		for(indice=0; indice<pdaRec.size(); indice++) {
			eUsuario = dBUsuario.getUsuarioDTO(pdaRec.get(indice));
			eUsuario.setTipoRelacion("solRecibida");
			lista.add(eUsuario);
		}
		
		return lista;
	}
	
	@GetMapping(value = "/getPdaEnv", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getPdaEnv(HttpServletRequest request, HttpServletResponse response){
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		
		pdaEnv = dBRelaciones.getPeticionesAmistadEnviadas(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		lista = new LinkedList<>();
		
		for(indice=0; indice<pdaEnv.size(); indice++) {
			eUsuario = dBUsuario.getUsuarioDTO(pdaEnv.get(indice));
			eUsuario.setTipoRelacion("solEnviada");
			lista.add(eUsuario);
		}
		
		return lista;
	}
	
	@GetMapping(value = "/getBloqueados", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getBloqueados(HttpServletRequest request, HttpServletResponse response){
		dBUsuario = Broker.getInstanciaUsuario();
		dBRelaciones = Broker.getInstanciaRelaciones();
		
		bloqueados = dBRelaciones.getBloqueados(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		lista = new LinkedList<>();
		
		for(indice=0; indice<bloqueados.size(); indice++) {
			eUsuario = dBUsuario.getUsuarioDTO(bloqueados.get(indice));
			eUsuario.setTipoRelacion("bloqueado");
			lista.add(eUsuario);
		}
		
		return lista;
	}
	
	@GetMapping(value = "/eliminarAmigo")
	public ModelAndView eliminarAmigo(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.eliminarAmigo(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		vista.addObject(CONST_MENSAJE, username+" ya no es su amigo");
			
		return vista;
	}
	
	@GetMapping(value = "/aceptarAmistad")
	public ModelAndView aceptarAmistad(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.aceptarInvitacion(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		Broker.getInstanciaNotificaciones().insertarNotificacion(username, "Eres amigo de "+((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		vista.addObject(CONST_MENSAJE, username+" y tu sois amigos");
			
		return vista;
	}
	
	@GetMapping(value = "/rechazarAmistad")
	public ModelAndView rechazarAmistad(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.rechazarInvitacion(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		vista.addObject(CONST_MENSAJE, "Rechazada la solicitud de amistad de "+username);
		
		return vista;
	}
	
	@GetMapping(value = "/enviarPeticion")
	public ModelAndView enviarPeticion(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.enviarPeticionAmistad(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		Broker.getInstanciaNotificaciones().insertarNotificacion(username, "Has recibido una peticion de amistad de "+((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername());
		
		vista.addObject(CONST_MENSAJE, "Ha enviado una solicitud de amistad a "+username);
		
		return vista;
	}
	
	@GetMapping(value = "/bloquearUsuario")
	public ModelAndView bloquearUsuario(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.bloquearUsuario(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		vista.addObject(CONST_MENSAJE, "Ha bloqueado a " + username);
		
		return vista;
	}
	
	@GetMapping(value = "/desbloquearUsuario")
	public ModelAndView desbloquearUsuario(@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response){
		
		vista = new ModelAndView(CONST_REDIRECT_PERFIL+username);
		
		dBRelaciones = Broker.getInstanciaRelaciones();
		dBRelaciones.desbloquearUsuario(((UsuarioDTO)(request.getSession().getAttribute(CONST_USUARIO))).getUsername(), username);
		
		vista.addObject(CONST_MENSAJE, "Ha desbloqueado a " + username);
		
		return vista;
	}
}
