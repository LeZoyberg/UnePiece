package UnePiece.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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

import com.fasterxml.jackson.annotation.JsonView;

import UnePiece.dao.IDAOPirate;
import UnePiece.model.Pirate;

@RestController
@RequestMapping("/api/pirate")
@CrossOrigin("*")
public class PirateRestController {

	@Autowired
	private IDAOPirate daoPirate;

	@GetMapping("/{id}")
	public Pirate findById(@PathVariable Integer id) 
	{
		Optional<Pirate> opt = daoPirate.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
/*
 * 
 *  getRandomRecruits() : Pirate[] | void {
    this.findAll().subscribe(piratesResp => {
      const pirates : Pirate[] = piratesResp;
      const shuffledPirates = pirates.sort(() => 0.5 - Math.random());
      console.log('shuffledPirates :>> ', shuffledPirates);
      const returnedPirates = shuffledPirates.slice(0, 5);
      return returnedPirates;
    });
  }
 * 
 */
  	@GetMapping("/random")
	public List<Pirate> getRandomRecruits() {
		List<Pirate> pirates = this.findAll();
		List<Pirate> shuffledPirates = new ArrayList();
		int max = 5;
		int min = 2;
		Random random = new Random();
		int nombrePirates = random.nextInt(max - min + 1) + min;
		for(int i = 1; i <= nombrePirates; i++) {
			Random random1 = new Random();
			Pirate randomPirate = pirates.get(random1.nextInt(pirates.size()));
			shuffledPirates.add(randomPirate);
		}
		return shuffledPirates;
		// retirer capitaines + empêcher 2 fois même membre
	}

	@GetMapping
	public List<Pirate> findAll() 
	{
		return daoPirate.findAll();
	}
	
	@PostMapping
	public Pirate insert(@RequestBody Pirate pirate, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit n'est pas valide...");
		}*/
		return daoPirate.save(pirate);
	}
	
	@PutMapping("/{id}")
	public Pirate update(@PathVariable Integer id, @RequestBody Pirate pirate, BindingResult result) 
	{
		/*if(result.hasErrors()) 
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le produit n'est pas valide...");
		}*/
		return daoPirate.save(pirate);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoPirate.deleteById(id);
	}
	
}
