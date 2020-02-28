/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmpruntService {
    Emprunt findByRef(String ref);
    int deleteByRef(String ref);
    List<Emprunt> findAll();
    String save(Emprunt emprunt, List<EmpruntDetail> empruntDetails);
    int delete(Emprunt emprunt);
    int update(Emprunt emprunt);
    int restituer(String ref, Date dateRestitutionEffective);
    List<Emprunt> findByRefLike(String ref);
    
}
