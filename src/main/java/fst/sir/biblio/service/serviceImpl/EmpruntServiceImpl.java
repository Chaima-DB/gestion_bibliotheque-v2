/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import fst.sir.biblio.dao.EmpruntDao;
import fst.sir.biblio.service.facade.AdherentService;
import fst.sir.biblio.service.facade.EmpruntDetailService;
import fst.sir.biblio.service.facade.EmpruntService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author HP
 */
public class EmpruntServiceImpl implements EmpruntService {

    @Autowired
    private EmpruntDao empruntDao;
    @Autowired
    private AdherentService adherentService;

    @Autowired
    private EmpruntDetailService empruntDetailService;

    @Override
    public Emprunt findByRef(String ref) {
        return empruntDao.findByRef(ref);

    }

    /**
     *
     * @param ref
     * @return
     */
    @Transactional
    @Override
    public int deleteByRef(String ref) {
        int resDetail = empruntDetailService.deleteByEmpruntRef(ref);
        int resEmprunt = empruntDao.deleteByRef(ref);
        return resDetail * resEmprunt;
    }

    @Override
    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    @Override
    public String save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Emprunt emprunt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Emprunt emprunt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int restituer(String ref, Date dateRestitutionEffective) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprunt> findByRefLike(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
