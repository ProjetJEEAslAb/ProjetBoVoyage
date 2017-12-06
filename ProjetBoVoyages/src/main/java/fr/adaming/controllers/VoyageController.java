package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Formule;
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
		Voyage voyage=new Voyage();
		voyage.setFormule(new Formule());
		return new ModelAndView("voyage/ajoutVoyage", "voyageAjoute", voyage );
	}
	
	@RequestMapping(value="/ajouteVoyage", method=RequestMethod.POST)
	public String soumettreFormAjout(Model modele, @ModelAttribute("voyageAjoute") Voyage voyage){
		
		System.out.println(voyage);
		System.out.println(voyage.getFormule());
		System.out.println(voyage.getFormule().getAvion().getArrivee());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterH = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		try {
			//voyage.setDateDepart(formatter.parse(voyage.getDateString()));
			String ble=voyage.getFormule().getAvion().getArrivee()+":00Z";
			System.out.println("ble : "+ble);
			Date date = formatterH.parse(ble);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Voyage vOut=voyageService.ajoutVoyage(voyage);
		
		if(vOut!=null){
			System.out.println(vOut);
		}
		return "accueil";
	}
	
}
