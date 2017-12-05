package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyage;

public interface IVoyageService {
	public Voyage ajoutVoyage(Voyage v);
	public List<Voyage> getAllVoyages();
	public Voyage getVoyageById(int id);
	public Voyage updateVoyage(Voyage v);
	public void deleteVoyage(int id);
}
