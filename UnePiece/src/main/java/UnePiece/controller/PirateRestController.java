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

import UnePiece.dao.IDAOIle;
import UnePiece.dao.IDAOPirate;
import UnePiece.model.Ile;
import UnePiece.model.Pirate;

@RestController
@RequestMapping("/api/pirate")
@CrossOrigin("*")
public class PirateRestController {

	@Autowired
	private IDAOPirate daoPirate;
	@Autowired
	private IDAOIle daoIle;

	@GetMapping("/{id}")
	public Pirate findById(@PathVariable Integer id) {
		Optional<Pirate> opt = daoPirate.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	@GetMapping("/random")
	public List<Pirate> getRandomRecruits(/*@PathVariable Integer idIle*/) {
		List<Pirate> pirates = daoPirate.findAllNotCapitaine();

		// retire les capitaines
		int totalPirates = pirates.size();
	

		// TODO WIP \/
		// // trie selon la mer et le tier des pirates
		// Optional<Ile> opt = daoIle.findById(idIle);
		// if (opt.isEmpty()) {
		// 	System.out.println("Aucune île trouvée avec cet Id (getRandomPirates PirateRestController)");
		// 	return null;
		// }
		// Ile destination = opt.get();
		// String seaName = destination.getMer().name();
		// for (int i = 0; i < totalPirates; i++) {
		// 	if (seaName == "EastBlue") {
		// 		pirates = daoPirate.findAllByTier(1);
		// 	} else if (seaName == "WestBlue" || seaName == "NorthBlue") {

		// 		pirates = daoPirate.findAllByTierOrTier(1, 2);
		// 	} else if (seaName == "SouthBlue") {
		// 		pirates = daoPirate.findAllByTierOrTier(2, 3);
		// 	} else if (seaName == "GrandLine" || seaName == "NewWorld") {
		// 		pirates = daoPirate.findAllByTierOrTier(3, 4);
		// 	}
		// }

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
