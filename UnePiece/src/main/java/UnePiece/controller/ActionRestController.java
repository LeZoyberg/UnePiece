package UnePiece.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import UnePiece.model.Evenement;
import UnePiece.model.Partie;

@RestController
@RequestMapping("/api/action")
@CrossOrigin("*")
public class ActionRestController {

	@Autowired
	private IDAOAction daoAction;
	@Autowired
	private IDAOPartie daoPartie;
	@Autowired
	private EventRestController eventRC;

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

	/*
	 * if(events.length != 0) {
	 * for(let e of events) {
	 * let action : Action = new Action();
	 * action.event = e;
	 * action.partie = this.partie;
	 * action.termine = false;
	 * action.degatMembre = Math.floor((e.degatMembre as number) *
	 * (destination.dangerosite as number) / 2);
	 * action.degatNavire = Math.floor((e.degatNavire as number) *
	 * (destination.dangerosite as number) / 2);
	 * action.tresor = Math.floor((e.tresor as number) * (destination.dangerosite as
	 * number));
	 * this.actionService.create(action).subscribe(actionResp => {
	 * action.id = actionResp.id;
	 * actions.push(action);
	 * })
	 * }
	 */

	@GetMapping("/random/{N}/{partieId}")
	public List<ActionResponse> findNRandomActions(@PathVariable int N, @PathVariable Integer partieId) {

		Optional<Partie> opt = daoPartie.findById(partieId);
		if (opt.isPresent()) {
			Partie partie = opt.get();
			List<Evenement> events = this.eventRC.findNRandomEvents(N);
			List<ActionResponse> actions = new ArrayList<ActionResponse>();
			for (Evenement e : events) {
				Action action = new Action();
				action.setPartie(partie);
				action.setEvent(e);
				action.setTermine(false);
				int degatMembre = (int) Math.ceil((action.getPartie().getIle().getDangerosite() * e.getDegatMembre()) * 0.75);
				action.setDegatMembre(degatMembre);
				int degatNavire = (int) Math.ceil((action.getPartie().getIle().getDangerosite() * e.getDegatNavire()) * 0.75);
				action.setDegatNavire(degatNavire);
				int tresor = (action.getPartie().getIle().getDangerosite() * e.getTresor());
				action.setTresor(tresor);
				this.insert(action);
				ActionResponse actionDTO = new ActionResponse();
				BeanUtils.copyProperties(action, actionDTO);
				actions.add(actionDTO);
			}
			return actions;
		}
		return null;
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
			if (opt.isPresent()) {
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
