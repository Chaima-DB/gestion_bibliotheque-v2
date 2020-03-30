/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.sir.biblio.service.serviceImpl;

import fst.sir.biblio.bean.Emprunt;
import fst.sir.biblio.bean.EmpruntDetail;
import fst.sir.biblio.bean.Livre;
import fst.sir.biblio.bean.Stock;
import fst.sir.biblio.dao.EmpruntDetailDao;
import fst.sir.biblio.service.facade.EmpruntDetailService;
import fst.sir.biblio.service.facade.LivreService;
import fst.sir.biblio.service.facade.StockService;
import fst.sir.biblio.service.util.DateUtil;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class EmpruntDetailServiceImpl implements EmpruntDetailService {

    @Autowired
    private EmpruntDetailDao empruntDetailDao;
    @Autowired
    private StockService stockService;

    @Autowired
    private LivreService livreService;

    @Override
    public boolean validateEmpruntDetail(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        List<EmpruntDetail> valideLivres = empruntDetails.stream().filter(ed -> livreService.findByIsbn(ed.getLivre().getIsbn()) != null ).collect(Collectors.toList());

        return valideLivres.size() == empruntDetails.size();
    }

    @Override
    public boolean validateStock(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        List<EmpruntDetail> valideLivres = empruntDetails.stream().filter(ed -> livreService.findByIsbn(ed.getLivre().getIsbn()) != null ).collect(Collectors.toList());
        List<EmpruntDetail> valideStockes = valideLivres.stream().filter(es -> stockService.findByBibliothequeRefAndLivreIsbn(emprunt.getBibliotheque().getRef(), es.getLivre().getIsbn()) != null).collect(Collectors.toList());
        return valideStockes.size() == empruntDetails.size();
//&& stockService.findByLivreIsbn(ed.getLivre().getIsbn()) != null
    }

    @Override
    public int save(Emprunt emprunt, List<EmpruntDetail> empruntDetails) {
        if (validateEmpruntDetail(emprunt, empruntDetails)) {
            empruntDetails.forEach(e -> {
                Stock stock = stockService.findByBibliothequeRefAndLivreIsbn(emprunt.getBibliotheque().getRef(), e.getLivre().getIsbn());
                e.setEmprunt(emprunt);
                Livre livre = livreService.findByIsbn(e.getLivre().getIsbn());
                e.setLivre(livre);

                if (stock != null) {
                    e.setDateRetourPrevu(DateUtil.addDays(emprunt.getDateEmprunt(), livre.getNbrJourEmprunt()));
                    stock.setQteLoue(stock.getQteLoue() + 1);
                    stock.setQteDisponible(stock.getQteDisponible() - 1);
                    stockService.save(stock);
                    empruntDetailDao.save(e);
                }

            }
            );

            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public List<EmpruntDetail> findByEmpruntRef(String ref) {
        return empruntDetailDao.findByEmpruntRef(ref);
    }

    @Override
    public int deleteByEmpruntRef(String ref) {
        return empruntDetailDao.deleteByEmpruntRef(ref);
    }

}
