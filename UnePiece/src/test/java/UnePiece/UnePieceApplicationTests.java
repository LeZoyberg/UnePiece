package UnePiece;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import UnePiece.dao.IDAOAction;
import UnePiece.dao.IDAOBateau;
import UnePiece.dao.IDAOCompte;
import UnePiece.dao.IDAOEvenement;
import UnePiece.dao.IDAOIle;
import UnePiece.dao.IDAOMembre;
import UnePiece.dao.IDAONavire;
import UnePiece.dao.IDAOPartie;
import UnePiece.dao.IDAOPirate;
import UnePiece.model.Action;
import UnePiece.model.Bateau;
import UnePiece.model.Evenement;
import UnePiece.model.Ile;
import UnePiece.model.Joueur;
import UnePiece.model.Membre;
import UnePiece.model.Mer;
import UnePiece.model.Navire;
import UnePiece.model.Odyssee;
import UnePiece.model.Partie;
import UnePiece.model.Pirate;

@SpringBootTest
class UnePieceApplicationTests {

	@Autowired
	private IDAOPirate daoPirate;
	@Autowired
	private IDAOMembre daoMembre;
	@Autowired
	private IDAOBateau daoBateau;
	@Autowired
	private IDAONavire daoNavire;
	@Autowired
	private IDAOIle daoIle;
	@Autowired
	private IDAOEvenement daoEvenement;
	@Autowired
	private IDAOCompte daoCompte;
	@Autowired
	private IDAOAction daoAction;
	@Autowired
	private IDAOPartie daoPartie;
	
	@Test
	void initBdd() {
	Pirate pirate1 = new Pirate(10,10,15,true,true,"Luffy");
	Pirate pirate2 = new Pirate(15,15,10,false,false,"Zorro");
	Pirate pirate3 = new Pirate(2,2,2,false,false,"Ussop");
	Pirate pirate4 = new Pirate(18,18,20,true,false,"Robin");
	
	Membre membre1 = new Membre(pirate1.getPv(), pirate1.getPower(), pirate1);
	Membre membre2 = new Membre(pirate2.getPv(), pirate2.getPower(), pirate2);
	Membre membre3 = new Membre(pirate3.getPv(), pirate3.getPower(), pirate3);
	List<Membre> membres = new ArrayList<Membre>();
	Collections.addAll(membres, membre1, membre2, membre3);
	
	Bateau bateau1 = new Bateau("Vogue Merry",10,10,10,true);
	Bateau bateau2 = new Bateau("Thousand Sunny",15,15,15,false);
	
	Navire navire1 = new Navire(bateau1.getRobustesse(), bateau1);
	Navire navire2 = new Navire(bateau2.getRobustesse(), bateau2);
	
	Ile ile1 = new Ile("Fuschia Village", true, true, true, 10, 1, Mer.EastBlue);
	Ile ile2 = new Ile("Shells Town", false, false, true, 8, 2, Mer.EastBlue);
	Ile ile3 = new Ile("Elena", false, false, true, 8, 2, Mer.NorthBlue);
	
	Evenement event1 = new Evenement(10,10,0,Odyssee.Tempete);
	Evenement event2 = new Evenement(15,15,10,Odyssee.Bataille);
	Evenement event3 = new Evenement(0,0,50,Odyssee.Tresor);
	
	Joueur joueur1 = new Joueur("player1", "password");
	Joueur joueur2 = new Joueur("player2", "password");
	
	Action action1 = new Action(true, event1.getDegatNavire(), event1.getDegatMembre(), event1.getTresor(), event1);
	Action action2 = new Action(false, event2.getDegatNavire(), event2.getDegatMembre(), event2.getTresor(), event2);
	Action action3 = new Action(false, event3.getDegatNavire(), event3.getDegatMembre(), event3.getTresor(), event3);
	List<Action> actionsPartie1 = new ArrayList<Action>();
	Collections.addAll(actionsPartie1, action1, action2);
	List<Action> actionsPartie2 = new ArrayList<Action>();
	Collections.addAll(actionsPartie2, action3);
	
	Partie partie1 = new Partie(LocalDate.now(), false, 100, 10, membres, ile1, navire1, joueur1, actionsPartie1);
	Partie partie2 = new Partie(LocalDate.now(), false, 100, 10, membres, ile2, navire2, joueur2, actionsPartie2);
	
	
	daoPirate.save(pirate1);
	daoPirate.save(pirate2);
	daoPirate.save(pirate3);
	daoPirate.save(pirate4);
	
	daoMembre.save(membre1);
	daoMembre.save(membre2);
	daoMembre.save(membre3);
	
	daoBateau.save(bateau1);
	daoBateau.save(bateau2);
	
	daoNavire.save(navire1);
	daoNavire.save(navire2);
	
	daoIle.save(ile1);
	daoIle.save(ile2);
	daoIle.save(ile3);
	
	daoEvenement.save(event1);
	daoEvenement.save(event2);
	daoEvenement.save(event3);
	
	daoCompte.save(joueur1);
	daoCompte.save(joueur2);
	
	partie1 = daoPartie.save(partie1);
	partie2 = daoPartie.save(partie2);
	
	action1.setPartie(partie1);
	action2.setPartie(partie1);
	action3.setPartie(partie2);
	
	daoAction.save(action1);
	daoAction.save(action2);
	daoAction.save(action3);
	}
}
