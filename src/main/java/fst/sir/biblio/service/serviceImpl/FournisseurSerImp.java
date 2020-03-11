package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.dao.FournisseurDao;
import fst.sir.biblio.service.facade.FournisseurService;
@Service
public class FournisseurSerImp implements FournisseurService {
	
	
	@Autowired
	FournisseurDao fournisseurDao;
	

	@Override
	public Fournisseur findByCin(String cin) {
		
		return fournisseurDao.findByCin(cin);
	}

	@Override
	public int save(Fournisseur forniseur) {
		
		if(findByCin(forniseur.getCin())!=null) {
			return -1;
			
		}
		
		
		fournisseurDao.save(forniseur);
		return 1;
	}

	@Override
	public List<Fournisseur> afficher() {
		
		return fournisseurDao.findAll();
	}

	@Override
	public void deleteByCin(String cin) {
		
		fournisseurDao.deleteByCin(cin);
	}
	

}
