package fr.adaming.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;

@Controller
@Scope("session")
@RequestMapping("/continent")
public class AfriqueController {
	
	@RequestMapping(value = "/pageAfrique", method = RequestMethod.GET)
	public ModelAndView afficherFormModif() {

		return new ModelAndView("pageAfrique", "afriquePage", new Voyage());

	}

	@RequestMapping(value = "/reserverPage", method = RequestMethod.GET)
	public ModelAndView afficherFormModifReserver() {

		return new ModelAndView("reserverPage", "pageReserver", new Voyage());

	}
}
