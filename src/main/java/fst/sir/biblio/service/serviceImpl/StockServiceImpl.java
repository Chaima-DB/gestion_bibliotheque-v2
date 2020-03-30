/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Bibliotheque;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.dao.StockDao;
import fst.sir.biblio.service.facade.BibliothequeService;
import fst.sir.biblio.service.facade.LivreService;
import fst.sir.biblio.service.facade.StockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockDao stockDao;
    @Autowired
    LivreService livreService;
    @Autowired
    BibliothequeService bibliothequeService;

    @Override
    public Stock findByBibliothequeRef(String ref) {
        return stockDao.findByBibliothequeRef(ref);
    }

        @Override
    public int save(Stock stock) {
        stockDao.save(stock);
        return 1;
    }
    @Override
    public int saveOrEdit(Stock stock) {
        Livre livreFounded = livreService.findByIsbn(stock.getLivre().getIsbn()); 
        Bibliotheque biblioFounded = bibliothequeService.findByRef(stock.getBibliotheque().getRef());
        Stock loadedStock = stockDao.findByBibliothequeRefAndLivreIsbn(stock.getBibliotheque().getRef(), stock.getLivre().getIsbn());
        if (biblioFounded == null) {
            return -1;
        } else if (livreFounded == null) {
            return -2;
        } else {
            if (loadedStock == null) {
                stock.setBibliotheque(biblioFounded);
                stock.setQteDisponible(stock.getQteAchete());
                stock.setQteLoue(0);
                stock.setLivre(livreFounded);
                stockDao.save(stock);
                return 1;
            }else{
                loadedStock.setQteAchete(loadedStock.getQteAchete()+stock.getQteAchete());
                loadedStock.setQteDisponible(loadedStock.getQteDisponible()+stock.getQteAchete());
                loadedStock.setQteLoue(loadedStock.getQteLoue()+stock.getQteLoue());
                stockDao.save(loadedStock);
                return 2;
            }
            
        }
    }
    

    @Override
    public int qteDisponible(Stock stock) {
        Stock founded = stockDao.findByBibliothequeRef(stock.getBibliotheque().getRef());
        if (founded != null) {
            int dispo = founded.getQteAchete() - stock.getQteLoue();
            founded.setQteDisponible(dispo);
            return dispo;
        } else {
            return -1;
        }

    }

    @Override
    public Stock findByBibliothequeNom(String nom) {
        return stockDao.findByBibliothequeNom(nom);
    }

    @Override
    public List<Stock> findAll() {
        return stockDao.findAll();
    }

    @Override
    public Stock findByBibliothequeRefAndLivreIsbn(String ref, String isbn) {
        return stockDao.findByBibliothequeRefAndLivreIsbn(ref, isbn);
    }

    @Override
    public Stock findByLivreIsbn(String isbn) {
        return stockDao.findByLivreIsbn(isbn);
    }

}
