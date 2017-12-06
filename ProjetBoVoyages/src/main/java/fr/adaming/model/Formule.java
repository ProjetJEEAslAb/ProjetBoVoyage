package fr.adaming.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="formules")
public class Formule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String hebergement;
	@Embedded
	private Avion avion;
	@Embedded
	private Voiture voiture;
	@OneToMany(mappedBy="id")
	private Set<Hotel> hotels;
	
	public Formule() {
		super();
	}
	public Formule(String hebergement) {
		super();
		this.hebergement = hebergement;
	}
	public Formule(int id, String hebergement) {
		super();
		this.id = id;
		this.hebergement = hebergement;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHebergement() {
		return hebergement;
	}
	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Set<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	@Override
	public String toString() {
		return "Formule [id=" + id + ", hebergement=" + hebergement
				+ ", avion=" + avion + ", voiture=" + voiture + "]";
	}
}
