/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Emprunt;
import java.util.List;

/**
 *
 * @author HP
 */
public interface EmpruntService {
    Emprunt findByRef(String ref);
    List<Emprunt> findAll();
    String save(Emprunt emprunt);
    String delete(Emprunt emprunt);
    String update(Emprunt emprunt);
    
}
