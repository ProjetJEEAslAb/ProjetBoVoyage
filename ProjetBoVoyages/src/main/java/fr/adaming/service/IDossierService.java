package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Dossier;

public interface IDossierService {
	
public Dossier addDossier (Dossier dossier);
	
	public List<Dossier> getAllDossiers ();
	
	public Dossier getDossierById (int id);
	
	public Dossier updateDossier (Dossier dossier);
	
	public void deleteDossier (int id);

}
