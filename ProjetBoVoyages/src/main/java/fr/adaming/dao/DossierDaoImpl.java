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
		
		// Requête JPQL
		String req="SELECT d FROM Dossier d";
		
		// Création du Query
		Query query=em.createQuery(req);
		
		// Envoi de la requête
		@SuppressWarnings("unchecked")
		List<Dossier> listeOut=query.getResultList();
		
		return listeOut;

	}

	@Override
	public Dossier getDossierById(int id) {
		
		// Requête JPQL
		String req="SELECT d FROM Dossier d WHERE d.id=:pId";
		
		// Création du query
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
