package fr.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.model.Voyage;
import fr.adaming.model.Voyageur;
import fr.adaming.service.IVoyageurService;

@Controller
@Scope("session")
@RequestMapping("/voyageur")
public class VoyageurController {

	// ================injection dependence==========================//
	@Autowired
	IVoyageurService voyageurService;

	public void setVoyageurService(IVoyageurService voyageurService) {
		this.voyageurService = voyageurService;
	}

	// =========================methode
	// controller================================//

	// ========liste===========//
	@RequestMapping(value = "/listeVoyageurs", method = RequestMethod.GET)
	public ModelAndView afficheListeVoyageurs() {

		// recuperation de la liste
		List<Voyageur> liste = voyageurService.getAllVoyageurs();

		return new ModelAndView("voyageur/listeVoyageur", "listeVoyageurs", liste);

	}
	// =============controller ajout=========//

	@RequestMapping(value = "/afficheAjout", method = RequestMethod.GET)
	public ModelAndView afficheFormAjout() {
		return new ModelAndView("voyageur/ajoutVoyageur", "voyageurAjout", new Voyageur());
	}

	@RequestMapping(value = "/ajout", method = RequestMethod.POST)
	public String soumettreFormAjout(Model modele, @ModelAttribute("voyageurAjout") Voyageur voyageur) {
		Voyageur vOut = voyageurService.addVoyageur(voyageur);
		if (vOut != null) {

		}
		return null;
	}

	// =============controller modif=========//

	@RequestMapping(value = "/afficheModif", method = RequestMethod.GET)
	public ModelAndView afficherFormModif() {

		return new ModelAndView("voyageur/modifVoyageur", "voyageurModif", new Voyageur());

	}

	@RequestMapping(value = "/modif", method = RequestMethod.POST)
	public String soumettreFormModif(RedirectAttributes RedirectAttributes, Model model,
			@ModelAttribute("voyageurModif") Voyageur voyageur) {

		// appelle de la methode service
		Voyageur vOut = voyageurService.updateVoyageur(voyageur);

		if (vOut != null) {

			// actualiser la liste dans accueil
			List<Voyageur> liste = voyageurService.getAllVoyageurs();

			// ajout de la liste au model
			model.addAttribute("listeVoyageurs", liste);
			return "accueil";

		} else {
			// le message d'erreur si le voyageur n'est pas modifié
			RedirectAttributes.addFlashAttribute("message", "le voyageur n'est pas modifié");
			return "redirect:afficheModif";// redirection
		}
	}
	// =============controller suppr=========//

	@RequestMapping(value = "/afficheSuppr", method = RequestMethod.GET)
	public ModelAndView afficherFormSup() {

		return new ModelAndView("voyageur/supprVoyageur", "voyageurSuppr", new Voyageur());

	}

	@RequestMapping(value = "/supprVoyageur", method = RequestMethod.POST)
	public String soumettreFormSup(RedirectAttributes RedirectAttributes, Model model, @RequestParam("pId") int id) {

		// appelle de la methode service
		Voyageur vIn = new Voyageur();
		vIn.setId(id);
		voyageurService.deleteVoyageur(id);

		// actualiser la liste dans accueil
		List<Voyageur> liste = voyageurService.getAllVoyageurs();

		// ajout de la liste au model
		model.addAttribute("listeVoyageurs", liste);

		return "accueil";

	}
	// =============controller recherche=========//

	@RequestMapping(value = "/afficheRecherche", method = RequestMethod.GET)
	public String afficheFormRecherche(ModelMap model) {
		model.addAttribute("voyageurRecherche", new Voyageur());
		return "voyageur/rechercheVoyageur";
	}

	@RequestMapping(value = "/rechercheVoyageur", method = RequestMethod.POST)
	public String soumettreFormRecherche(RedirectAttributes RedirectAttributes, Model model,
			@RequestParam("pId") int id) {

		// appelle de la methode service
		Voyageur vOut = voyageurService.getVoyageur(id);

		// appelle de la methode service
		Voyageur vIn = new Voyageur();
		vIn.setId(id);
		voyageurService.getVoyageur(id);

		// actualiser la liste dans accueil
		List<Voyageur> liste = voyageurService.getAllVoyageurs();

		// ajout de la liste au model
		model.addAttribute("listeVoyageurs", liste);

		return "voyageur/rechercheVoyageur";

	}

}
