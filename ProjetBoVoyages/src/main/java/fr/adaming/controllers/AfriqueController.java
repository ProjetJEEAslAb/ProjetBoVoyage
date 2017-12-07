package fr.adaming.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;
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

}
