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

import UnePiece.dao.IDAOBateau;
import UnePiece.model.Bateau;

@RestController
@RequestMapping("/api/bateau")
@CrossOrigin("*")
public class BateauRestController {
	
	@Autowired
	private IDAOBateau daoBateau;

	@GetMapping("/{id}")
	public Bateau findById(@PathVariable Integer id) 
	{
		Optional<Bateau> opt = daoBateau.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		return opt.get();
	}
	
	@GetMapping("/random/{idIle}")
	public List<Bateau> getRandomBateaux(@PathVariable Integer idIle) {
		List<Bateau> bateaux = this.findAll();
		// retire les bateaux pas de début quand on est sur la première île (idIle = 1)
		int totalBateaux = bateaux.size();
		for (int i = 0; i < totalBateaux; i++) {
			if(i < bateaux.size()) {
				Bateau b = bateaux.get(i);
				if (idIle == 1 && !b.isDebut()) {
					bateaux.remove(i);
					i--;
				}
			}
		}

	List<Bateau> shuffledBateaux = new ArrayList<Bateau>();
		int max = 3;
		int min = 2;
		Random random = new Random();
		int nombreBateaux = random.nextInt(max - min + 1) + min;
		for (int i = 1; i <= nombreBateaux; i++) {
			Random random1 = new Random();
			Bateau randomBateau = bateaux.get(random1.nextInt(bateaux.size()));
			shuffledBateaux.add(randomBateau);
		}
		return shuffledBateaux;
	}

	@GetMapping
	public List<Bateau> findAll() 
	{
		return daoBateau.findAll();
	}
	
	@PostMapping
	public Bateau insert(@RequestBody Bateau bateau, BindingResult result) 
	{
		return daoBateau.save(bateau);
	}
	
	@PutMapping("/{id}")
	public Bateau update(@PathVariable Integer id, @RequestBody Bateau bateau, BindingResult result) 
	{
		return daoBateau.save(bateau);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) 
	{
		daoBateau.deleteById(id);
	}
	
}
