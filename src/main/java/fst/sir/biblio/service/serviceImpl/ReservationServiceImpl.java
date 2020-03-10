package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fst.sir.biblio.bean.Reservation;
import fst.sir.biblio.dao.ReservationDao;
import fst.sir.biblio.service.facade.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	
	@Autowired
private	ReservationDao reservationDao;

	@Override
	public List<Reservation> afficherReservations(String codereservation) {
		
		return reservationDao.findAll();
	}

	@Override
	public int ajouterReservation(Reservation reservation) {
		Reservation reservationExiste =
				reservationDao.findByCodeReservation(reservation.getCodeReservation());
		if(reservationExiste==null) {return -1;}
		reservationDao.save(reservation);
		return 1;
		
		
	}

	@Override
	public boolean annulerReservation(String codereservation) {
		if(reservationDao.findByCodeReservation(codereservation)==null) {return false;}
		reservationDao.deleteByCodeReservation(codereservation);
		return true;
	}

	@Override
	public Reservation findByCodereservation(String codeReservation) {
		
		return reservationDao.findByCodeReservation(codeReservation);
	}

	@Override
	public double calcule() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	




	
	
	
	
	
	
	
}
