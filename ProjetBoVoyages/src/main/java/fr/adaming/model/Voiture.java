package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	@Override
	public String toString() {
		return "Voiture [categorie=" + categorie + ", loueur=" + loueur + "]";
	}
}
