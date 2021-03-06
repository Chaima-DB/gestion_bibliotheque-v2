/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.dao;

import fst.sir.biblio.bean.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface StockDao extends JpaRepository<Stock, Long>{
    Stock findByBibliothequeRef(String ref);
    Stock findByBibliothequeNom(String nom);

    public Stock findByBibliothequeRefAndLivreIsbn(String ref, String isbn);
    public Stock findByLivreIsbn(String isbn);
}
