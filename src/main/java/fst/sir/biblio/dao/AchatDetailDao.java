package fst.sir.biblio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;

@Repository
public interface AchatDetailDao extends JpaRepository<AchatDetail, Long>{
	 public Achat  findByAchatRef(String ref);
	 public int deleteByAchatRef(String ref);


}
