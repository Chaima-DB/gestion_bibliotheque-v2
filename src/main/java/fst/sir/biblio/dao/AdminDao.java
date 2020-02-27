package fst.sir.biblio.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fst.sir.biblio.bean.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin, Long>{
	public 	Admin findByCin(String cin);
	public  Admin findBydateContra(Date dateContra );
	public Admin findByEmail(String email);

	

}
