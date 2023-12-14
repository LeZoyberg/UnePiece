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

import UnePiece.dao.IDAOCompte;
import UnePiece.model.Compte;
import UnePiece.view.Views;

@RestController
@RequestMapping("/api/compte")
public class CompteRestController {
	//@Jsontypeinfo (pour info sur l'heritage)
	
	@Autowired
	private IDAOCompte daoCompte;

	@GetMapping("/{id}")
	@JsonView(Views.Compte.class)
	public Compte findById(@PathVariable Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping
	@JsonView(Views.Common.class)
	public List<Compte> findAll() 
	{
		return daoCompte.findAll();
	}
	
	@PostMapping
	@JsonView(Views.Compte.class)
	public Compte insert(@RequestBody Compte compte, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La compte n'est pas valide...");
		}*/
		return daoCompte.save(compte);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Compte.class)
	public Compte update(@RequestBody Compte compte, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La compte n'est pas valide...");
		}*/
		return daoCompte.save(compte);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
}
