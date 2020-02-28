package fst.sir.biblio.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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

	@Override
	public int modifyByCin(String cin) {
		Adherent adherent = findByCin(cin);
		if(adherent==null) {
			return -1;
		}else{
			adherentDao.save(adherent);
			return 1;
		}
	}

	@Override
	public int removeByCin(String cin) {
		Adherent adherent = findByCin(cin);
		if(adherent==null) {
			return -1;
		}else {
			adherentDao.delete(adherent);
			return 1;
		}
	}

	@GetMapping("aderent/profession/{profession}")
	public List<Adherent> findByprofession(String profession) {
		
		return adherentDao.findByprofession(profession);
	}

	
	}
