package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Voyageur implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voyageur")
	private int id;
	private String nom;
	private String prenom;
	private String civilite;
	private String adresse;
	private String telephone;
	private Date dateNaissance;
	public String mail;
	
	@Transient
	private String dateString;
	private boolean client;
	@ManyToMany
	private Set<Dossier> dossiers;

	public Voyageur() {
		super();
	}
	public Voyageur(String nom, String prenom, String civilite, String adresse,
			String telephone, Date dateNaissance, boolean client) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.client = client;
	}
	public Voyageur(int id, String nom, String prenom, String civilite, String adresse, String telephone,
			Date dateNaissance, boolean client) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
		this.adresse = adresse;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.client = client;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public boolean isClient() {
		return client;
	}
	public void setClient(boolean client) {
		this.client = client;
	}
	public Set<Dossier> getDossiers() {
		return dossiers;
	}
	public void setDossiers(Set<Dossier> dossiers) {
		this.dossiers = dossiers;
	}
	
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "Voyageur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", civilite=" + civilite + ", adresse="
				+ adresse + ", telephone=" + telephone + ", dateNaissance=" + dateNaissance + ", client=" + client
				+ "]";
	}
}
