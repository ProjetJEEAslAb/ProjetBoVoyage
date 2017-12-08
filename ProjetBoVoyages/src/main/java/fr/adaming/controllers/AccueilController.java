package fr.adaming.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.model.Voyage;
import fr.adaming.service.IFormuleService;
import fr.adaming.service.IVoyageService;

@Controller
@Scope("session")
public class AccueilController {
	List<Voyage> listeVoyage;
	List<Voyage> listeVoyagePromotion;
	
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

	

		
		
		
		return new ModelAndView("accueil");
	}
	
	//Affichage formulaire recherche voyage
	@RequestMapping(value="/voyage/rechercheVoyage",method = RequestMethod.GET)
	public String afficherFormulaireRecherche(Model model){
		model.addAttribute("voyageRecherche",new Voyage());
		return "rechercheVoyageCritere";
		
	}
	
	@RequestMapping(value="/voyage/rechercheVoyage", method=RequestMethod.POST)
	public ModelAndView rechercheVoyage(@ModelAttribute("voyageRecherche") Voyage voyageDemande){
		//Conversion de  la date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			voyageDemande.setDateDepart(format.parse(voyageDemande.getDateString()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long dateLong = voyageDemande.getDateDepart().getTime();
		java.sql.Date date = new java.sql.Date(dateLong);
		voyageDemande.setDateDepart(date);
		//System.out.println(date);

		
		System.out.println(voyageDemande);
		//System.out.println(voyageDemande.getPays());
		//Appel de la méthode pour filtrer.
		List<Voyage> listeVoyageInteressant = serviceVoyage.rechercheVoyageAvecCritere(voyageDemande);
		System.out.println(listeVoyageInteressant);
		return new ModelAndView("accueil");
	}
	@RequestMapping(value="/voyage/promotion",method = RequestMethod.GET)
	public ModelAndView affichagePromotion(){
		 	// Test sur les promotions en PDF.
		listeVoyage = serviceVoyage.getAllVoyages();
		listeVoyagePromotion = new ArrayList<>();
		for(Voyage voyage : listeVoyage){
			if(voyage.getReduction()>0){
				listeVoyagePromotion.add(voyage);
			}
		}
		ModelAndView modeleVue = new ModelAndView("Promotion", "listePromotion", listeVoyagePromotion);
		modeleVue.addObject("listeVoyage",listeVoyage);
		return modeleVue;
	}
	
	@RequestMapping(value="voyage/modifierPromotion",method = RequestMethod.GET)
	public ModelAndView changementPromotion(@RequestParam("identifiantVoyage") int id, @RequestParam("reduction")int reduction){
		String message ="";
		if(reduction>0 && reduction<100){
			Voyage voyagePromotion = serviceVoyage.getVoyageById(id);
			voyagePromotion.setReduction(reduction);
			serviceVoyage.updateVoyage(voyagePromotion);
		}else{
			if(reduction==0){
				Voyage voyagePromotion = serviceVoyage.getVoyageById(id);
				voyagePromotion.setReduction(reduction);
				serviceVoyage.updateVoyage(voyagePromotion);
				message="La promotion pour le voyage en direction " +voyagePromotion.getPays() +" du "+voyagePromotion.getDateDepart()+" est terminée.";
				System.out.println(message);
			}
		}
		
		List<Voyage> listeVoyage = serviceVoyage.getAllVoyages();
		List<Voyage> listeVoyagePromotion = new ArrayList<>();
		for(Voyage voyage : listeVoyage){
			if(voyage.getReduction()>0){
				listeVoyagePromotion.add(voyage);
			}
		}
		ModelAndView modeleVue = new ModelAndView("Promotion", "listePromotion", listeVoyagePromotion);
		modeleVue.addObject("listeVoyage",listeVoyage);
		modeleVue.addObject("message",message);
		return modeleVue;
	}
	
	@RequestMapping(value="voyage/envoyerEmail", method=RequestMethod.POST)
	public ModelAndView envoyerMail(@RequestParam("email") String adresseMail){
		System.out.println(adresseMail);
		final String to = adresseMail;
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
			message.setSubject("Offre promotionnelle BoVoyage");
			
			// Message du mail
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			StringBuilder sb = new StringBuilder();
			sb.append("Cher client / Chère cliente" + "\n");
			sb.append("Nous vous proposons les promotions suivantes pour votre prochain voyage :\n");
			for (Voyage v : listeVoyagePromotion){
				double prixReduit=v.getPrix()*v.getReduction();
				sb.append("Partez en "+v.getPays()+" pour seulement "+prixReduit+" !\n");
			}
			
			sb.append("\nhttp://localhost:8080/ProjetBoVoyages/voyage/pubPromo");
			
			sb.append("\nPour plus de détails, voyez la pièce jointe.\n");
			
			sb.append("Nous espérons que vous voyagerez bientôt à nouveau avec nous !\nL'équipe BoVoyage");
			messageBodyPart.setContent(message, "text/html");
			messageBodyPart.setText(sb.toString());
			
			
			//Piece Jointe
			MimeBodyPart attachPart = new MimeBodyPart();
			DataSource pieceJointe = new FileDataSource(System.getProperty("user.home") + "\\Desktop\\Offres.pdf");
			attachPart.setDataHandler(new DataHandler(pieceJointe));
			attachPart.setFileName("offres.pdf");
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachPart);
			message.setContent(multipart);
			Transport.send(message);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		ModelAndView modeleVue = new ModelAndView("Promotion", "listePromotion", listeVoyagePromotion);
		modeleVue.addObject("listeVoyage",listeVoyage);
		return modeleVue;
	}
	
	//pub promotions
	
		@RequestMapping(value="/voyage/pubPromo",method = RequestMethod.GET)
		public String afficherPub(Model model){
			model.addAttribute("pubPage",new Voyage());
			return "pubPage";
			
		}
}
