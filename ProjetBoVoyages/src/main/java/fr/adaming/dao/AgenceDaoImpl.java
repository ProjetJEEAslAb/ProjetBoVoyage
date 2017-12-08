package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Agence;

@Repository
public class AgenceDaoImpl implements IAgenceDao {
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	
	@Override
	public List<Agence> getAllAgences() {
		String request = "SELECT a FROM Agence a";
		Query query = em.createQuery(request);
		@SuppressWarnings("unchecked")
		List<Agence> agences = query.getResultList();
		return agences;
	}

	@Override
	public Agence addAgence(Agence agence) {
		em.persist(agence);
		return agence;
	}
}
