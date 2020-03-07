package fst.sir.biblio.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.bean.Bibliotheque;
import fst.sir.biblio.bean.Categorie;
import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.bean.Reservation;
import fst.sir.biblio.bean.Theme;
import fst.sir.biblio.bean.TypeAdherent;
import fst.sir.biblio.dao.AdminDao;
import fst.sir.biblio.service.facade.AchatDetailService;
import fst.sir.biblio.service.facade.AchatService;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.AdminService;
import fst.sir.biblio.service.facade.EmpruntDetailService;
import fst.sir.biblio.service.facade.EmpruntService;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin findBydateContra(Date dateContra) {
	
		return adminDao.findByDateContrat(dateContra);
	}
@Autowired
private AdherentService adherentService;
@Autowired
private TypeAdherent taypeAdherent;
@Autowired
private AchatDetailService achatDetailService;
@Autowired
private AchatService achatService;
/*@Autowired
private ReservationService reservationService;
@Autowired
private ThemeService themeService;
@Autowired 
private LivreService livreService;
*/
@Autowired
private EmpruntService empruntService;
@Autowired
private EmpruntDetailService empruntDetailService;


	@Override
	public int ajouterAdherent(Adherent adherent) {
	Adherent adherentFounded=adherentService.findByCin(adherent.getCin());
	if(adherentFounded!=null) {return -1;
		
	}else {
		adherentService.save(adherent);
		return 1;
	}}

	@Override
	public int removeAdherent(Adherent adherent) {
		

		Adherent adherentFounded=adherentService.findByCin(adherent.getCin());
		if(adherentFounded==null) {return -1;
			
	}else {adherentService.removeByCin(adherent.getCin());
	return 1;
		
	}}

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
	
		return adminDao.findByEmail(email);
	}

	@Override
	public int updateLivre(Livre livre) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int updateFournesseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmprunt(Emprunt emprunt) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAchat(Achat achat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTheme(Theme theme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAchat(Achat achat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterAchat(Achat achat) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFournisseur(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeTheme(Theme theme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterTheme(Theme theme) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterAdmin(Admin admin) {
	Admin adminFounded=findByEmail(admin.getEmail());
	if(adminFounded!=null) {return -1;}else { 
		adminDao.save(admin);
		return 1;
	}
		
	}

	@Override
	public int updateAdherent(Adherent adherent) {
		
		Adherent adherentFounded=adherentService.findByCin(adherent.getCin());
		if(adherentFounded==null) {return -1;
			
	}else {adherentService.save(adherent);
	return 1;
		
	}


	
}

	@Override
	public int loginAdmin(String email, String password) {
	
		Admin isAdmin= findByEmail(email);
		if(email!=isAdmin.getEmail() && password!=isAdmin.getEmail() ) {
		return -1;
	}else {
		return 1;
	}}

	@Override
	public int ajouterAchatDetail(AchatDetail achatDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAchatDetail(AchatDetail achatDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAchatDetail(AchatDetail achatDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterBibliotheque(Bibliotheque bibliotheque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBibliotheque(Bibliotheque bibliotheque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBibliotheque(Bibliotheque bibliotheque) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterTypeAdharent(TypeAdherent taypeAdherent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeTypeAdherent(TypeAdherent taypeAdherent) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTypeAdherent(TypeAdherent taypeAdherent) {

		return 0;
	}

	@Override
	public int updateEmpruntDetail(EmpruntDetail empruntDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeEmpruntDetail(EmpruntDetail empruntDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterEmpruntDetail(EmpruntDetail empruntDetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return 0;
	}}
