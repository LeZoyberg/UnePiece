package UnePiece.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import UnePiece.dao.IDAOMembre;
import UnePiece.dao.IDAOPartie;
import UnePiece.dao.IDAOPirate;
import UnePiece.model.Membre;
import UnePiece.model.Partie;
import UnePiece.model.Pirate;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/membre")
@CrossOrigin("*")
public class MembreRestController {
	
	@Autowired
	private IDAOMembre daoMembre;
	@Autowired
	private IDAOPartie daoPartie;
	@Autowired
	private IDAOPirate daoPirate;

	@GetMapping("/{id}")
	public Membre findById(@PathVariable Integer id) 
	{
		Optional<Membre> opt = daoMembre.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	public List<Membre> findAll() 
	{
		return daoMembre.findAll();
	}
	
	@PostMapping("/{idPirate}")
	public Membre insert(@PathVariable Integer idPirate, @RequestBody Membre membre, BindingResult result) 
	{
		Pirate pirate = daoPirate.findById(idPirate).get();
		//Partie partie = daoPartie.findById(idPartie).get();
		
		//membre.setPartie(partie);
		membre.setPirate(pirate);
		
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La membre n'est pas valide...");
		}*/
		return daoMembre.save(membre);
	}
	
	@PutMapping("/{id}")
	public Membre update(@RequestBody Membre membre, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La membre n'est pas valide...");
		}*/
		return daoMembre.save(membre);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoMembre.deleteById(id);
	}
	
}
