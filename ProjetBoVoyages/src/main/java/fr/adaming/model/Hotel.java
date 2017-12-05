package fr.adaming.model;

import java.util.Date;

public class Hotel {
	private String adresse;
	private String chambre;
	private Date dateArrivee;
	private int Duree;
	public Hotel() {
		super();
	}
	public Hotel(String adresse, String chambre, Date dateArrivee, int duree) {
		super();
		this.adresse = adresse;
		this.chambre = chambre;
		this.dateArrivee = dateArrivee;
		Duree = duree;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getChambre() {
		return chambre;
	}
	public void setChambre(String chambre) {
		this.chambre = chambre;
	}
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	public int getDuree() {
		return Duree;
	}
	public void setDuree(int duree) {
		Duree = duree;
	}
	
}
