package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDaoImpl implements IVoyageDao{
	@PersistenceContext
	EntityManager em;

	@Override
	public Voyage ajoutVoyage(Voyage v) {
		em.persist(v);
		return v;
	}

	@Override
	public List<Voyage> getAllVoyages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voyage getVoyageById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voyage updateVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVoyage() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
