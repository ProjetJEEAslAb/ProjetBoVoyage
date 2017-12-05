package fr.adaming.model;

import java.util.Date;
import java.util.Set;

public class Voyage {
	private int id;
	private int placesDisponibles;
	private double prix;
	private Date dateDepart;
	private int duree;
	private String pays;
	private String continent;
	
	private Formule formule;
	
	private Set<Dossier> dossiers;
}
