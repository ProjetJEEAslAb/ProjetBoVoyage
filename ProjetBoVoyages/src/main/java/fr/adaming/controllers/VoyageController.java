package fr.adaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
@RequestMapping("/voyage")
public class VoyageController {
	@Autowired
	IVoyageService voyageService;
	
	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	@RequestMapping(value="/afficheAjout", method=RequestMethod.GET)
	public ModelAndView afficheFormAjout(){
		return new ModelAndView("voyage/ajoutVoyage", "voyageAjoute", new Voyage());
	}
	
	@RequestMapping(value="/ajouteVoyage", method=RequestMethod.POST)
	public String soumettreFormAjout(Model modele, @ModelAttribute("voyageAjoute") Voyage voyage){
		Voyage vOut=voyageService.ajoutVoyage(voyage);
		System.out.println(voyage);
		if(vOut!=null){
			System.out.println(vOut);
		}
		return null;
	}
	
}
