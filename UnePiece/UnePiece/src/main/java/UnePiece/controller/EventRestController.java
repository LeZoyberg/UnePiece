package UnePiece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UnePiece.dao.IDAOEvent;

@RestController
@RequestMapping("/api/event")
public class EventRestController {
	
	@Autowired
	private IDAOEvent daoEvent;

}
