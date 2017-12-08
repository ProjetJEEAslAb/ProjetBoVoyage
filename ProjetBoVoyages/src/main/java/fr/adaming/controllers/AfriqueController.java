package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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
// @RequestMapping("/continent")
public class AfriqueController {
	int voyageurInscrit;
	int nombreDeVoyageur;
	Voyageur clientPayeur;
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
			} else {
				listeVoyageSansPromotion.add(voyage);
			}
		}
		System.out.println(listeVoyagePromotion);

		ModelAndView modeleVue = new ModelAndView("pageAfrique", "listeVoyage", listeVoyage);
		modeleVue.addObject("listeSansPromotion", listeVoyageSansPromotion);
		modeleVue.addObject("listePromotion", listeVoyagePromotion);
		modeleVue.addObject("afriquePage", new Voyage());

		// return new ModelAndView("pageAfrique", "afriquePage", new Voyage());
		return modeleVue;
	}

	@RequestMapping(value = "/voyage/reserver", method = RequestMethod.GET)
	public ModelAndView afficherFormModifReserver(@RequestParam("identifiantVoyage") int id,
			@RequestParam("nbVoyageur") int nbVoyageur, @RequestParam("continent") String continent) {
		System.out.println(id);
		String message;
		Voyage voyageAReserver = serviceVoyage.getVoyageById(id);

		if (nbVoyageur > voyageAReserver.getPlacesDisponibles()) {
			message = "Il n'y pas assez de place disponibles";
			System.out.println(message);

			List<Voyage> listePromotion = new ArrayList<>();
			List<Voyage> listeSansPromotion = new ArrayList<>();

			// Récupération de la liste des voyages
			List<Voyage> liste = serviceVoyage.getAllVoyages();
			// modele.addAttribute("listeVoyages", liste);
			for (Voyage voyage : liste) {
				if (voyage.getReduction() > 0) {
					listePromotion.add(voyage);
				} else {
					listeSansPromotion.add(voyage);
				}
			}
			System.out.println(listePromotion);
			System.out.println(listeSansPromotion);

			ModelAndView modeleVue = new ModelAndView("voyage/listeVoyages", "message", message);
			modeleVue.addObject("continent", continent);
			modeleVue.addObject("message", message);
			modeleVue.addObject("voyageDesirer",new Voyage());

			modeleVue.addObject("listePromotion", listePromotion);
			modeleVue.addObject("listeSansPromotion", listeSansPromotion);
			
			return modeleVue;

		}

		ModelAndView modeleVue = new ModelAndView("reserverPage", "client", new Voyageur());
		modeleVue.addObject("voyageAReserver", voyageAReserver);
		modeleVue.addObject("nbVoyageurs", nbVoyageur);
		// modeleVue.add("client",new Voyageur());

		return modeleVue;

	}

	@RequestMapping(value = "/voyage/reservation", method = RequestMethod.POST)
	public ModelAndView traitementReservation(@ModelAttribute("client") Voyageur client,
			@RequestParam("assurance") String assurance, @RequestParam("nbVoyageur") int nbVoyageur,
			@RequestParam("identifiantReservation") int idReservation, @RequestParam("numCB") String numCB,
			@RequestParam("codeCB") String codeCB) {
		String message;
		nombreDeVoyageur = nbVoyageur;
		clientPayeur=client;
		// Voyage reservation = serviceVoyage.getVoyageById(idReservation);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			client.setDateNaissance(format.parse(client.getDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// recuperation du dossier du client
		client.setClient(true);
		dossier = new Dossier();
		dossier.setVoyage(serviceVoyage.getVoyageById(idReservation));
		Set<Voyageur> voyageurs = new HashSet<>();
		voyageurs.add(client);

		dossier.setVoyageurs(voyageurs);
		dossier.setAssurance(assurance);
		dossier.setCodeCB(numCB);
		dossier.setStatut("En attente");
		System.out.println(dossier.getVoyage());
		System.out.println(dossier.getVoyageurs());

		if (nbVoyageur > 1) {
			System.out.println("Ajout des acompagnants");
			voyageurInscrit = 1;
			ModelAndView modeleVue = new ModelAndView("inscriptionAccompagnants", "accompagnant", new Voyageur());
			modeleVue.addObject(dossier);
			return modeleVue;
		} else {
			// Enregistrement du dossier
			serviceDossier.addDossier(dossier);
			String messageRemerciementPartie1 = "Votre commande a bien été enregistrée.";
			String messageRemerciementPartie2 =	"Nous vous remerçions de la confiance que vous nous accorder !";

			ModelAndView modeleVue = new ModelAndView("accueil","messageRemerciementPartie1",messageRemerciementPartie1);
			modeleVue.addObject("messageRemerciementPartie2",messageRemerciementPartie2);
			return modeleVue;
			//return new ModelAndView("accueil","messageRemerciement",messageRemerciement);
		}
	}

	@RequestMapping(value = "/voyage/ajoutAccompagnant", method = RequestMethod.POST)
	public ModelAndView ajoutAccompagnant(@ModelAttribute("accompagnant") Voyageur accompagnant) {
		// System.out.println(idDossier);
		// Dossier dossier= serviceDossier.getDossierById(idDossier);
		Set<Voyageur> voyageurs = dossier.getVoyageurs();
		voyageurs.add(accompagnant);

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			accompagnant.setDateNaissance(format.parse(accompagnant.getDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyageurInscrit = voyageurInscrit + 1;
		if (voyageurInscrit == nombreDeVoyageur) {
			serviceDossier.addDossier(dossier);
			// envoi mail
			this.envoyerMail(clientPayeur);
			String messageRemerciementPartie1 = "Votre commande a bien été enregistrée.";
			String messageRemerciementPartie2 =	"Nous vous remerçions de la confiance que vous nous accorder !";

			ModelAndView modeleVue = new ModelAndView("accueil","messageRemerciementPartie1",messageRemerciementPartie1);
			modeleVue.addObject("messageRemerciementPartie2",messageRemerciementPartie2);
			return modeleVue;
		} else {
			ModelAndView modeleVue = new ModelAndView("inscriptionAccompagnants", "accompagnant", new Voyageur());
			modeleVue.addObject(dossier);
			return modeleVue;

		}
	}

	public void envoyerMail(Voyageur v) {
		// On envoie un mail à cette adresse parce qu'on est à l'arrache
		final String to = v.getMail();
		final String username = "thezadzad@gmail.com";
		final String password = "adaming44";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Confirmation de réservation");

			// Message du mail
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			StringBuilder sb = new StringBuilder();
			sb.append("Cher client / Chère cliente" + "\n");
			sb.append("Nous vous confirmons votre réservation.\n");

			sb.append("Nous vous souhaitons un agréable voyage !\nL'équipe BoVoyage");
			messageBodyPart.setContent(message, "text/html");
			messageBodyPart.setText(sb.toString());

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
