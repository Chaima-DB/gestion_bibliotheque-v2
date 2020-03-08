package fst.sir.biblio.service.facade;

import java.util.Date;
import java.util.List;

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

public interface AdminService {
	Admin findBydateContra(Date dateContra);

	int ajouterAdmin(Admin admin);

	int loginAdmin(String email, String password);

	int ajouterAdherent(Adherent adherent);

	int removeAdherent(Adherent adherent);

	int ajouterLivre(List<Livre> livre);

	int removeLivre(List<Livre> livre);

	Admin findByEmail(String email);

	int updateLivre(Livre livre);

	int updateAdherent(Adherent adherent);

	int updateFournesseur(Fournisseur fournisseur);

	int updateEmprunt(Emprunt emprunt);

	int updateReservation(Reservation reservation);

	int updateAchat(Achat achat);

	int updateCategorie(Categorie categorie);

	int updateTheme(Theme theme);

	int removeCategorie(Categorie categorie);

	int ajouterCategorie(Categorie categorie);

	int removeAchat(Achat achat);

	int ajouterAchat(Achat achat);

	int ajouterFournisseur(Fournisseur fournisseur);

	int removeFournisseur(Fournisseur fournisseur);

	int removeTheme(Theme theme);

	int ajouterTheme(Theme theme);

	int ajouterAchatDetail(AchatDetail achatDetail);

	int removeAchatDetail(AchatDetail achatDetail);

	int updateAchatDetail(AchatDetail achatDetail);

	int updateBibliotheque(Bibliotheque bibliotheque);

	int ajouterTypeAdharent(TypeAdherent taypeAdherent);

	int removeTypeAdherent(TypeAdherent taypeAdherent);

	int updateTypeAdherent(TypeAdherent taypeAdherent);

	int updateEmpruntDetail(EmpruntDetail empruntDetail);

	int removeEmpruntDetail(EmpruntDetail empruntDetail);

	int ajouterEmpruntDetail(EmpruntDetail empruntDetail);

	int removeAdmin(Admin admin);

	int countNomberAdherents();
	int countNomberEmprunts();

}
