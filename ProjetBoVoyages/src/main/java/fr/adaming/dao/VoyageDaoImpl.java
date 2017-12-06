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

	@Override
	public List<Voyage> rechercherVoyageAvecCritere(Voyage critereVoyage,List<String> listeParametre) {
		StringBuilder requete = new StringBuilder("SELECT v FROM Voyage v WHERE ");
		//Nombre de critere;
		int nbCritere = listeParametre.size();
		for(int i =0;i<=nbCritere-1;i++){
			System.out.println(listeParametre.get(i));
			if(i==0){
				//System.out.println("Premier paramètre");
				requete.append(listeParametre.get(i));
			}else{
				//System.out.println("Paramètre ulterieur");
				requete.append(" AND ");
				requete.append(listeParametre.get(i));
			}
		}

		Query query = em.createQuery(requete.toString());
		StringBuilder pays = new StringBuilder();
		pays.append("%");
		pays.append(critereVoyage.getPays());
		pays.append("%");
		
		//query.setParameter("pPays", pays.toString());;
		//query.setParameter("pDate", critereVoyage.getDateDepart());
//		query.setParameter("pPrix", critereVoyage.getPrix());
//
		//System.out.println(query);
		return query.getResultList();
	}
	
	
}
