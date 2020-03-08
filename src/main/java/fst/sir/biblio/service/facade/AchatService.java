package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Achat;

public interface AchatService {

	Achat findByRef(String ref);

	List<Achat> findAll();

	int save(Achat achat);

	int removeAchat(String ref);

}
