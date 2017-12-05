package fr.adaming.model;

import java.util.Set;

public class Dossier {
	private int id;
	private String statut;
	private String assurance;
	private String codeCB;
	
	private Voyage voyage;
	
	private Set<Voyageur> voyageurs;

	public Dossier() {
		super();
	}

	public Dossier(String statut, String assurance, String codeCB) {
		super();
		this.statut = statut;
		this.assurance = assurance;
		this.codeCB = codeCB;
	}

	public Dossier(int id, String statut, String assurance, String codeCB) {
		super();
		this.id = id;
		this.statut = statut;
		this.assurance = assurance;
		this.codeCB = codeCB;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAssurance() {
		return assurance;
	}

	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}

	public String getCodeCB() {
		return codeCB;
	}

	public void setCodeCB(String codeCB) {
		this.codeCB = codeCB;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public Set<Voyageur> getVoyageurs() {
		return voyageurs;
	}

	public void setVoyageurs(Set<Voyageur> voyageurs) {
		this.voyageurs = voyageurs;
	}
	
}
