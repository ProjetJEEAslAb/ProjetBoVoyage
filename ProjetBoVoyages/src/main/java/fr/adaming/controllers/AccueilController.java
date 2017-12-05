package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@Controller
//@Scope("request")
public class AccueilController {
//	@Autowired
//	private IAgentService agentService;
//
//	public void setAgentService(IAgentService agentService) {
//		this.agentService = agentService;
//	}

	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil() {
		/*
		 * 
		 * 
		 * 
		 * ========================= TESTS =========================
		 * 
		 * 
		 * 
		*/
//		this.agentService. addAgent(new Agent("a@a", "a"));
		return new ModelAndView("accueil");
	}
}
