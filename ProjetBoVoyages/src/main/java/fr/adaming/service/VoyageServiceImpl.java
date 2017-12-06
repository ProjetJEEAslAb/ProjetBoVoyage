package fr.adaming.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;

@Service
@Transactional
public class VoyageServiceImpl implements IVoyageService {

	@Autowired
	IVoyageDao daoVoyage;

	@Override
	public Voyage ajoutVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return daoVoyage.ajoutVoyage(v);
	}

	@Override
	public List<Voyage> getAllVoyages() {
		return daoVoyage.getAllVoyages();
	}

	@Override
	public Voyage getVoyageById(int id) {
		return daoVoyage.getVoyageById(id);
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
		return daoVoyage.updateVoyage(v);
	}

	@Override
	public void deleteVoyage(int id) {
		daoVoyage.deleteVoyage(id);
	}

	@Override
	public List<Voyage> rechercheVoyageAvecCritere(Voyage critereVoyage) {
		// On vérifie les critères choisis par le client.
		List<String> listeParametre = new ArrayList<>();
		if(critereVoyage.getPays().equals("")||critereVoyage.getPays()==null){
			System.out.println("Pas de préférence pour le pays");
		}else{
			StringBuilder pays = new StringBuilder();
			pays.append("'%");
					
			pays.append(critereVoyage.getPays());
			pays.append("%'");
			
			StringBuilder criterePays =new StringBuilder("v.pays LIKE") ;
			criterePays.append(pays);
			System.out.println(criterePays);
			listeParametre.add(criterePays.toString());
		}
		if(critereVoyage.getDuree()==0){
			System.out.println("Pas de durée choisie");
		}else{
			String critereDuree ="v.duree="+critereVoyage.getDuree();
			listeParametre.add(critereDuree);
		}
		if(critereVoyage.getDateDepart()==null){
			System.out.println("Pas de date de départ choisie");
		}else{
			String critereDate ="v.dateDepart LIKE '"+critereVoyage.getDateDepart().toString()+"'";

			listeParametre.add(critereDate);
		}
		if(critereVoyage.getPrix()==0){
			System.out.println("Pas de prix maximum");
		}else{

			String criterePrix ="v.prix<="+critereVoyage.getPrix();

			listeParametre.add(criterePrix);
		}
		if(critereVoyage.getPlacesDisponibles()==0){
			System.out.println("Pas de places demandées");
		}else {
			String criterePlace ="v.placesDisponibles<=" + critereVoyage.getPlacesDisponibles();
			listeParametre.add(criterePlace);
		}
		
		if(critereVoyage.getDescriptionVoyage()==null){
			System.out.println("Pas de restriction demandée");
		}else{
			StringBuilder descri = new StringBuilder();
			descri.append("'%");
			String critereDescription ="v.descriptionVoyage LIKE";
			descri.append(critereDescription);
			descri.append("%'");
		}
		
		return daoVoyage.rechercherVoyageAvecCritere(critereVoyage,listeParametre);
	}

}
