package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
public class AccueilController {
	
	@Autowired
	IVoyageService serviceVoyage;
	@Autowired
	IFormuleService serviceFormule;
	
	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!auth.getName().equals("anonymousUser")) {
			session.setAttribute("username", auth.getName());
			session.setAttribute("logged", true);
		}

	

		
		
		
		return new ModelAndView("accueil");
	}
	
	//Affichage formulaire recherche voyage
	@RequestMapping(value="/voyage/rechercheVoyage",method = RequestMethod.GET)
	public String afficherFormulaireRecherche(Model model){
		model.addAttribute("voyageRecherche",new Voyage());
		return "rechercheVoyageCritere";
		
	}
	
	@RequestMapping(value="/voyage/rechercheVoyage", method=RequestMethod.POST)
	public ModelAndView rechercheVoyage(@ModelAttribute("voyageRecherche") Voyage voyageDemande){
		//Conversion de  la date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			voyageDemande.setDateDepart(format.parse(voyageDemande.getDateString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long dateLong = voyageDemande.getDateDepart().getTime();
		java.sql.Date date = new java.sql.Date(dateLong);
		voyageDemande.setDateDepart(date);
		//System.out.println(date);

		
		System.out.println(voyageDemande);
		//System.out.println(voyageDemande.getPays());
		//Appel de la méthode pour filtrer.
		List<Voyage> listeVoyageInteressant = serviceVoyage.rechercheVoyageAvecCritere(voyageDemande);
		System.out.println(listeVoyageInteressant);
		return new ModelAndView("accueil");
	}
	@RequestMapping(value="/voyage/promotion",method = RequestMethod.GET)
	public ModelAndView affichagePromotion(){
		 	// Test sur les promotions en PDF.
		List<Voyage> listeVoyage = serviceVoyage.getAllVoyages();
		List<Voyage> listeVoyagePromotion = new ArrayList<>();
		for(Voyage voyage : listeVoyage){
			if(voyage.getReduction()>0){
				listeVoyagePromotion.add(voyage);
			}
		}
		ModelAndView modeleVue = new ModelAndView("Promotion", "listePromotion", listeVoyagePromotion);
		modeleVue.addObject("listeVoyage",listeVoyage);
		return modeleVue;
	}
	
	@RequestMapping(value="voyage/modifierPromotion",method = RequestMethod.GET)
	public ModelAndView changementPromotion(@RequestParam("identifiantVoyage") int id, @RequestParam("reduction")int reduction){
		
		if(reduction>0 && reduction<100){
			Voyage voyagePromotion = serviceVoyage.getVoyageById(id);
			voyagePromotion.setReduction(reduction);
			serviceVoyage.updateVoyage(voyagePromotion);
		}else{
			
		}
		
		List<Voyage> listeVoyage = serviceVoyage.getAllVoyages();
		List<Voyage> listeVoyagePromotion = new ArrayList<>();
		for(Voyage voyage : listeVoyage){
			if(voyage.getReduction()>0){
				listeVoyagePromotion.add(voyage);
			}
		}
		ModelAndView modeleVue = new ModelAndView("Promotion", "listePromotion", listeVoyagePromotion);
		modeleVue.addObject("listeVoyage",listeVoyage);
		return modeleVue;
	}
	
}
