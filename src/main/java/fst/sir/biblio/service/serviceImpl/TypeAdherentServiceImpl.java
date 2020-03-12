package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.TypeAdherent;
import fst.sir.biblio.dao.TypeAdherentDao;
import fst.sir.biblio.service.facade.TypeAdherentService;

@Service
public class TypeAdherentServiceImpl implements TypeAdherentService {

    @Autowired
    private TypeAdherentDao typeadherentdao;

    @Override
    public List<Adherent> findByprofession(String profession) {

        return typeadherentdao.findByprofession(profession);
    }

    @Override
    public int save(TypeAdherent typeAdherent) {
        List<Adherent> typeFounded = findByprofession(typeAdherent.getProfession());
        if (typeFounded != null) {
            return -1;
        } else {
            typeadherentdao.save(typeAdherent);
            return 1;
        }

    }

    @Override
    public int deleteByProfession(String profession) {
        List<Adherent> typeAdherentFounded = findByprofession(profession);
        if (typeAdherentFounded == null) {
            return -1;
        } else {
            typeadherentdao.deleteByProfession(profession);
            return 1;
        }
    }
}
