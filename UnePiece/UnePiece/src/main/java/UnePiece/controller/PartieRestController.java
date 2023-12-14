package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOPartie;

@RestController
@RequestMapping("/api/partie")
public class PartieRestController {
	
	@Autowired
	private IDAOPartie daoPartie;

}
