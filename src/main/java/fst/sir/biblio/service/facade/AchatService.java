package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Achat;

public interface AchatService {

	public Achat findByRef(String ref);
	public  List<Achat> findAll();
	public int save(Achat achat);
	public int removeAchat(String ref);
	
	
	
	
}
