package fst.sir.biblio.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fst.sir.biblio.bean.Achat;
import fst.sir.biblio.service.facade.AchatService;

@RequestMapping("/biblio/achat/")
@Controller
public class AchatRest {
@Autowired
private  AchatService achatService ;

@GetMapping("/ref/{ref}")
public Achat findByRef(String ref) {
	return achatService.findByRef(ref);
}
@GetMapping("/")
public List<Achat> findAll() {
	return achatService.findAll();
}
@PostMapping("/")
public int save(Achat achat) {
	return achatService.save(achat);
}
@PostMapping("/ref/{ref}")
public int removeAchat(String ref) {
	return achatService.removeAchat(ref);
}




}

