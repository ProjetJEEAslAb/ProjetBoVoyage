package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Dossier;

@Repository
public class DossierDaoImpl implements IDossierDao{
	
	@PersistenceContext
	EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public Dossier addDossier(Dossier dossier) {
		
		em.persist(dossier);
		
		return dossier;
	}

	@Override
	public List<Dossier> getAllDossiers() {
		
		// Requ�te JPQL
		String req="SELECT d FROM Dossier d";
		
		// Cr�ation du Query
		Query query=em.createQuery(req);
		
		// Envoi de la requ�te
		@SuppressWarnings("unchecked")
		List<Dossier> listeOut=query.getResultList();
		
		return listeOut;

	}

	@Override
	public Dossier getDossierById(int id) {
		
		// Requ�te JPQL
		String req="SELECT d FROM Dossier d WHERE d.id=:pId";
		
		// Cr�ation du query
		Query query=em.createQuery(req);
		
		// Passage des params
		query.setParameter("pId", id);
		
		return (Dossier) query.getSingleResult();
	}

	@Override
	public Dossier updateDossier(Dossier dossier) {
		
		em.merge(dossier);
		
		return dossier;
	}

	@Override
	public void deleteDossier(Dossier dossier) {
		em.remove(dossier);
		
	}

}
