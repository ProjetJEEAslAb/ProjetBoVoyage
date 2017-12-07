package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Dossier;
import fr.adaming.model.Voyage;
import fr.adaming.model.Voyageur;
import fr.adaming.service.IDossierService;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
//@RequestMapping("/continent")
public class AfriqueController {
	int voyageurInscrit;
	int nombreDeVoyageur;
	Dossier dossier;
	@Autowired
	IVoyageService serviceVoyage;
	@Autowired
	IDossierService serviceDossier;

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

	@RequestMapping(value = "/voyage/reserver", method = RequestMethod.GET)
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
	
	@RequestMapping(value="/voyage/reservation",method=RequestMethod.POST)
	public ModelAndView traitementReservation(@ModelAttribute("client") Voyageur client,@RequestParam("assurance") String assurance,@RequestParam("nbVoyageur") int nbVoyageur,@RequestParam("identifiantReservation") int idReservation,@RequestParam("numCB") String numCB,@RequestParam("codeCB") String codeCB){
	
		nombreDeVoyageur = nbVoyageur;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			client.setDateNaissance(format.parse(client.getDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//recuperation du dossier du client
		client.setClient(true);
		dossier= new Dossier();
		dossier.setVoyage(serviceVoyage.getVoyageById(idReservation));
		Set<Voyageur> voyageurs = new HashSet<>();
		voyageurs.add(client);

		dossier.setVoyageurs(voyageurs);
		dossier.setAssurance(assurance);
		dossier.setCodeCB(numCB);
		dossier.setStatut("En attente");
		System.out.println(dossier.getVoyage());
		System.out.println(dossier.getVoyageurs());
		
		if(nbVoyageur>1){
			System.out.println("Ajout des acompagnants");
			voyageurInscrit = 1;
			ModelAndView modeleVue = new ModelAndView("inscriptionAccompagnants", "accompagnant",new Voyageur());
			modeleVue.addObject(dossier);
			return modeleVue;
		}else{
			return new ModelAndView("accueil");
		}
	}
	@RequestMapping(value="/voyage/ajoutAccompagnant",method=RequestMethod.POST)
	public ModelAndView ajoutAccompagnant(@ModelAttribute("accompagnant") Voyageur accompagnant){
		//System.out.println(idDossier);
		//Dossier dossier= serviceDossier.getDossierById(idDossier);
		Set<Voyageur> voyageurs = dossier.getVoyageurs();
		voyageurs.add(accompagnant);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			accompagnant.setDateNaissance(format.parse(accompagnant.getDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyageurInscrit = voyageurInscrit +1;
		if(voyageurInscrit == nombreDeVoyageur){
			serviceDossier.addDossier(dossier);
			return new ModelAndView("accueil");			
		}else{
			ModelAndView modeleVue = new ModelAndView("inscriptionAccompagnants", "accompagnant",new Voyageur());
			modeleVue.addObject(dossier);
			return modeleVue;

		}
	}
}
