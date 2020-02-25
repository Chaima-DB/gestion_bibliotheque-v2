package fst.sir.biblio.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.dao.AdherentDao;
import fst.sir.biblio.service.facade.AdherentService;

@Service
public class AdherentServiceImpl implements AdherentService{
        @Autowired
        private AdherentDao adherentDao;
	    @Override
	public List<Adherent> findAll() {
	
		return adherentDao.findAll();
	}

	@Override
	public void save(Adherent adherent) {
		adherentDao.save(adherent);
		
	}

	@Override
	public Adherent findByCin(String cin) {
		
		return adherentDao.findByCin(cin);
	}

	@Override
	public List<Adherent> findByDateInscription(Date dateInscription) {
		
		return adherentDao.findByDateInscription(dateInscription);
	}

	@Override
	public Adherent findByEmail(String email) {
	
		return adherentDao.findByEmail(email);
	}

	
	}
