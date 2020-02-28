package fst.sir.biblio.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reservation implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateReservation;
	@ManyToOne
	private Livre livre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDemandeReservation() {
		return dateDemandeReservation;
	}

	public void setDateDemandeReservation(Date dateDemandeReservation) {
		this.dateDemandeReservation = dateDemandeReservation;
	}

	public Date getAnnulerReservation() {
		return annulerReservation;
	}

	public void setAnnulerReservation(Date annulerReservation) {
		this.annulerReservation = annulerReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

}
