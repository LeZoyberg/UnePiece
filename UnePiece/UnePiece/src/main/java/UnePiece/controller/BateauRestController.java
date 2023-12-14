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

import UnePiece.dao.IDAOBateau;
import UnePiece.model.Bateau;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/bateau")
public class BateauRestController {
	
	@Autowired
	private IDAOBateau daoBateau;

	@GetMapping("/{id}")
	@JsonView(Views.Bateau.class)
	public Bateau findById(@PathVariable Integer id) 
	{
		Optional<Bateau> opt = daoBateau.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Bateau> findAll() 
	{
		return daoBateau.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Bateau.class)
	public Bateau insert(@RequestBody Bateau bateau, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La bateau n'est pas valide...");
		}*/
		return daoBateau.save(bateau);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Bateau.class)
	public Bateau update(@RequestBody Bateau bateau, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La bateau n'est pas valide...");
		}*/
		return daoBateau.save(bateau);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoBateau.deleteById(id);
	}
	
}
