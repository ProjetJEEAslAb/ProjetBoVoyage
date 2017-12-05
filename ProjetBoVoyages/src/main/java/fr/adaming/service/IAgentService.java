package fr.adaming.service;

import fr.adaming.model.Agent;

public interface IAgentService {
	public Agent getAgent(String username, String password);
	public Agent addAgent(Agent agent);
}
