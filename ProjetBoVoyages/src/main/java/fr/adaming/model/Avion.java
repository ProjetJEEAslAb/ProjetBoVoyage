package fr.adaming.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Avion {
	private String compagnie;
	@Temporal(TemporalType.TIME)
	private Date horaireArrivee;
	@Temporal(TemporalType.TIME)
	private Date horaireDepart;
	public Avion() {
		super();
	}
	public Avion(String compagnie, Date horaireArrivee, Date horaireDepart) {
		super();
		this.compagnie = compagnie;
		this.horaireArrivee = horaireArrivee;
		this.horaireDepart = horaireDepart;
	}
	public String getCompagnie() {
		return compagnie;
	}
	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}
	public Date getHoraireArrivee() {
		return horaireArrivee;
	}
	public void setHoraireArrivee(Date horaireArrivee) {
		this.horaireArrivee = horaireArrivee;
	}
	public Date getHoraireDepart() {
		return horaireDepart;
	}
	public void setHoraireDepart(Date horaireDepart) {
		this.horaireDepart = horaireDepart;
	}
	
}
