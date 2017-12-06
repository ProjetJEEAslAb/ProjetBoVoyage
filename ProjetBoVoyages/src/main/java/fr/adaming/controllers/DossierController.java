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

	// Injection de dépendance
	@Autowired
	IDossierService dossierService;

	// Méthodes controller

	// Affichage de la liste des dossiers
	@RequestMapping(value = "/listeDossiers", method = RequestMethod.GET)
	public ModelAndView afficherListeDossiers() {

		// Récupération de la liste
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

			redirectAttributes.addFlashAttribute("message", "Le dossier n'a pas pu être ajouté");
			return "redirect:afficheAjout";
		}
	}

	// Formulaire de modification d'un dossier
	@RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
	public ModelAndView afficheFormModif() {

		return new ModelAndView("dossier/modifDossier", "dossierModif", new Dossier());

	}

	@RequestMapping(value = "/modifDoss", method = RequestMethod.POST)
	public String soumettreFormModif(Model modele, @ModelAttribute("dossierModif") Dossier dossier,
			BindingResult result) {

		dossierService.updateDossier(dossier);

		if (result.hasErrors()) {
			return "dossier/modifDossier";
		} else {

			// Actualiser la liste de dossiers
			List<Dossier> listeOut = dossierService.getAllDossiers();
			modele.addAttribute("listeDossiers", listeOut);

			return "dossier/listeDossier";

		}

	}
	
	// Formulaire de modification d'un dossier
	@RequestMapping(value="/afficheModifStatut", method=RequestMethod.GET)
	public ModelAndView afficheFormModifStatut() {
		return new ModelAndView("dossier/modifStatut", "statutModif", new Dossier());
	}
	
	
	@RequestMapping(value="/modifierStatut", method=RequestMethod.POST)
	public String soumettreFormModifStatut(RedirectAttributes redirectAttributes, Model modele, @ModelAttribute("statutModif") Dossier dossier, BindingResult result) {
		
		// Appel de la méthode Service
		Dossier dosModifStatut=dossierService.updateStatutDossier(dossier.getId(), dossier.getStatut());
		
		if (result.hasErrors()){
			return "dossier/modifStatut";
		} else if (dosModifStatut==null){
			redirectAttributes.addFlashAttribute("message", "Le statut n'a pas pu être modifié: la séquence de modification n'a pas été respectée");
			return "redirect:afficheModifStatut";
		} else {
			
			// Actualiser la liste des dossiers
			List<Dossier> listeOut=dossierService.getAllDossiers();
			
			modele.addAttribute("listeDossiers", listeOut);
			
			return "dossier/listeDossier";
			
		}
		
		
	}
	

	// Formulaire de suppression d'un dossier
	@RequestMapping(value = "/afficheSuppr", method = RequestMethod.GET)
	public ModelAndView afficheFormSuppr() {

		return new ModelAndView("dossier/supprDossier", "dossierSuppr", new Dossier());

	}

	@RequestMapping(value = "/supprDoss", method = RequestMethod.POST)
	public String soumettreFormSuppr(Model modele, @ModelAttribute("dossierSuppr") Dossier dossier,
			BindingResult result) {

		// Appel de la méthode Service
		dossierService.deleteDossier(dossier);

		if (result.hasErrors()) {
			return "dossier/supprDossier";
		} else {

			// Actualiser la liste de dossiers
			List<Dossier> listeOut = dossierService.getAllDossiers();
			modele.addAttribute("listeDossiers", listeOut);

			return "dossier/listeDossier";

		}

	}

	// Formulaire de recherche d'un dossier
	@RequestMapping(value = "/afficheRecherche", method = RequestMethod.GET)
	public ModelAndView afficheFormRecherche() {
		return new ModelAndView("dossier/rechercheDossier", "dossierRecherche", new Dossier());
	}

	@RequestMapping(value = "/rechercheDoss", method = RequestMethod.POST)
	public String soumettreFormRecherche(Model modele, @ModelAttribute("dossierRecherche") Dossier dossier,
			BindingResult result) {

		// Appel de la méthode Service
		Dossier dossOut = dossierService.getDossierById(dossier.getId());

		if (result.hasErrors()) {

			return "dossier/rechercheDossier";

		} else {
			// Ajout du dossier trouvé au modèle
			modele.addAttribute("dossier", dossOut);
			return "dossier/rechercheDossier";
		}

	}
}
