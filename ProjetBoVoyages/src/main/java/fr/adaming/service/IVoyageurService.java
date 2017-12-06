package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyageur;

public interface IVoyageurService {

	public Voyageur addVoyageur(Voyageur v);
	public List<Voyageur> getAllVoyageurs();
	public Voyageur updateVoyageur(Voyageur v);
	public void deleteVoyageur(Voyageur v);
	public Voyageur getVoyageurById(Voyageur v);
	
}
