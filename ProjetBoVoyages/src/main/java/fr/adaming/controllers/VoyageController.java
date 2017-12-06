package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
			String bleA = voyage.getFormule().getAvion().getArrivee();
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
		System.out.println(voyageEnCours);
		System.out.println("hotels de voyageEncours : "+voyageEnCours.getFormule().getHotels());
		Voyage vOut = voyageService.ajoutVoyage(voyageEnCours);
		System.out.println("vOut :"+vOut);
		
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
		System.out.println("2ème édition : Le voyage est " + voyageEnCours);
		System.out.println("Hotel :" + hotel);

		voyageEnCours.getFormule().getHotels().add(hotel);
		System.out.println(voyageEnCours.getFormule().getHotels());
		ModelAndView modele = new ModelAndView("voyage/hotel", "hotelAjoute",
				new Hotel());

		return modele;
	}

}
