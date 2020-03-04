package fst.sir.biblio.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.dao.AdminDao;
import fst.sir.biblio.service.facade.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;


	@Override
	public Admin findBydateContra(Date dateContra) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajouterAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int ajouterAdherent(Adherent adherent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAdherent(Adherent adherent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterLivre(List<Livre> livre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeLivre(List<Livre> livre) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
