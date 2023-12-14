package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAONavire;

@RestController
@RequestMapping("/api/navire")
public class NavireRestController {
	
	@Autowired
	private IDAONavire daoNavire;

}
