package UnePiece.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import UnePiece.dao.IDAOEvenement;
import UnePiece.model.Evenement;

@RestController
@RequestMapping("/api/event")
@CrossOrigin("*")
public class EventRestController {
	
	@Autowired
	private IDAOEvenement daoEvent;

	@GetMapping("/{id}")
	public Evenement findById(@PathVariable Integer id) 
	{
		Optional<Evenement> opt = daoEvent.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping("/random/{N}")
	public List<Evenement> findNRandomEvents(@PathVariable int N) {
		List<Evenement> events = daoEvent.findAll();
		if(!events.isEmpty()) {
			Random r = new Random();
			List<Evenement> shuffledEvents = new ArrayList<Evenement>();
			for(int i = 0; i < N ; i++) {
				Evenement randomEvent = events.get(r.nextInt(events.size()));
				shuffledEvents.add(randomEvent); 
			}
			return shuffledEvents;
		}
		return null;
	}

	@GetMapping
	public List<Evenement> findAll() 
	{
		return daoEvent.findAll();
	}
	
	@PostMapping
	public Evenement insert(@RequestBody Evenement event, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La event n'est pas valide...");
		}*/
		return daoEvent.save(event);
	}
	
	@PutMapping("/{id}")
	public Evenement update(@PathVariable Integer id, @RequestBody Evenement event, BindingResult result) 
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
