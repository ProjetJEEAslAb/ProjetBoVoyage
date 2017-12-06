package fr.adaming.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Dossier implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dossier")
	private int id;
	private String statut;
	private String assurance;
	private String codeCB;
	
	@ManyToOne
	private Voyage voyage;
	@ManyToMany
	@JoinTable(name="jointureDossierVoyageurs",joinColumns=@JoinColumn(name="id_dossier",referencedColumnName="id_dossier"),inverseJoinColumns=@JoinColumn(name="id_voyageur",referencedColumnName="id_voyageur"))
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

	@Override
	public String toString() {
		return "Dossier [id=" + id + ", statut=" + statut + ", assurance=" + assurance + ", codeCB=" + codeCB + "]";
	}
}
