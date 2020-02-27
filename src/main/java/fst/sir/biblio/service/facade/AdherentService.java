package fst.sir.biblio.service.facade;

import java.util.Date;
import java.util.List;

import fst.sir.biblio.bean.Adherent;

public interface AdherentService {
	public List<Adherent> findAll();

	void save(Adherent adherent);

	public Adherent findByCin(String cin);

	public List<Adherent> findByDateInscription(Date dateInscription);

	public Adherent findByEmail(String email);

	public int modifyByCin(String cin);

	public int removeByCin(String cin);

	public List<Adherent> findByprofession(String profession);
}
