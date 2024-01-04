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

import UnePiece.dao.IDAOAction;
import UnePiece.dao.IDAOPartie;
import UnePiece.dto.ActionResponse;
import UnePiece.dto.PartieResponse;
import UnePiece.model.Action;
import UnePiece.model.Partie;

@RestController
@RequestMapping("/api/action")
@CrossOrigin("*")
public class ActionRestController {

	@Autowired
	private IDAOAction daoAction;
	@Autowired
	private IDAOPartie daoPartie;

	@GetMapping("/{id}")
	public ActionResponse findById(@PathVariable Integer id) {
		Optional<Action> opt = daoAction.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		ActionResponse actionDTO = new ActionResponse();
		BeanUtils.copyProperties(opt.get(), actionDTO);
		return actionDTO;
	}

	@GetMapping
	public List<ActionResponse> findAll() {
		List<Action> actions = daoAction.findAll();
		List<ActionResponse> actionsDTO = new ArrayList<ActionResponse>();
		for (Action a : actions) {
			ActionResponse actionDTO = new ActionResponse();
			BeanUtils.copyProperties(a, actionDTO);
			System.out.println("for findAll" + a + actionDTO);
			actionsDTO.add(actionDTO);
		}
		return actionsDTO;
	}

	@GetMapping("/partie/{partieId}")
	public List<ActionResponse> findAllWithPartie(@PathVariable Integer partieId) {
		List<Action> actions = daoAction.findAllWithPartie(partieId);
		List<ActionResponse> actionsDTO = new ArrayList<ActionResponse>();
		for (Action a : actions) {
			ActionResponse actionDTO = new ActionResponse();
			BeanUtils.copyProperties(a, actionDTO);
			Optional<Partie> opt = daoPartie.findById(partieId);
			if(opt.isPresent()) {
				Partie partie = opt.get();
				PartieResponse partieDTO = new PartieResponse();
				BeanUtils.copyProperties(partie, partieDTO);
				actionDTO.setPartie(partieDTO);
			}
			actionsDTO.add(actionDTO);
		}
		return actionsDTO;
	}

	@PostMapping
	public ActionResponse insert(@RequestBody Action action) {
		daoAction.save(action);
		ActionResponse actionDTO = new ActionResponse();
		BeanUtils.copyProperties(action, actionDTO);
		return actionDTO;
	}

	@PutMapping("/{id}")
	public ActionResponse update(@PathVariable Integer id, @RequestBody Action action) {
		daoAction.save(action);
		ActionResponse actionDTO = new ActionResponse();
		BeanUtils.copyProperties(action, actionDTO);
		return actionDTO;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		daoAction.deleteById(id);
	}

}
