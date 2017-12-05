package fr.adaming.model;

import java.util.Set;

public class Formule {
	private int id;
	private String hebergement;
	private Avion avion;
	private Voiture voiture;
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

	
	
}
