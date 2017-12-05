package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@Repository
public class AgentDaoImpl implements IAgentDao {
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	

	@Override
	public Agent getAgent(String username, String password) {
		String request = "SELECT a FROM Agent a WHERE a.username=:pUsername AND a.password=:pPassword";
		Query query = em.createQuery(request);
		query.setParameter("pUsername", username);
		query.setParameter("pPassword", password);
		return (Agent) query.getSingleResult();
	}
	
	@Override
	public Agent addAgent(Agent agent) {
		em.persist(agent);
		return agent;
	}
}
