package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.dao.livreDao;
import fst.sir.biblio.service.facade.livreService;

public class livreServicesImpl implements livreService {

	@Autowired
private livreDao LivreDao;	
	

	
	@Override
	public int ajouterLivre(Livre livre) {
		Livre livreExit = (Livre) LivreDao.findByTitre(livre.getTitre());
		if(livreExit !=null) {return -1;}
		else {
			LivreDao.save(livre);
			return 1;
		}
		
	}
	

	
	
	

	@Override
	public void supLivreById(Long id) {
		
		
	}

	@Override
	public List<Livre> afficherLivre() {
		
		return LivreDao.findAll();
	}

	@Override
	public List<Livre> chercherLivres(String mc) {
		
		return LivreDao.chercherLivres(mc);
	}

	@Override
	public List<Livre> findByTitre(String t) {
		
		return LivreDao.findByTitre(t);
	}

	
	

	@Override
	public List<Livre> findByAuteur(String auteur) {
		
		return LivreDao.findByAuteur(auteur);
	}

	@Override
	public int disponible(String titre) {
		
		
		if(LivreDao.disponible(titre)>0) {
			return 1;
	}
		return 0;

	
	
	}













	@Override
	public Livre findByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}
}


