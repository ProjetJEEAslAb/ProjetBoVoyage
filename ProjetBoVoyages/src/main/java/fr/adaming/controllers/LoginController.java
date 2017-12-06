package fr.adaming.controllers;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@RequestMapping(value="/access_denied", method=RequestMethod.GET)
	public String afficherAccessDenied() {
		return "login/access_denied";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String afficherFormConnection() {
		return "login/login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String afficherFormDeconnection(HttpServletRequest request) {
		try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "accueil";
	}
	
	@RequestMapping(value="/loginFailure", method=RequestMethod.GET)
	public String loginErreur(ModelMap model) {
		model.addAttribute("erreur", true);
		return "login/login";
	}
}
