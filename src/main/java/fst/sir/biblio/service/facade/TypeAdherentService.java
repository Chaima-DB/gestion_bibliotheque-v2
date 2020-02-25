package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Adherent;

public interface TypeAdherentService {
	List<Adherent> findByprofession(String profession);
	

}
