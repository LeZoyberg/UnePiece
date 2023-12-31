package UnePiece.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import UnePiece.dao.IDAOCompte;
import UnePiece.model.Compte;
import UnePiece.model.Joueur;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin("*")
public class CompteRestController {
	//@Jsontypeinfo (pour info sur l'heritage)
	
	@Autowired
	private IDAOCompte daoCompte;
	
	@PostMapping("/connexion")
	public Compte connexion(@RequestBody Joueur joueur) {
		Optional<Compte> opt = daoCompte.findByUsernameAndPassword(joueur.getLogin(), joueur.getPassword());

		if (opt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return opt.get();
	}
	
	@PostMapping("/inscription")
	public void inscription(@RequestBody Joueur joueur) {
		Compte compte = new Joueur(joueur.getLogin(), joueur.getPassword());
		daoCompte.save(compte);
	}
	
	@GetMapping("/{id}")
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
	public List<Compte> findAll() 
	{
		return daoCompte.findAll();
	}
	
	@PostMapping
	public Compte insert(@RequestBody Compte compte, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La compte n'est pas valide...");
		}*/
		return daoCompte.save(compte);
	}
	
	@PutMapping("/{id}")
	public Compte update(@PathVariable Integer id, @RequestBody Compte compte, BindingResult result) 
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
