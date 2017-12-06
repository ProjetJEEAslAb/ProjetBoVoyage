package fr.adaming.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class AccueilController {
	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.getName().equals("anonymousUser")) {
			session.setAttribute("username", auth.getName());
			session.setAttribute("logged", true);
		}
		return new ModelAndView("accueil");
	}
}
