/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.dao;

import fst.sir.biblio.bean.Emprunt;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Long>{
    Emprunt findByRef(String ref);
    

    int deleteByRef(String reference);
    //@Query("SELECT e FROM Emprunt e WHERE e.ref LIKE :reference")
//    List<Emprunt> findByRefLike(String ref);
}
