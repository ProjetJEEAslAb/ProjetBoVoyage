package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Agence implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private int id;
	private String adresse;
	private String description;
	
	public Agence() {
		super();
	}
	public Agence(String adresse, String description) {
		super();
		this.adresse = adresse;
		this.description = description;
	}
	public Agence(int id, String adresse, String description) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Agence [id=" + id + ", adresse=" + adresse + ", description="
				+ description + "]";
	}
}
