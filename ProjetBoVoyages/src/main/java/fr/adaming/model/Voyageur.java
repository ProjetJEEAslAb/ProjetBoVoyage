package fr.adaming.model;

import java.util.Date;
import java.util.Set;

public class Voyageur {
	private int id;
	private String nom;
	private String prenom;
	private String civilite;
	private String adresse;
	private String telephone;
	private Date dateNaissance;
	private boolean client;
	
	private Set<Dossier> dossiers;
}
