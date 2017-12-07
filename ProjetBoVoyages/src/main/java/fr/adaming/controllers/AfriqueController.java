package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;
import fr.adaming.model.Voyageur;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
@RequestMapping("/continent")
public class AfriqueController {

	@Autowired
	IVoyageService serviceVoyage;

	@RequestMapping(value = "/pageAfrique", method = RequestMethod.GET)
	public ModelAndView afficherFormModif() {
		List<Voyage> listeVoyage = serviceVoyage.getAllVoyages();
		List<Voyage> listeVoyagePromotion = new ArrayList<>();
		List<Voyage> listeVoyageSansPromotion = new ArrayList<>();
		
		for (Voyage voyage : listeVoyage) {
			if (voyage.getReduction() > 0) {
				listeVoyagePromotion.add(voyage);
			}else{
				listeVoyageSansPromotion.add(voyage);
			}
		}
		System.out.println(listeVoyagePromotion);

		ModelAndView modeleVue = new ModelAndView("pageAfrique", "listeVoyage", listeVoyage);
		modeleVue.addObject("listeSansPromotion",listeVoyageSansPromotion);
		modeleVue.addObject("listePromotion", listeVoyagePromotion);
		modeleVue.addObject("afriquePage", new Voyage());

		// return new ModelAndView("pageAfrique", "afriquePage", new Voyage());
		return modeleVue;
	}

	@RequestMapping(value = "/reserver", method = RequestMethod.GET)
	public ModelAndView afficherFormModifReserver(@RequestParam("identifiantVoyage") int id,@RequestParam("nbVoyageur") int nbVoyageur) {
		System.out.println(id);
		Voyage voyageAReserver = serviceVoyage.getVoyageById(id);
		System.out.println(voyageAReserver);
		
		
		
		ModelAndView modeleVue = new ModelAndView("reserverPage","client",new Voyageur());
		modeleVue.addObject("voyageAReserver",voyageAReserver);
		modeleVue.addObject("nbVoyageurs",nbVoyageur);
		//modeleVue.add("client",new Voyageur());
		
		return modeleVue;

	}
	
	@RequestMapping(value="/reservation",method=RequestMethod.POST)
	public ModelAndView traitementReservation(@ModelAttribute("client") Voyageur client,@RequestParam("assurance") String assurance,@RequestParam("nbVoyageur") int nbVoyageur,@RequestParam("identifiantReservation") int idReservation){
		//System.out.println("Voyage sélectionné" + voyageReserver);
		System.out.println(serviceVoyage.getVoyageById(idReservation));
		//System.out.println(dateNaissance);
		System.out.println("Assurance choisie" +assurance);
		System.out.println("Il y a" +nbVoyageur+"voyageur à partir");
		System.out.println("Client à partir" +client);
		return new ModelAndView("accueil");
	}
}
