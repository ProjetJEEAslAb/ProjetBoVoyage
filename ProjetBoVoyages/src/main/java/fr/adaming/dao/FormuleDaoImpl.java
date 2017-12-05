package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Formule;
@Repository
public class FormuleDaoImpl implements IDaoFormule{

	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Formule ajouterFormule(Formule formule) {
		em.persist(formule);
		return null;
	}

	@Override
	public Formule modifierFormule(Formule formule) {
		em.merge(formule);
		return formule;
	}

}
