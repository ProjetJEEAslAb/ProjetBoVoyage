package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Dossier;

public interface IDossierDao {
	
	public Dossier addDossier (Dossier dossier);
	
	public List<Dossier> getAllDossiers ();
	
	public Dossier getDossierById (int id);
	
	public Dossier updateDossier (Dossier dossier);
	
	public void deleteDossier (Dossier dossier);

}
