package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao{
	@PersistenceContext
	EntityManager em;

	@Override
	public Voyage ajoutVoyage(Voyage v) {
		em.persist(v);
		System.out.println(v);
		return v;
	}

	@Override
	public List<Voyage> getAllVoyages() {
		//Requête HQL
		String req ="FROM Voyage v";
		Query query = em.createQuery(req);
		List<Voyage> listeVoyage = query.getResultList();
		return listeVoyage;
	}

	@Override
	public Voyage getVoyageById(int id) {
		// Requête HQL 
		String requete = "SELECT v FROM Voyage v WHERE v.id=:pId";
		Query query = em.createQuery(requete);
		query.setParameter("pId", id);
		Voyage voyage = (Voyage) query.getSingleResult();
		return voyage;
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
		em.merge(v);
		return v;
	}

	@Override
	public void deleteVoyage(int id) {
		Voyage voyageARetirer = em.find(Voyage.class,id);
		em.remove(voyageARetirer);
	}
	
	
	
}
