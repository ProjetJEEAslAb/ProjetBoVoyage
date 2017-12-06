package fr.adaming.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		//Test Liste Voyage
		//List<Voyage> listeVoyage = serviceVoyage.getAllVoyages();
		//System.out.println("Ensemble des voyages proposés" +listeVoyage);
		
		//Test Récupération voyage
	//	System.out.println(serviceVoyage.getVoyageById(1));
		//Test suppression voyage et formule
		//serviceVoyage.deleteVoyage(1);
		Voyage voyageCritere = new Voyage();
		voyageCritere.setPays("lda");
		voyageCritere.setDuree(3);
		//voyageCritere.setDateDepart(new Date());
		voyageCritere.setPrix(2000);
		voyageCritere.setPlacesDisponibles(5);
		System.out.println(serviceVoyage.rechercheVoyageAvecCritere(voyageCritere));
		return new ModelAndView("accueil");
	}
}
