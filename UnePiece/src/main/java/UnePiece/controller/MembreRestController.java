package UnePiece.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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


import UnePiece.dao.IDAOMembre;
import UnePiece.dao.IDAOPirate;
import UnePiece.dto.MembreResponse;
import UnePiece.model.Membre;
import UnePiece.model.Pirate;

@RestController
@RequestMapping("/api/membre")
@CrossOrigin("*")
public class MembreRestController {
	
	@Autowired
	private IDAOMembre daoMembre;
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
	public MembreResponse update(@PathVariable Integer id, @RequestBody Membre membre, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La membre n'est pas valide...");
		}*/
		daoMembre.save(membre);

		MembreResponse membreDTO = new MembreResponse();
		BeanUtils.copyProperties(membre, membreDTO);
		return membreDTO;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoMembre.deleteById(id);
	}
	
	
}
