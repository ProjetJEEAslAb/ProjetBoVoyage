package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDossierDao;
import fr.adaming.model.Dossier;

@Service
@Transactional
public class DossierServiceImpl implements IDossierService{
	
	@Autowired
	IDossierDao dossierDao;
	
	public void setDossierDao(IDossierDao dossierDao) {
		this.dossierDao = dossierDao;
	}

	@Override
	public Dossier addDossier(Dossier dossier) {
		
		return dossierDao.addDossier(dossier);
	}

	@Override
	public List<Dossier> getAllDossiers() {
		
		return dossierDao.getAllDossiers();
	}

	@Override
	public Dossier getDossierById(int id) {
		
		return dossierDao.getDossierById(id);
	}

	@Override
	public Dossier updateDossier(Dossier dossier) {
		
		return dossierDao.updateDossier(dossier);
	}

	@Override
	public void deleteDossier(Dossier dossier) {
		
		Dossier dossierIn=dossierDao.getDossierById(dossier.getId());
		dossierDao.deleteDossier(dossierIn);
		
	}

	@Override
	public Dossier updateStatutDossier(int id, String statut) {
		
		Dossier dossier=dossierDao.getDossierById(id);

		// On ne veut permettre que certains types d'évolutions du statut
		
		if (dossier.getStatut().equals("en attente") && statut.equals("en cours")){
			dossier.setStatut(statut);
			dossierDao.updateDossier(dossier);
			System.out.println(dossierDao.getDossierById(dossier.getId()));
		} else if (dossier.getStatut().equals("en cours") && statut.equals("refusée")){
			dossier.setStatut(statut);
			dossierDao.updateDossier(dossier);
			System.out.println(dossierDao.getDossierById(dossier.getId()));
		} else if (dossier.getStatut().equals("en cours") && statut.equals("acceptée")){
			dossier.setStatut(statut);
			dossierDao.updateDossier(dossier);
			System.out.println(dossierDao.getDossierById(dossier.getId()));
		} else if (dossier.getStatut().equals("acceptée") && statut.equals("annulée")){
			dossier.setStatut(statut);
			dossierDao.updateDossier(dossier);
			System.out.println(dossierDao.getDossierById(dossier.getId()));
		} else {
			System.out.println("\n------Modification impossible du statut");
		}
				
		return dossier;
	}

}
