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

import UnePiece.dao.IDAOPirate;
import UnePiece.model.Pirate;

@RestController
@RequestMapping("/api/pirate")
@CrossOrigin("*")
public class PirateRestController {

	@Autowired
	private IDAOPirate daoPirate;

	@GetMapping("/{id}")
	public Pirate findById(@PathVariable Integer id) {
		Optional<Pirate> opt = daoPirate.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	@GetMapping("/random")
	public List<Pirate> getRandomRecruits() {
		List<Pirate> pirates = this.findAll();

		// retire les capitaines
		int totalPirates = pirates.size();
		for (int i = 0; i < totalPirates; i++) {
			if(i < pirates.size()) {
				Pirate p = pirates.get(i);
				if (p.isCapitaine()) {
					pirates.remove(i);
					i--;
				}
			}
		}

		List<Pirate> shuffledPirates = new ArrayList<Pirate>();
		int max = 5;
		int min = 3;
		Random random = new Random();
		int nombrePirates = random.nextInt(max - min + 1) + min;
		for (int i = 1; i <= nombrePirates; i++) {
			Random random1 = new Random();
			Pirate randomPirate = pirates.get(random1.nextInt(pirates.size()));
			shuffledPirates.add(randomPirate);
		}
		return shuffledPirates;
	}

	@GetMapping
	public List<Pirate> findAll() {
		return daoPirate.findAll();
	}

	@PostMapping
	public Pirate insert(@RequestBody Pirate pirate, BindingResult result) {

		return daoPirate.save(pirate);
	}

	@PutMapping("/{id}")
	public Pirate update(@PathVariable Integer id, @RequestBody Pirate pirate, BindingResult result) {

		return daoPirate.save(pirate);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		daoPirate.deleteById(id);
	}

}
