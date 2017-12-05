package fr.adaming.model;

import javax.persistence.Embeddable;

@Embeddable
public class Voiture {
	private String categorie;
	private String loueur;
	public Voiture() {
		super();
	}
	public Voiture(String categorie, String loueur) {
		super();
		this.categorie = categorie;
		this.loueur = loueur;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getLoueur() {
		return loueur;
	}
	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}
	
}
