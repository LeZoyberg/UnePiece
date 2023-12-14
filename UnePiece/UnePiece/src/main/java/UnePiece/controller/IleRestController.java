package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOIle;

@RestController
@RequestMapping("/api/ile")
public class IleRestController {
	
	@Autowired
	private IDAOIle daoIle;

}
