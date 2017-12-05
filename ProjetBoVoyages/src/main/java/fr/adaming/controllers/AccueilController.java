package fr.adaming.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Agent;
import fr.adaming.model.Avion;
import fr.adaming.model.Formule;
import fr.adaming.model.Voiture;
import fr.adaming.model.Voyage;
import fr.adaming.model.Voyageur;
import fr.adaming.service.IAgentService;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IVoyageService;
import fr.adaming.service.IVoyageurService;
import fr.adaming.service.VoyageServiceImpl;

@Controller
//@Scope("request")
public class AccueilController {
//	@Autowired
//	private IAgentService agentService;
//
//	public void setAgentService(IAgentService agentService) {
//		this.agentService = agentService;
//	}
	@Autowired
	private IVoyageService serviceVoyage;
	@Autowired
	private IVoyageurService serviceVoyageur;
	@Autowired
	private IFormuleService serviceFormule;
	

	public void setServiceVoyage(IVoyageService serviceVoyage) {
		this.serviceVoyage = serviceVoyage;
	}




	@RequestMapping(value="accueil", method=RequestMethod.GET)
	public ModelAndView afficherAccueil() {
		/*
		 * 
		 * 
		 * 
		 * ========================= TESTS =========================
		 * 
		 * 
		 * 
		*/
		Date dateTest = new Date();
//		Voyage voyageTest = new Voyage(20, 520, dateTest, 3, "Syldavie", "Europe");
//		System.out.println(voyageTest);
//		System.out.println("Ajout du voyage");
//		Voyage voyage = serviceVoyage.ajoutVoyage(voyageTest);
//		System.out.println(voyage);
		//Voyageur voyageur1 = new Voyageur("Test", "Ajout", "Mr", "2 Route de l'hypothèse 00000 Possible", "0123456789", dateTest, true);
		//Voyageur voyageur2 = new Voyageur("Test", "Ajout", "Mr", "2 Route de l'hypothèse 00000 Possible", "0123456789", dateTest, false);
		
	//	Voyageur voyageurModif1 = new Voyageur(1, "Test", "Ajout", "Mr", "2 Route de l'hypothèse 00000 Possible", "0123456789", dateTest,false);
		//Voyageur voyageurModif2 = new Voyageur(2, "Test", "Ajout", "Mr", "2 Route de l'hypothèse 00000 Possible", "0123456789", dateTest,true);

		//serviceVoyageur.updateVoyageur(voyageurModif1);
		//serviceVoyageur.updateVoyageur(voyageurModif2);

		//serviceVoyageur.addVoyageur(voyageur1);
		//serviceVoyageur.addVoyageur(voyageur2);
		
		//serviceVoyageur.deleteVoyageur(4);
		
		//Voyageur voyageurRecherche = serviceVoyageur.getVoyageur(1);
	//	System.out.println("Le voyageur recherché est "+voyageurRecherche);
	//	System.out.println("L'ensemble des voyageurs" +serviceVoyageur.getAllVoyageurs());
//		this.agentService. addAgent(new Agent("a@a", "a"));
		
		//Formule formule = new Formule("Hotel Royal de Klow");
		//Avion avionTest = new Avion("Air Syldavie", new Date(), new Date());
		///Voiture voiture = new Voiture("Caisse à savon", "Les voitures syldaviennes");
		//formule.setVoiture(voiture);
		//formule.setAvion(avionTest);
		//Formule formuleAjoute = serviceFormule.ajouterFormule(formule);
		//System.out.println("Avant " + formule);
		//System.out.println("Après " + formule);
		
		Formule formuleModif = new Formule(1, "Pension Complete");
		Avion avionModif = new Avion("Les ailes du pélican noir", new Date(), new Date());
		Voiture voitureModif = new Voiture("La Bordure", "Les voitures moustachistes");
		formuleModif.setAvion(avionModif);
		formuleModif.setVoiture(voitureModif);
	//	serviceFormule.modifierFormule(formuleModif);
		Voyage voyageTest = new Voyage(20, 520, dateTest, 3, "Syldavie", "Europe");
		voyageTest.setFormule(formuleModif);
		
		// Ajout formule/voyage;
//		Formule formule = new Formule("Pension Complete");
//		Avion avion = new Avion("Les ailes du pélican noir", new Date(), new Date());
//		Voiture voiture = new Voiture("La Grande Bordure", "Les voitures moustachistes");
//		formule.setAvion(avion);
//		formule.setVoiture(voiture);
//		//On enregistre la formule
//		Formule formuleAjoutDirect = serviceFormule.ajouterFormule(formule);
//		voyageTest.setFormule(formule);
//		
//		serviceVoyage.ajoutVoyage(voyageTest);
//		//Suppression voyage
//		serviceVoyage.deleteVoyage(4);
				
		//Modification d'un voyage
		Voyage voyageModif = new Voyage(5, 5, 120, new Date(),20, "Royaume de Syldavie", "Europe de l'Est");
		formuleModif.setId(9);
		voyageModif.setFormule(formuleModif);
		serviceVoyage.updateVoyage(voyageModif);
		return new ModelAndView("accueil");
	}
}
