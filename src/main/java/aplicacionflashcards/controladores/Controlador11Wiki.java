package main.java.aplicacionflashcards.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("usuario")
public class Controlador11Wiki {
	
	@GetMapping(value = "/verWikiProyecto")
	public ModelAndView verWikiProyecto(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("vistaWiki");
	}
}
