package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;


public interface AchatDetailService {
	 public int save(Achat achat, List<AchatDetail> achatDetail);

	    public boolean validateAchatDetail(Achat achat, List<AchatDetail> achatDetails);

	    public List<AchatDetail> findByAchatRef(String ref);

	    public int deleteByAchattRef(String ref);


}
