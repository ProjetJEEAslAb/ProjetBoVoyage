package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDao;
import fr.adaming.model.Voyage;
@Service
@Transactional
public class VoyageServiceImpl implements IVoyageService{

	@Autowired
	IVoyageDao daoVoyage;
	
	@Override
	public Voyage ajoutVoyage(Voyage v) {
		// TODO Auto-generated method stub
		return daoVoyage.ajoutVoyage(v);
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
