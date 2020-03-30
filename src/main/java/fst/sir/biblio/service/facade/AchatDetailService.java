package fst.sir.biblio.service.facade;

import java.util.List;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.bean.AchatDetail;
import fst.sir.biblio.bean.Stock;

public interface AchatDetailService {
	

	boolean validateAchatDetail(Achat achat, List<AchatDetail> achatDetails);

	int save(Achat achat, List<AchatDetail> achatDetails);

	 List<AchatDetail>  findByAchatRef(String ref);

	int deleteByAchatRef(String ref);
        
}
