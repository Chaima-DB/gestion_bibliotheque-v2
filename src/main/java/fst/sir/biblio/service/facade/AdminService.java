package fst.sir.biblio.service.facade;

import java.util.Date;
import java.util.List;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.bean.Livre;

public interface AdminService {
	public  Admin findBydateContra(Date dateContra );
	public void ajouterAdmin(Admin admin);
	public int ajouterAdherent(Adherent adherent);
	public int removeAdherent(Adherent adherent);
	public int ajouterLivre(List<Livre> livre);
	public int removeLivre(List<Livre>  livre);
	
	
	

	

}
