package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageurDao;
import fr.adaming.model.Voyageur;

@Service
@Transactional
public class VoyageurServiceImpl implements IVoyageurService {

	//=================injection dependence=============================//
	@Autowired
	private IVoyageurDao voyageDao;
	
	//===========setter pour l'injection dependence==================//
	public void setVoyageDao(IVoyageurDao voyageDao) {
		this.voyageDao = voyageDao;
	}

	@Override
	public Voyageur addVoyageur(Voyageur v) {
		return voyageDao.addVoyageur(v);
	}

	
	@Override
	public List<Voyageur> getAllVoyageurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Voyageur updateVoyageur(Voyageur v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteVoyageur(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Voyageur getVoyageur(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
