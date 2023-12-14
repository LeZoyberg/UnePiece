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

import UnePiece.dao.IDAONavire;
import UnePiece.model.Navire;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/navire")
public class NavireRestController {
	
	@Autowired
	private IDAONavire daoNavire;

	@GetMapping("/{id}")
	@JsonView(Views.Navire.class)
	public Navire findById(@PathVariable Integer id) 
	{
		Optional<Navire> opt = daoNavire.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Navire> findAll() 
	{
		return daoNavire.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Navire.class)
	public Navire insert(@RequestBody Navire navire, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La navire n'est pas valide...");
		}*/
		return daoNavire.save(navire);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Navire.class)
	public Navire update(@RequestBody Navire navire, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La navire n'est pas valide...");
		}*/
		return daoNavire.save(navire);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoNavire.deleteById(id);
	}
	
}
