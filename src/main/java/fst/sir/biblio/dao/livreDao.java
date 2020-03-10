package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fst.sir.biblio.bean.Livre;

public interface livreDao extends JpaRepository<Livre,Long > {
	public List<Livre> findByTitre(String t);
	
	@Query("select e from Livre e where e.nom like :x")	
	public List<Livre> chercherLivres(@Param("x")String mc);
	public List<Livre> findByAuteur (String auteur);
	@Query("select disponible from Livre")
	public int disponible(String titre);
	public Livre findByIsbn(String isbn);
	
	
	
	
	

}
