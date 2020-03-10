package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Livre;

public interface livreService {
	
	public int ajouterLivre(Livre livre);
	public void supLivreById(Long id);
	public List<Livre> afficherLivre();
	public List<Livre> chercherLivres(String mc);
	public List<Livre> findByTitre(String t);
	public List<Livre> findByAuteur (String auteur);
	public int disponible(String titre);
	public Livre findByIsbn(String isbn);
}
