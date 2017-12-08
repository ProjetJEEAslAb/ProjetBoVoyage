package fr.adaming.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Agence;
import fr.adaming.service.IAgenceService;

@Controller
@RequestMapping(value="/agence")
public class AgenceController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IAgenceService agenceService;
	
	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}
	
	
	@RequestMapping(value="/listeAgences", method=RequestMethod.GET)
	public ModelAndView afficherListe() {
		List<Agence> listeAgences = this.agenceService.getAllAgences();
		return new ModelAndView("agence/listeAgences", "listeAgences", listeAgences);
	}
	
	@RequestMapping(value="/afficheAjout", method=RequestMethod.GET)
	public ModelAndView afficherAjoutAgence() {
		return new ModelAndView("agence/ajoutAgence", "ajoutAgence", new Agence());
	}
	@RequestMapping(value="/ajoutAgence", method=RequestMethod.POST)
	public ModelAndView soumettreFormAjout() {
		List<Agence> listeAgences = this.agenceService.getAllAgences();
		return new ModelAndView("agence/listeAgences", "listeAgences", listeAgences);
	}
}
