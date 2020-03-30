/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.dao.AchatDetailDao;
import fst.sir.biblio.service.facade.AchatDetailService;
import fst.sir.biblio.service.facade.LivreService;
import fst.sir.biblio.service.facade.StockService;

@Service
public class AchatDetailServiceImpl implements AchatDetailService {

    @Autowired
    private AchatDetailDao achatDetailDao;

    @Autowired
    private LivreService livreService;
    @Autowired
    private StockService stockService;

    @Override
    public boolean validateAchatDetail(Achat achat, List<AchatDetail> achatDetails) {
        List<AchatDetail> valideLivres = achatDetails.stream().filter(ad -> livreService.findByIsbn(ad.getLivre().getIsbn()) != null).collect(Collectors.toList());
        return valideLivres.size() == achatDetails.size();
    }

    @Override
    public int save(Achat achat, List<AchatDetail> achatDetails) {
        if (validateAchatDetail(achat, achatDetails)) {
            achatDetails.forEach(a -> {
                Stock stock = stockService.findByBibliothequeRefAndLivreIsbn(achat.getBibliotheque().getRef(), a.getLivre().getIsbn());
                Livre livre = livreService.findByIsbn(a.getLivre().getIsbn());

                a.setAchat(achat);
                a.setLivre(livre);
                if (stock == null) {
                    Stock myStock = new Stock((int) a.getQte(), (int) a.getQte(), achat.getBibliotheque(), livre);
                    stockService.save(myStock);
                } else {
                    stock.setQteAchete((int) (a.getQte() + stock.getQteAchete()));
                    stock.setQteDisponible(stock.getQteAchete() - stock.getQteLoue());
                    stockService.save(stock);
                }
                achatDetailDao.save(a);

            });
            return 1;
        } else {
            return 1;
        }
    }

    @Transactional
    @Override
    public int deleteByAchatRef(String ref) {
        List<AchatDetail> achatDetailFounded = findByAchatRef(ref);
        for (AchatDetail achatDetail : achatDetailFounded) {

            achatDetailDao.delete(achatDetail);
        }
        return 1;

    }

    @Override
    public List<AchatDetail> findByAchatRef(String ref) {

        return achatDetailDao.findByAchatRef(ref);
    }

}
