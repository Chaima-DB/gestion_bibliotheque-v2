package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.TypeAdherent;

public interface TypeAdherentService {
	List<Adherent> findByprofession(String profession);
	int save(TypeAdherent typeAdherent);
	int deleteByprofession(String profession);
	

}
