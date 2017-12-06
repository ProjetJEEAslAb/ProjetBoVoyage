package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="voyages")
public class Voyage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int placesDisponibles;
	private double prix;
	@Temporal(TemporalType.DATE)
//	@DateTimeFormat(pattern="dd.MM.yyyy")
	private Date dateDepart;
	private int duree;
	private String pays;
	private String continent;
	@OneToOne(cascade={CascadeType.REMOVE})
	private Formule formule;
	@OneToMany(mappedBy="voyage")
	private Set<Dossier> dossiers;
	@Transient
	private String dateString;

	public Voyage() {
		super();
	}
	public Voyage(int placesDisponibles, double prix, Date dateDepart,
			int duree, String pays, String continent) {
		super();
		this.placesDisponibles = placesDisponibles;
		this.prix = prix;
		this.dateDepart = dateDepart;
		this.duree = duree;
		this.pays = pays;
		this.continent = continent;
	}
	public Voyage(int id, int placesDisponibles, double prix, Date dateDepart,
			int duree, String pays, String continent) {
		super();
		this.id = id;
		this.placesDisponibles = placesDisponibles;
		this.prix = prix;
		this.dateDepart = dateDepart;
		this.duree = duree;
		this.pays = pays;
		this.continent = continent;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlacesDisponibles() {
		return placesDisponibles;
	}
	public void setPlacesDisponibles(int placesDisponibles) {
		this.placesDisponibles = placesDisponibles;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public Formule getFormule() {
		return formule;
	}
	public void setFormule(Formule formule) {
		this.formule = formule;
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
	@Override
	public String toString() {
		return "Voyage [id=" + id + ", placesDisponibles=" + placesDisponibles
				+ ", prix=" + prix + ", dateDepart=" + dateDepart + ", duree="
				+ duree + ", pays=" + pays + ", continent=" + continent + "]";
	}
}
