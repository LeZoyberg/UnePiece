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

import UnePiece.dao.IDAOIle;
import UnePiece.model.Ile;
import UnePiece.model.Mer;

@RestController
@RequestMapping("/api/ile")
@CrossOrigin("*")
public class IleRestController {
	
	@Autowired
	private IDAOIle daoIle;

	@GetMapping("/mer/{mer}")
	public List<Ile> findAllFirstIlesNextMer(@PathVariable String mer) {
		return daoIle.findAllByMerAndOrdre(Mer.valueOf(mer), 1);
	}

	@GetMapping("/mer/{mer}/{ordre}")
	public List<Ile> findAllNextIlesSameMer(@PathVariable String mer, @PathVariable Integer ordre) {
		return daoIle.findAllByMerAndOrdre(Mer.valueOf(mer), ordre);
	}

	@GetMapping("/{id}")
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
	public List<Ile> findAll() 
	{
		return daoIle.findAll();
	}
	
	@PostMapping
	public Ile insert(@RequestBody Ile ile, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La ile n'est pas valide...");
		}*/
		return daoIle.save(ile);
	}
	
	@PutMapping("/{id}")
	public Ile update(@PathVariable Integer id, @RequestBody Ile ile, BindingResult result) 
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
