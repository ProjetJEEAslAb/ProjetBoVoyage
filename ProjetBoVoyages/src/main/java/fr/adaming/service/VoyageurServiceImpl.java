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
		return voyageDao.getAllVoyageurs();
	}

	@Override
	public Voyageur updateVoyageur(Voyageur v) {
		return voyageDao.updateVoyageur(v);
	}

	@Override
	public void deleteVoyageur(int id) {
		voyageDao.deleteVoyageur(id);

	}

	@Override
	public Voyageur getVoyageur(int id) {
		return voyageDao.getVoyageur(id);
		
	}

}
