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

import UnePiece.dao.IDAOEvent;
import UnePiece.model.Event;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/event")
public class EventRestController {
	
	@Autowired
	private IDAOEvent daoEvent;

	@GetMapping("/{id}")
	@JsonView(Views.Event.class)
	public Event findById(@PathVariable Integer id) 
	{
		Optional<Event> opt = daoEvent.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Event> findAll() 
	{
		return daoEvent.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Event.class)
	public Event insert(@RequestBody Event event, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La event n'est pas valide...");
		}*/
		return daoEvent.save(event);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Event.class)
	public Event update(@RequestBody Event event, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La event n'est pas valide...");
		}*/
		return daoEvent.save(event);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoEvent.deleteById(id);
	}
	
}
