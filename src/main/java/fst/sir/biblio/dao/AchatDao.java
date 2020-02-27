package fst.sir.biblio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Achat;

@Repository
public interface AchatDao extends JpaRepository<Achat, Long>{
	public Achat findByRef(String ref);
	

}
