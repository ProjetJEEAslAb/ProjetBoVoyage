package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agence;

public interface IAgenceDao {
	public List<Agence> getAllAgences();
	public Agence addAgence(Agence agence);
}
