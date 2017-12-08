package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;

@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService {
	@Autowired
	private IAgenceDao agenceDao;

	public void setAgenceDao(IAgenceDao agenceDao) {
		this.agenceDao = agenceDao;
	}
	
	
	@Override
	public List<Agence> getAllAgences() {
		return this.agenceDao.getAllAgences();
	}

	@Override
	public Agence addAgence(Agence agence) {
		return this.agenceDao.addAgence(agence);
	}
}
