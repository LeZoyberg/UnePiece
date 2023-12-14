package UnePiece.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
import UnePiece.model.Membre;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/membre")
public class MembreRestController {
	
	@Autowired
	private IDAOMembre daoMembre;

	@GetMapping("/{id}")
	@JsonView(Views.Membre.class)
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
	@JsonView(Views.Common.class)
	public List<Membre> findAll() 
	{
		return daoMembre.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Membre.class)
	public Membre insert(@RequestBody Membre membre, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La membre n'est pas valide...");
		}*/
		return daoMembre.save(membre);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Membre.class)
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
