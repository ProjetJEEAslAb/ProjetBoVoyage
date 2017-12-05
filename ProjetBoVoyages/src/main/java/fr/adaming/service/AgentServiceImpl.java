package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Service
@Transactional
public class AgentServiceImpl implements IAgentService {
	@Autowired
	private IAgentDao agentDao;

	public void setAgentDao(IAgentDao agentDao) {
		this.agentDao = agentDao;
	}
	
	
	@Override
	public Agent getAgent(String username, String password) {
		return this.agentDao.getAgent(username, password);
	}
	@Override
	public Agent addAgent(Agent agent) {
		return this.agentDao.addAgent(agent);
	}
}
