package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
@RequestMapping("/agent")
public class AgentController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView afficherRecapEtudiant() {
		System.out.println("Test");
		return new ModelAndView("acueil");
	}
}
