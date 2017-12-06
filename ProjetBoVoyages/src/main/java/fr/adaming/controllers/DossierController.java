package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Dossier;
import fr.adaming.service.IDossierService;

@Controller
@Scope("session")
@RequestMapping("/dossier")
public class DossierController {

	// Injection de d�pendance
	@Autowired
	IDossierService dossierService;

	// M�thodes controller

	// Affichage de la liste des dossiers
	@RequestMapping(value = "/listeDossiers", method = RequestMethod.GET)
	public ModelAndView afficherListeDossiers() {

		// R�cup�ration de la liste
		List<Dossier> listeDossier = dossierService.getAllDossiers();

		return new ModelAndView("dossier/listeDossier", "listeDossiers", listeDossier);

	}

	// Formulaire d'ajout de dossier
	@RequestMapping(value = "/afficheAjout", method = RequestMethod.GET)
	public ModelAndView afficherFormAjout() {
		return new ModelAndView("dossier/ajoutDossier", "dossierAjout", new Dossier());
	}

	@RequestMapping(value = "/ajoutDoss", method = RequestMethod.POST)
	public String soumettreFormAjout(RedirectAttributes redirectAttributes, Model modele,
			@ModelAttribute("dossierAjout") Dossier dossier, BindingResult result) {
		Dossier dosOut = dossierService.addDossier(dossier);

		if (result.hasErrors()) {
			return "dossier/ajoutDossier";
		} else if (dosOut.getId() != 0) {
			// Actualiser la liste de dossiers

			List<Dossier> listeOut = dossierService.getAllDossiers();
			modele.addAttribute("listeDossiers", listeOut);

			return "dossier/listeDossier";
		} else {
			
			redirectAttributes.addFlashAttribute("message", "Le dossier n'a pas pu �tre ajout�");
			return "redirect:afficheAjout";
		}
	}

	// Formulaire de modification d'un dossier
	@RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
	public ModelAndView afficheFormModif() {

		return new ModelAndView("dossier/modifDossier", "dossierModif", new Dossier());

	}

	@RequestMapping(value="/modifDoss", method=RequestMethod.POST)
	public String soumettreFormModif(Model modele, @ModelAttribute("dossierModif") Dossier dossier,
			BindingResult result) {

		dossierService.updateDossier(dossier);
		
		if (result.hasErrors()){
			return "dossier/modifDossier";
		} else {
			
			// Actualiser la liste de dossiers
			List<Dossier> listeOut = dossierService.getAllDossiers();
			modele.addAttribute("listeDossiers", listeOut);
			
			return "dossier/listeDossier";
			
		}

	}
	
	
	// Formulaire de suppression d'un dossier
	@RequestMapping(value="/afficheSuppr", method=RequestMethod.GET)
	public ModelAndView afficheFormSuppr() {
		
		return new ModelAndView("dossier/supprDossier", "dossierSuppr", new Dossier());
		
	}
	
	@RequestMapping (value = "/supprDoss", method=RequestMethod.POST)
	public String soumettreFormSuppr(Model modele, @ModelAttribute("dossierSuppr") Dossier dossier, BindingResult result) {
		
		// Appel de la m�thode Service
		dossierService.deleteDossier(dossier);
		
		if (result.hasErrors()){
			return "dossier/supprDossier";
		} else {
			
			// Actualiser la liste de dossiers
			List<Dossier> listeOut = dossierService.getAllDossiers();
			modele.addAttribute("listeDossiers", listeOut);
			
			return "dossier/listeDossier";
			
		}
		
	}

}
