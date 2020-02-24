package fst.sir.biblio.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.dao.TypeAdherentDao;
import fst.sir.biblio.service.TypeAdherentService;

@Service
public class TypeAdherentServiceImpl implements TypeAdherentService{
@Autowired
private TypeAdherentDao typeadherentdao;
	@Override
	public List<Adherent> findByprofession(String profession) {
		
		return typeadherentdao.findByprofession(profession);
	}

}
