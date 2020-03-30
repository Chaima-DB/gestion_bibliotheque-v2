package fst.sir.biblio.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Bibliotheque;
import fst.sir.biblio.bean.Fournisseur;
import fst.sir.biblio.dao.AchatDao;
import fst.sir.biblio.service.facade.AchatDetailService;
import fst.sir.biblio.service.facade.AchatService;
import fst.sir.biblio.service.facade.BibliothequeService;
import fst.sir.biblio.service.facade.FournisseurService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AchatServiceImpl implements AchatService {

    @Autowired
    private AchatDao achatDao;
    @Autowired
    private FournisseurService fournisseurService;
    @Autowired
    private AchatDetailService achatDetailService;
    @Autowired
    BibliothequeService bibliothequeService;

    @Override
    public Achat findByRef(String ref) {
        return achatDao.findByRef(ref);
    }

    @Override
    public List<Achat> findAll() {
        return achatDao.findAll();
    }

    @Override
    public int save(Achat achat, List<AchatDetail> achatDetails) {

        Achat achatFounded = findByRef(achat.getRef());
        Fournisseur fournisseurFounded = fournisseurService.findByCin(achat.getFournisseur().getCin());
        Bibliotheque bibliotheque = bibliothequeService.findByRef(achat.getBibliotheque().getRef());
        if (achatFounded != null) {
            return -1;

        } else if (fournisseurFounded == null) {
            return -2;
        } else if (bibliotheque == null) {
            return -3;
        } else if (!achatDetailService.validateAchatDetail(achat, achatDetails)) {
            return -2;

        } else {
            achat.setFournisseur(fournisseurFounded);
            achat.setBibliotheque(bibliotheque);
            achatDao.save(achat);
            achatDetailService.save(achat, achatDetails);
            return 1;
        }
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        int detailRes = achatDetailService.deleteByAchatRef(ref);
        int achatRes = achatDao.deleteByRef(ref);
        return detailRes * achatRes;

    }

}
