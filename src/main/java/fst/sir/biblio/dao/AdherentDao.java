package fst.sir.biblio.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Adherent;

@Repository
public interface AdherentDao extends JpaRepository<Adherent, Long> {
	public Adherent findByCin(String cin);

	public List<Adherent> findByDateInscription(Date dateInscription);

	public Adherent findByEmail(String email);

	public List<Adherent> findByprofession(String profession);

}