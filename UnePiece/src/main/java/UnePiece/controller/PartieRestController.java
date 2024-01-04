package UnePiece.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import UnePiece.dao.IDAOPartie;
import UnePiece.dto.ActionResponse;
import UnePiece.dto.MembreResponse;
import UnePiece.dto.PartieResponse;
import UnePiece.model.Membre;
import UnePiece.model.Partie;
import UnePiece.model.Action;

@RestController
@RequestMapping("/api/partie")
@CrossOrigin("*")
public class PartieRestController {

	@Autowired
	private IDAOPartie daoPartie;

	@GetMapping("/{id}")
	public PartieResponse findById(@PathVariable Integer id) {
		Optional<Partie> opt = daoPartie.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(opt.get(), partieDTO);
		return partieDTO;
	}

	@GetMapping("/joueur/{idJoueur}")
	public PartieResponse findByIdJoueurDTO(@PathVariable Integer idJoueur) {
		Optional<Partie> opt = daoPartie.findByIdJoueur(idJoueur);
		if (opt.isEmpty()) {
			return null;
		}
		Partie partie = opt.get();
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(partie, partieDTO);

		return partieDTO;
	}

	@GetMapping("/joueur/{idJoueur}/membres")
	public PartieResponse findByIdJoueurWithMembres(@PathVariable Integer idJoueur) {
		Optional<Partie> opt = daoPartie.findByIdJoueurWithMembres(idJoueur);
		if (opt.isEmpty()) {
			return null;
		}
		Partie partie = opt.get();
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(partie, partieDTO);
		for (Membre m : partie.getMembres()) {
			MembreResponse membreDTO = new MembreResponse();
			BeanUtils.copyProperties(m, membreDTO);
			partieDTO.getMembres().add(membreDTO);
		}

		return partieDTO;
	}

	@GetMapping("/joueur/{idJoueur}/membres/actions")
	public PartieResponse findByIdJoueurWithMembresAndActions(@PathVariable Integer idJoueur) {
		Optional<Partie> opt = daoPartie.findByIdJoueurWithMembresAndActions(idJoueur);
		if (opt.isEmpty()) {
			return null;
		}
		Partie partie = opt.get();
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(partie, partieDTO);
		for (Membre m : partie.getMembres()) {
			MembreResponse membreDTO = new MembreResponse();
			BeanUtils.copyProperties(m, membreDTO);
			partieDTO.getMembres().add(membreDTO);
		}
		for (Action a : partie.getActions()) {
			ActionResponse actionDTO = new ActionResponse();
			BeanUtils.copyProperties(a, actionDTO);
			partieDTO.getActions().add(actionDTO);
		}

		return partieDTO;
	}

	@GetMapping
	public List<PartieResponse> findAll() {
		List<Partie> parties = daoPartie.findAll();
		List<PartieResponse> partiesDTO = new ArrayList<PartieResponse>();
		for (Partie p : parties) {
			PartieResponse partieDTO = new PartieResponse();
			BeanUtils.copyProperties(p, partieDTO);
			partiesDTO.add(partieDTO);
		}
		return partiesDTO;
	}

	@GetMapping("/historique/{idJoueur}")
	public List<PartieResponse> findAllByIdJoueur(@PathVariable Integer idJoueur) {
		List<Partie> parties = daoPartie.findAllByIdJoueur(idJoueur);
		List<PartieResponse> partiesDTO = new ArrayList<PartieResponse>();
		for (Partie p : parties) {
			PartieResponse partieDTO = new PartieResponse();
			BeanUtils.copyProperties(p, partieDTO);
			partiesDTO.add(partieDTO);
		}
		return partiesDTO;
	}

	@GetMapping("/leaderboard")
	public List<PartieResponse> findLeaderboard() {
		List<Partie> parties = daoPartie.findAllByOrderByDureeDesc();
		List<PartieResponse> partiesDTO = new ArrayList<PartieResponse>();
		for (Partie p : parties) {
			PartieResponse partieDTO = new PartieResponse();
			BeanUtils.copyProperties(p, partieDTO);
			partiesDTO.add(partieDTO);
		}
		return partiesDTO;
	}

	@PostMapping
	public PartieResponse insert(@RequestBody Partie partie, BindingResult result) {
		/*
		 * if(result.hasErrors())
		 * {
		 * throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
		 * "La partie n'est pas valide...");
		 * }
		 */

		Optional<Partie> opt = daoPartie.findByIdJoueur(partie.getJoueur().getId());
		if (opt.isPresent()) {
			Partie anciennePartie = opt.get();
			anciennePartie.setTermine(true);
			daoPartie.save(anciennePartie);
		}
		daoPartie.save(partie);
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(partie, partieDTO);
		return partieDTO;
	}

	@PutMapping("/{id}")
	public PartieResponse update(@PathVariable Integer id, @RequestBody Partie partie, BindingResult result) {
		daoPartie.save(partie);
		PartieResponse partieDTO = new PartieResponse();
		BeanUtils.copyProperties(partie, partieDTO);
		return partieDTO;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		daoPartie.deleteById(id);
	}

}
