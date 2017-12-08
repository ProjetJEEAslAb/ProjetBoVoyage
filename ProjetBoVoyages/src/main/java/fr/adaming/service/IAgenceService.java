package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agence;

public interface IAgenceService {
	public List<Agence> getAllAgences();
	public Agence addAgence(Agence agence);
}
