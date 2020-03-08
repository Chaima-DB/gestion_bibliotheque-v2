package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fst.sir.biblio.bean.Adherent;
import fst.sir.biblio.bean.TypeAdherent;
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

	@PostMapping("/")
	public int save(@RequestBody TypeAdherent typeAdherent) {
		return typeadherentservice.save(typeAdherent);
	}

@DeleteMapping("/typeadherent/{profession}")
	public int deleteByprofession(@PathVariable  String profession) {
		return typeadherentservice.deleteByprofession(profession);
	}
	
}

