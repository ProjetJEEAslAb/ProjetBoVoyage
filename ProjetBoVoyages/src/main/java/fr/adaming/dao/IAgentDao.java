package fr.adaming.dao;

import fr.adaming.model.Agent;

public interface IAgentDao {
	public Agent getAgent(String username, String password);
	public Agent addAgent(Agent agent);
}
