package fst.sir.biblio.ws.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.Admin;
import fst.sir.biblio.bean.Categorie;
import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.bean.Reservation;
import fst.sir.biblio.bean.Theme;
import fst.sir.biblio.service.facade.AdminService;


@RestController
@RequestMapping("/biblio/admin")
public class AdminRest {
	@Autowired
	AdminService adminService;
    @GetMapping("/dateContra/{dateContra}")
	public Admin findBydateContr( Date dateContra) {
		return adminService.findBydateContra(dateContra);
	}
    @PostMapping("/")
	public int ajouterAdmin(Admin admin) {
		return adminService.ajouterAdmin(admin);
	}
    @PostMapping("/email/{email}/password/{password}")
	public int loginAdmin(String email, String password) {
		return adminService.loginAdmin(email, password);
	}
    @PostMapping("/adherent/")
	public int ajouterAdherent(Adherent adherent) {
		return adminService.ajouterAdherent(adherent);
	}
   @PutMapping()
	public int removeAdherent(Adherent adherent) {
		return adminService.removeAdherent(adherent);
	}

	public int ajouterLivre(List<Livre> livre) {
		return adminService.ajouterLivre(livre);
	}

	public int removeLivre(List<Livre> livre) {
		return adminService.removeLivre(livre);
	}

	public Admin findByEmail(String email) {
		return adminService.findByEmail(email);
	}

	public int updateLivre(Livre livre) {
		return adminService.updateLivre(livre);
	}

	public int updateAdherent(Adherent adherent) {
		return adminService.updateAdherent(adherent);
	}

	public int updateFournesseur(Fournisseur fournisseur) {
		return adminService.updateFournesseur(fournisseur);
	}

	public int updateEmprunt(Emprunt emprunt) {
		return adminService.updateEmprunt(emprunt);
	}

	public int updateReservation(Reservation reservation) {
		return adminService.updateReservation(reservation);
	}

	public int updateAchat(Achat achat) {
		return adminService.updateAchat(achat);
	}

	public int updateCategorie(Categorie categorie) {
		return adminService.updateCategorie(categorie);
	}

	public int updateTheme(Theme theme) {
		return adminService.updateTheme(theme);
	}

	public int removeCategorie(Categorie categorie) {
		return adminService.removeCategorie(categorie);
	}

	public int ajouterCategorie(Categorie categorie) {
		return adminService.ajouterCategorie(categorie);
	}

	public int removeAchat(Achat achat) {
		return adminService.removeAchat(achat);
	}

	public int ajouterAchat(Achat achat) {
		return adminService.ajouterAchat(achat);
	}

	public int ajouterFournisseur(Fournisseur fournisseur) {
		return adminService.ajouterFournisseur(fournisseur);
	}

	public int removeFournisseur(Fournisseur fournisseur) {
		return adminService.removeFournisseur(fournisseur);
	}

	public int removeTheme(Theme theme) {
		return adminService.removeTheme(theme);
	}

	public int ajouterTheme(Theme theme) {
		return adminService.ajouterTheme(theme);
	}
	
	
	
	

}
