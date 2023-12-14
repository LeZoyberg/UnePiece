package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOMembre;

@RestController
@RequestMapping("/api/membre")
public class MembreRestController {
	
	@Autowired
	private IDAOMembre daoMembre;

}
