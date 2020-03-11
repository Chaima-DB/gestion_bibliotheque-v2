package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.dao.AchatDao;
import fst.sir.biblio.service.facade.AchatService;
@Service
public class AchatServiceImpl  implements AchatService{
@Autowired
private AchatDao achatDao;
	@Override
	public Achat findByRef(String ref) {
		
		return achatDao.findByRef(ref);
	}

	@Override
	public List<Achat> findAll() {
		
		return achatDao.findAll();
	}

	@Override
	public int save(Achat achat) {
		
		Achat fonded=findByRef(achat.getRef());
		if (fonded!=null) {return -1;}
		else { 
			achatDao.save(fonded); 
			return 1;
		}
		
	}

	@Override
	public int removeAchat(String ref) {
		Achat remove=findByRef(ref);
		if (remove!=null) {return -1;}
		else { 
			achatDao.delete(remove);
			return 1;
		}
		
	
	
	}


}
