package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="hotels")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private String chambre;
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	private int duree;
	
	public Hotel() {
		super();
	}
	public Hotel(String adresse, String chambre, Date dateArrivee, int duree) {
		super();
		this.adresse = adresse;
		this.chambre = chambre;
		this.dateArrivee = dateArrivee;
		this.duree = duree;
	}
	public Hotel(int id, String adresse, String chambre, Date dateArrivee,
			int duree) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.chambre = chambre;
		this.dateArrivee = dateArrivee;
		this.duree = duree;
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
		return this.duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + id + ", adresse=" + adresse + ", chambre="
				+ chambre + ", dateArrivee=" + dateArrivee + ", duree=" + duree
				+ "]";
	}
}
