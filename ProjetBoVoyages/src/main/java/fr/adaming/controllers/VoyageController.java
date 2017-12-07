package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Formule;
import fr.adaming.model.Hotel;
import fr.adaming.model.Voyage;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
@RequestMapping("/voyage")
public class VoyageController {

	@Autowired
	IVoyageService voyageService;

	Voyage voyageEnCours;

	public void setVoyageService(IVoyageService voyageService) {
		this.voyageService = voyageService;
	}

	@RequestMapping(value = "/afficheAjout", method = RequestMethod.GET)
	public ModelAndView afficheFormAjout() {
		Voyage voyage = new Voyage();
		voyage.setFormule(new Formule());
		return new ModelAndView("voyage/ajoutVoyage", "voyageAjoute", voyage);
	}

	@RequestMapping(value = "/ajouteVoyage", method = RequestMethod.POST)
	public ModelAndView soumettreFormAjout(
			@ModelAttribute("voyageAjoute") Voyage voyage) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterH = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss");
		try {
			voyage.setDateDepart(formatter.parse(voyage.getDateString()));
			String bleD = voyage.getFormule().getAvion().getArrivee();
			bleD.replaceAll("Z$", "+0000");
			Date dateD = formatterH.parse(bleD + ":00");
			voyage.getFormule().getAvion().setHoraireArrivee(dateD);
			String bleA = voyage.getFormule().getAvion().getDepart();
			bleA.replaceAll("Z$", "+0000");
			Date dateA = formatterH.parse(bleD + ":00");
			voyage.getFormule().getAvion().setHoraireDepart(dateA);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyage.getFormule().setHotels(new HashSet<Hotel>());

		voyageEnCours = voyage;

		return new ModelAndView("voyage/hotelRedirect", "voyageAjoute", voyage);
	}

	@RequestMapping(value = "/hotels", method = RequestMethod.GET)
	public ModelAndView afficheAjoutHotel(
			@ModelAttribute("voyageAjoute") Voyage voyage) {
		System.out.println("Le voyage est " + voyageEnCours);
		ModelAndView modele = new ModelAndView("voyage/hotel", "voyageAjoute",
				voyage);
		modele.addObject("hotelAjoute", new Hotel());
		return modele;
	}

	@RequestMapping(value = "/ajouteDernierHotel", method = RequestMethod.POST)
	public ModelAndView ajoutDernierHotel(
			@ModelAttribute("hotelAjoute") Hotel hotel) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			hotel.setDateArrivee(formatter.parse(hotel.getDateTemp()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyageEnCours.getFormule().getHotels().add(hotel);
		Voyage vOut = voyageService.ajoutVoyage(voyageEnCours);		
		if (vOut != null) {
			System.out.println("hotels de vOut : "+vOut.getFormule().getHotels());
			return new ModelAndView("accueil");
		} else {
			return new ModelAndView("voyage/hotel", "hotelAjoute",
					new Hotel());
		}
	}

	@RequestMapping(value = "/ajouteAutreHotel", method = RequestMethod.POST)
	public ModelAndView ajoutAutreHotel(
			@ModelAttribute("hotelAjoute") Hotel hotel) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			hotel.setDateArrivee(formatter.parse(hotel.getDateTemp()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyageEnCours.getFormule().getHotels().add(hotel);
		ModelAndView modele = new ModelAndView("voyage/hotel", "hotelAjoute",
				new Hotel());

		return modele;
	}
	
	@RequestMapping(value="/modifVoyage", method=RequestMethod.GET)
	public String afficheModifVoyage(Model modele){
		System.out.println("Yo !");
		modele.addAttribute("voyageModif", new Voyage());
		return "voyage/modifVoyage";
	}
	
	@RequestMapping(value="/modifierVoyage", method=RequestMethod.POST)
	public ModelAndView soumetModifVoyage(@ModelAttribute("voyageModif") Voyage voyage){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatterH = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss");
		try {
			voyage.setDateDepart(formatter.parse(voyage.getDateString()));
			String bleD = voyage.getFormule().getAvion().getArrivee();
			bleD.replaceAll("Z$", "+0000");
			Date dateD = formatterH.parse(bleD + ":00");
			voyage.getFormule().getAvion().setHoraireArrivee(dateD);
			String bleA = voyage.getFormule().getAvion().getDepart();
			bleA.replaceAll("Z$", "+0000");
			Date dateA = formatterH.parse(bleD + ":00");
			voyage.getFormule().getAvion().setHoraireDepart(dateA);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// On ne change pas les hôtels sur cette page, il faut donc les récupérer depuis la DB
		Voyage vInit=voyageService.getVoyageById(voyage.getId());
		voyage.getFormule().setHotels(vInit.getFormule().getHotels());
		voyage.getFormule().setId(vInit.getFormule().getId());
		Voyage vOut=voyageService.updateVoyage(voyage);
		if (vOut!=null){
			return new ModelAndView("accueil");
		} else {
			return new ModelAndView("voyage/modifVoyage", "voyageModif", new Voyage());
		}
	}
	
	// Méthode d'affichage de la liste de voyages
	@RequestMapping(value="/afficheListeVoyage", method=RequestMethod.GET)
	public ModelAndView afficheListeVoyages() {
		
		// Récupération de la liste des voyages
		List<Voyage> liste=voyageService.getAllVoyages();
		
		return new ModelAndView("/listeVoyages", "listeVoyages", liste);
		
	}
	

}
