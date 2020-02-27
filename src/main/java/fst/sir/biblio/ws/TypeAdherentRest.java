package fst.sir.biblio.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.service.facade.TypeAdherentService;

@Controller
@RequestMapping("/biblio/typeadherent")
public class TypeAdherentRest {
	@Autowired
private TypeAdherentService typeadherentservice ;
	
	@GetMapping("/profession/{profession}")
public List<Adherent> findByprofession(String profession) {
		
		return typeadherentservice.findByprofession(profession);
	}

}
