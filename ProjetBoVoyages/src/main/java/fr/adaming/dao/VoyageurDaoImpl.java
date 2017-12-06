package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyageur;

@Repository
public class VoyageurDaoImpl implements IVoyageurDao {

	@PersistenceContext
	private EntityManager em;

	// Setter pour l'injection dependence
	public void setEm(EntityManager em) {
		this.em = em;
	}

	// ==================methode ajouter=======================//
	@Override
	public Voyageur addVoyageur(Voyageur v) {
		em.persist(v);
		return v;
	}

	// ==================methode liste de voyageur=======================//

	@Override
	public List<Voyageur> getAllVoyageurs() {

		// La requete HQL
		String req = "FROM Voyageur v";
		Query query = em.createQuery(req);
		List<Voyageur> liste = query.getResultList();
		return liste;
	}

	// ==================methode modifier un voyageur=======================//

	@Override
	public Voyageur updateVoyageur(Voyageur v) {
		em.merge(v);
		return v;
	}

	// ==================methode supprimer un voyageur=======================//

	@Override
	public void deleteVoyageur(Voyageur v) {
		Voyageur vOut=em.find(Voyageur.class, v.getId());
		em.remove(vOut);
				
	}

	// ==================methode rechercher un voyageur=======================//
	@Override
	public Voyageur getVoyageurById(Voyageur v) {
		return em.find(Voyageur.class, v.getId());	
	}

}
