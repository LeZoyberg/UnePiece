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

import UnePiece.dao.IDAOPartie;
import UnePiece.model.Partie;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/partie")
public class PartieRestController {
	
	@Autowired
	private IDAOPartie daoPartie;

	@GetMapping("/{id}")
	@JsonView(Views.Partie.class)
	public Partie findById(@PathVariable Integer id) 
	{
		Optional<Partie> opt = daoPartie.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Partie> findAll() 
	{
		return daoPartie.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Partie.class)
	public Partie insert(@RequestBody Partie partie, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La partie n'est pas valide...");
		}*/
		return daoPartie.save(partie);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Partie.class)
	public Partie update(@RequestBody Partie partie, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La partie n'est pas valide...");
		}*/
		return daoPartie.save(partie);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoPartie.deleteById(id);
	}
	
}
