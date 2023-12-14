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

import UnePiece.dao.IDAOIle;
import UnePiece.model.Ile;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/ile")
public class IleRestController {
	
	@Autowired
	private IDAOIle daoIle;

	@GetMapping("/{id}")
	@JsonView(Views.Ile.class)
	public Ile findById(@PathVariable Integer id) 
	{
		Optional<Ile> opt = daoIle.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Ile> findAll() 
	{
		return daoIle.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Ile.class)
	public Ile insert(@RequestBody Ile ile, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La ile n'est pas valide...");
		}*/
		return daoIle.save(ile);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Ile.class)
	public Ile update(@RequestBody Ile ile, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La ile n'est pas valide...");
		}*/
		return daoIle.save(ile);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoIle.deleteById(id);
	}
	
}
