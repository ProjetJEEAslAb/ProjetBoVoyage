package fr.adaming.service;

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
		if(critereVoyage.getPays()==null){
			
		}else{
			StringBuilder pays = new StringBuilder();
			pays.append("'%");
					
			pays.append(critereVoyage.getPays());
			pays.append("%'");
			
			StringBuilder criterePays =new StringBuilder("v.pays LIKE") ;
			criterePays.append(pays);
			listeParametre.add(criterePays.toString());
		}
		if(critereVoyage.getDuree()==0){
			
		}else{
			String critereDuree ="v.duree="+critereVoyage.getDuree();
			listeParametre.add(critereDuree);
		}
		if(critereVoyage.getDateDepart()==null){
			
		}else{

			String critereDate ="v.date="+critereVoyage.getDateDepart();

			listeParametre.add(critereDate);
		}
		if(critereVoyage.getPrix()==0){
			
		}else{

			String criterePrix ="v.prix<="+critereVoyage.getPrix();

			listeParametre.add(criterePrix);
		}
		if(critereVoyage.getPlacesDisponibles()==0){
			
		}else {
			String criterePlace ="v.placesDisponibles<=" + critereVoyage.getPlacesDisponibles();
			listeParametre.add(criterePlace);
		}
		
		if(critereVoyage.getDescriptionVoyage()==null){
			
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
