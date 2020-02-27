package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.service.facade.AchatService;

@RequestMapping("/biblio/achat/")
@Controller
public class AchatRest {
@Autowired
private  AchatService achatService ;

@GetMapping("/ref/{ref}")
public Achat findByRef(]@PathVariable String ref) {
	
	return achatService.findByRef(ref);
}

@GetMapping("/")
public List<Achat> findAll() {
	
	return achatService.findAll();
}

@PostMapping("/")
public int save(@RequestBody Achat achat) {
	
	Achat fonded=findByRef(achat.getRef());
	if (fonded!=null) {return -1;}
	else { 
		achatService.save(fonded); 
		return 1;
	}
	
}

@PutMapping("/ref/{ref}")
public int removeAchat(@PathVariable String ref) {
	Achat remove=findByRef(ref);
	if (remove!=null) {return -1;}
	else { 
		achatService.delete(remove);
		return 1;
	}
	




}
