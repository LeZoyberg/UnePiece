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

import UnePiece.dao.IDAOPartie;
import UnePiece.model.Partie;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/partie")
@CrossOrigin("*")
public class PartieRestController {
	
	@Autowired
	private IDAOPartie daoPartie;

	@GetMapping("/{id}")
	public Partie findById(@PathVariable Integer id) 
	{
		System.out.println("findById Partie");
		Optional<Partie> opt = daoPartie.findById(id);
		System.out.println(opt.get().toString());
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	public List<Partie> findAll() 
	{
		return daoPartie.findAll();
	}
	
	@PostMapping
	public Partie insert(@RequestBody Partie partie, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La partie n'est pas valide...");
		}*/
		return daoPartie.save(partie);
	}
	
	@PutMapping("/{id}")
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
