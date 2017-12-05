package fr.adaming.model;

import java.util.Set;

public class Dossier {
	private int id;
	private String statut;
	private String assurance;
	private String codeCB;
	
	private Voyage voyage;
	
	private Set<Voyageur> voyageurs;
}
