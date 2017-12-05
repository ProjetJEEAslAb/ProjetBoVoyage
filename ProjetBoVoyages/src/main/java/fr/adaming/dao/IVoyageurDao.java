package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Voyageur;

public interface IVoyageurDao   {

	public Voyageur addVoyageur(Voyageur v);
	public List<Voyageur> getAllVoyageurs();
	public Voyageur updateVoyageur(Voyageur v);
	public void deleteVoyageur(int id);
	public Voyageur getVoyageur(int id);
}
