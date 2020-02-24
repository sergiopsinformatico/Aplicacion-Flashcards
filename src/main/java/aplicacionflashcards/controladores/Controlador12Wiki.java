package main.java.aplicacionflashcards.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("usuario")
public class Controlador12Wiki {
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * *  *
	 *  Desarrollo del Proyecto: Wiki y Manual de Usuario *
	 * * * * * * * * * * * * * * * * * * * * * * * * * *  */
	
	@GetMapping(value = "/desarrolloProyecto")
	public ModelAndView verWikiProyecto(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWiki");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s0")
	public ModelAndView verWikiProyectoSprintCero(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint0");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s1")
	public ModelAndView verWikiProyectoSprintUno(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint1");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s2")
	public ModelAndView verWikiProyectoSprintDos(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint2");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s3")
	public ModelAndView verWikiProyectoSprintTres(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint3");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s4")
	public ModelAndView verWikiProyectoSprintCuatro(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint4");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s5")
	public ModelAndView verWikiProyectoSprintCinco(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint5");
	}
	
	@GetMapping(value = "/desarrolloProyecto-s6")
	public ModelAndView verWikiProyectoSprintSeis(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWikiSprint6");
	}
	
	@GetMapping(value = "/manualProyecto")
	public ModelAndView verManualUsuario(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaManual");
	}
	
}
