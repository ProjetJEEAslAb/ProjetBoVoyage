package fr.adaming.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String chambre;
	@Temporal(TemporalType.DATE)
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
	public Hotel(int id, String adresse, String chambre, Date dateArrivee,
			int duree) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.chambre = chambre;
		this.dateArrivee = dateArrivee;
		Duree = duree;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
