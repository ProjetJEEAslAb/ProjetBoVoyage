package fr.adaming.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Agent;
import fr.adaming.model.Formule;
import fr.adaming.model.Voyage;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IVoyageService;
import fr.adaming.service.VoyageServiceImpl;

@Controller
//@Scope("request")
public class AccueilController {
//	@Autowired
//	private IAgentService agentService;
//
//	public void setAgentService(IAgentService agentService) {
//		this.agentService = agentService;
//	}
	@Autowired
	private IVoyageService serviceVoyage;
	
	
	

	public void setServiceVoyage(IVoyageService serviceVoyage) {
		this.serviceVoyage = serviceVoyage;
	}




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
		Date dateDepart = new Date();
		Voyage voyageTest = new Voyage(20, 520, dateDepart, 3, "Syldavie", "Europe");
		System.out.println(voyageTest);
		Formule formule = new Formule("Hotel Royal de Klow");
		System.out.println("Ajout du voyage");
		Voyage voyage = serviceVoyage.ajoutVoyage(voyageTest);
		System.out.println(voyage);
//		this.agentService. addAgent(new Agent("a@a", "a"));
		return new ModelAndView("accueil");
	}
}
