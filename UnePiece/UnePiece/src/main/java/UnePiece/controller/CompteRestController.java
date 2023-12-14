package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOCompte;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	//@Jsontypeinfo (pour info sur l'heritage)
	
	@Autowired
	private IDAOCompte daoCompte;

}
