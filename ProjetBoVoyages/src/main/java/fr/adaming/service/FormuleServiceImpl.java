package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IDaoFormule;
import fr.adaming.model.Formule;
@Service
@Transactional
public class FormuleServiceImpl implements IFormuleService{

	@Autowired
	private IDaoFormule daoFormule;
	
	@Override
	public Formule ajouterFormule(Formule formule) {
		return daoFormule.ajouterFormule(formule);
	}

	@Override
	public Formule modifierFormule(Formule formule) {
		return daoFormule.modifierFormule(formule);
	}

}
