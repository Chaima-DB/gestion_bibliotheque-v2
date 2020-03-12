package fst.sir.biblio.utils;

import java.util.Date;

public class Utils {
	private Date date;
	
	public Date getDate() {
		return this.date;
	}
	
	public int checkDate(Date dateToCheck) {
		if(dateToCheck.compareTo(this.date)>0) {
			return -1;
		}else if(dateToCheck.compareTo(this.date)<0) {
			return 1;
		}else{
			return 0;
		}
	}
	
}
