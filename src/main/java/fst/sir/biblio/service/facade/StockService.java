/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.facade;

import fst.sir.biblio.bean.Stock;

/**
 *
 * @author HP
 */
public interface StockService {
    Stock findByBibliothequeRef(String ref);
    int save(Stock stock);
    int qteDisponible(Stock stock);
   
}
