package fst.sir.biblio.service;

import java.util.Date;
import java.util.List;

import fst.sir.biblio.bean.Adherent;

public interface AdherentService {
	 List<Adherent> findAll();
	 void save(Adherent adherent);
	 Adherent findByCin(String cin);
	 List<Adherent> findByDateInscription(Date dateInscription);
	 Adherent findByEmail(String email );
	 List<Adherent> findByprofession(String profession);


}
