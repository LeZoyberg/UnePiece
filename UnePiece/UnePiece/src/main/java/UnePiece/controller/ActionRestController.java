package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOAction;

@RestController
@RequestMapping("/api/action")
public class ActionRestController {
	
	@Autowired
	private IDAOAction daoAction;

}
