package fr.adaming.controllers;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	@Autowired
	ServletContext context;

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
	public ModelAndView soumettreFormAjout(@Validated FileModel file, BindingResult result, HttpServletRequest request,
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
			Date dateA = formatterH.parse(bleA + ":00");
			voyage.getFormule().getAvion().setHoraireDepart(dateA);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		voyage.getFormule().setHotels(new ArrayList<Hotel>());
		voyageEnCours = voyage;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			String uploadFolder = request.getServletContext().getRealPath("/");
			@SuppressWarnings("rawtypes")
			Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadFolder + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    item.write(uploadedFile);
                }
            }
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result.hasErrors()) {
			System.out.println("Erreur lors de l'upload de l'image");
		} else {
			String pays=voyage.getPays();
			String uploadPath = context.getRealPath("/images/") + pays + File.separator;
			System.out.println(uploadPath);
			File imagesDir = new File(uploadPath);
			if (!imagesDir.exists()) {
				imagesDir.mkdirs();
			}
			String filePath;
			Integer i = 0;
			while(true) {
				String tmpFilePath = uploadPath + i.toString() + ".jpg";
				File imageFile = new File(tmpFilePath);
				if (!imageFile.exists()) {
					filePath = tmpFilePath;
					break;
				}
				i++;
			}
			try {
				FileCopyUtils.copy(file.getFile().getBytes(), new File(filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
		System.out.println("Voyage : "+voyageEnCours);
		System.out.println("Hotel : "+hotel);
		System.out.println("Formule : "+voyageEnCours.getFormule());
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
		System.out.println(hotel);
		try {
			hotel.setDateArrivee(formatter.parse(hotel.getDateTemp()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("avec date : " +hotel);
		voyageEnCours.getFormule().getHotels().add(hotel);
		ModelAndView modele = new ModelAndView("voyage/hotel", "hotelAjoute",
				new Hotel());
		System.out.println("Voyage : "+voyageEnCours);
		System.out.println("Hotel : "+hotel);
		System.out.println("Formule : "+voyageEnCours.getFormule());
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
			Date dateA = formatterH.parse(bleA + ":00");
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
	public String afficheListeVoyages(Model modele, @RequestParam("pContinent") String continent) {
		
		List<Voyage> listePromotion = new ArrayList<>();
		List<Voyage> listeSansPromotion = new ArrayList<>();

		// Récupération de la liste des voyages
		List<Voyage> liste=voyageService.getAllVoyages();
		//modele.addAttribute("listeVoyages", liste);
		for(Voyage voyage : liste){
			if(voyage.getReduction()>0){
				listePromotion.add(voyage);
			}else{
				listeSansPromotion.add(voyage);
			}
		}
		System.out.println(listePromotion);
		System.out.println(listeSansPromotion);
		modele.addAttribute("continent", continent);
		modele.addAttribute("voyageDesirer",new Voyage());
		modele.addAttribute("listePromotion", listePromotion);
		modele.addAttribute("listeSansPromotion", listeSansPromotion);
		
		return "voyage/listeVoyages";
	}
	
	@RequestMapping(value="filtrer",method=RequestMethod.GET)
	public ModelAndView filtrerVoyage(@ModelAttribute("voyageDesirer") Voyage voyageDesirer,@RequestParam("continent") String continent){
		System.out.println(voyageDesirer);
		
		return new ModelAndView("accueil");
	}
	
	
	// Suppression d'un voyage
	@RequestMapping(value="/afficheSuppr", method=RequestMethod.GET)
	public ModelAndView afficheFormSuppr() {
		return new ModelAndView("voyage/supprVoyage", "voyageSuppr", new Voyage());
	}
	
	@RequestMapping(value="/supprimerVoyage", method=RequestMethod.POST)
	public String soumettreFormSuppr(Model modele, @ModelAttribute("voyageSuppr") Voyage voyage, BindingResult result) {
		
		// Appel de la méthode Service
		voyageService.deleteVoyage(voyage.getId());
		
		// Actualiser la liste des voyages
		List<Voyage> liste = voyageService.getAllVoyages();
		
		// Ajout de la liste au modèle
		modele.addAttribute("listeVoyages", liste);
		
		return "voyage/listeVoyages";
		
	}

}
