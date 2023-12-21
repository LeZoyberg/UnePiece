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

import UnePiece.dao.IDAOAction;
import UnePiece.model.Action;

@RestController
@RequestMapping("/api/action")
@CrossOrigin("*")
public class ActionRestController {
	
	@Autowired
	private IDAOAction daoAction;

	@GetMapping("/{id}")
	public Action findById(@PathVariable Integer id) 
	{
		Optional<Action> opt = daoAction.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	public List<Action> findAll() 
	{
		return daoAction.findAll();
	}
	
	@PostMapping
	public Action insert(@RequestBody Action action, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La action n'est pas valide...");
		}*/
		return daoAction.save(action);
	}
	
	@PutMapping("/{id}")
	public Action update(@RequestBody Action action, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La action n'est pas valide...");
		}*/
		return daoAction.save(action);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoAction.deleteById(id);
	}
	
}
