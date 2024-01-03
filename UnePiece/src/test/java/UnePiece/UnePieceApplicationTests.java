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

		// capitaines
		Pirate capitaine1 = new Pirate(25, 25, 25, true, true, "Luffy");
		daoPirate.save(capitaine1);

		Pirate capitaine2 = new Pirate(18, 30, 40, true, true, "Moira");
		daoPirate.save(capitaine2);

		Pirate capitaine3 = new Pirate(20, 20, 20, true, true, "Law");
		daoPirate.save(capitaine3);

		Pirate capitaine4 = new Pirate(60, 60, 60, true, true, "Ener");
		daoPirate.save(capitaine4);

		Pirate capitaine5 = new Pirate(20, 15, 20, false, true, "Arlong");
		daoPirate.save(capitaine5);

		Pirate capitaine6 = new Pirate(80, 80, 100, true, true, "Dragon");
		daoPirate.save(capitaine6);

		Pirate capitaine7 = new Pirate(60, 100, 150, false, true, "Roger");
		daoPirate.save(capitaine7);

		Pirate capitaine8 = new Pirate(20, 30, 30, true, true, "Crocodile");
		daoPirate.save(capitaine8);

		Pirate capitaine9 = new Pirate(66, 66, 66, true, true, "Doflamingo");
		daoPirate.save(capitaine9);

		// pirates
		Pirate pirate1 = new Pirate(20, 10, 10, false, false, "Franky");
		daoPirate.save(pirate1);

		Pirate pirate2 = new Pirate(10, 10, 8, false, false, "Ussop");
		daoPirate.save(pirate2);

		Pirate pirate3 = new Pirate(20, 20, 20, true, false, "Robin");
		daoPirate.save(pirate3);

		Pirate pirate4 = new Pirate(15, 15, 2, true, false, "Chopper");
		daoPirate.save(pirate4);

		Pirate pirate5 = new Pirate(10, 10, 8, false, false, "Nami");
		daoPirate.save(pirate5);

		Pirate pirate6 = new Pirate(20, 20, 15, false, false, "Sanji");
		daoPirate.save(pirate6);

		Pirate pirate7 = new Pirate(10, 12, 9, true, false, "Brook");
		daoPirate.save(pirate7);

		Pirate pirate8 = new Pirate(23, 23, 18, false, false, "Zoro");
		daoPirate.save(pirate8);

		Pirate pirate9 = new Pirate(5, 10, 5, false, false, "Vivi");
		daoPirate.save(pirate9);

		Pirate pirate10 = new Pirate(33, 33, 33, true, false, "Ace");
		daoPirate.save(pirate10);

		Pirate pirate11 = new Pirate(80, 80, 80, false, false, "Shanks");
		daoPirate.save(pirate11);

		Pirate pirate12 = new Pirate(75, 75, 75, false, false, "Mihawk");
		daoPirate.save(pirate12);

		Pirate pirate13 = new Pirate(60, 30, 40, false, false, "Neptune");
		daoPirate.save(pirate13);

		Pirate pirate14 = new Pirate(50, 50, 50, false, false, "Jinbei");
		daoPirate.save(pirate14);

		Pirate pirate15 = new Pirate(15, 15, 15, false, false, "Octo");
		daoPirate.save(pirate15);

		Pirate pirate16 = new Pirate(10, 20, 15, true, false, "VanderDecken");
		daoPirate.save(pirate16);

		Pirate pirate17 = new Pirate(20, 20, 20, false, false, "Hody");
		daoPirate.save(pirate17);

		Pirate pirate18 = new Pirate(33, 33, 33, false, false, "Sabo");
		daoPirate.save(pirate18);

		Pirate pirate19 = new Pirate(75, 75, 75, true, false, "Kuma");
		daoPirate.save(pirate19);

		Pirate pirate20 = new Pirate(16, 14, 4, false, false, "Bepo");
		daoPirate.save(pirate20);

		Pirate pirate21 = new Pirate(35, 20, 27, true, false, "Mr.1");
		daoPirate.save(pirate21);

		Pirate pirate22 = new Pirate(24, 23, 22, true, false, "Mr.2");
		daoPirate.save(pirate22);

		Pirate pirate23 = new Pirate(15, 13, 11, true, false, "Mr.3");
		daoPirate.save(pirate23);

		Pirate pirate24 = new Pirate(40, 40, 40, false, false, "Beckmann");
		daoPirate.save(pirate24);

		Pirate pirate25 = new Pirate(40, 40, 10, false, false, "LuckyRoo");
		daoPirate.save(pirate25);

		Pirate pirate26 = new Pirate(37, 35, 33, false, false, "Yassop");
		daoPirate.save(pirate26);

		Pirate pirate27 = new Pirate(63, 69, 59, false, false, "BarbeNoire");
		daoPirate.save(pirate27);

		Pirate pirate28 = new Pirate(71, 67, 68, true, false, "Marco");
		daoPirate.save(pirate28);

		// membres
		// les membres sont save après partie
		Membre membre1 = new Membre(capitaine1.getPv(), capitaine1.getPower(), capitaine1);
		Membre membre2 = new Membre(pirate2.getPv(), pirate2.getPower(), pirate2);
		Membre membre3 = new Membre(pirate3.getPv(), pirate3.getPower(), pirate3);
		List<Membre> equipage1 = new ArrayList<Membre>();
		Collections.addAll(equipage1, membre1, membre2, membre3);

		Membre membre4 = new Membre(capitaine3.getPv(), capitaine3.getPower(), capitaine3);
		Membre membre5 = new Membre(pirate2.getPv(), pirate2.getPower(), pirate2);
		Membre membre6 = new Membre(pirate25.getPv(), pirate25.getPower(), pirate25);
		List<Membre> equipage2 = new ArrayList<Membre>();
		Collections.addAll(equipage2, membre4, membre5, membre6);

		// bateaux
		Bateau bateau1 = new Bateau("Petite barque", 2, 2, 2, true);
		daoBateau.save(bateau1);

		Bateau bateau2 = new Bateau("Vogue Merry", 10, 10, 10, true);
		daoBateau.save(bateau2);

		Bateau bateau3 = new Bateau("Thousand Sunny", 15, 15, 15, false);
		daoBateau.save(bateau3);

		// navires
		Navire navire1 = new Navire(bateau3.getRobustesse(), bateau3);
		daoNavire.save(navire1);

		Navire navire2 = new Navire(bateau2.getRobustesse(), bateau1);
		daoNavire.save(navire2);

		// iles
		Ile ile1 = new Ile("Fuschia Village", true, true, true, 10, 1, Mer.EastBlue);
		daoIle.save(ile1);

		Ile ile2 = new Ile("Shells Town", false, false, true, 12, 2, Mer.EastBlue);
		daoIle.save(ile2);

		Ile ile4 = new Ile("Ile3_EastBlue", true, true, true, 8, 3, Mer.EastBlue);
		daoIle.save(ile4);

		Ile ile5 = new Ile("Ile4_EastBlue", true, true, true, 4, 4, Mer.EastBlue, true);
		daoIle.save(ile5);

		Ile ile6 = new Ile("Ile1_WestBlue", false, true, true, 12, 1, Mer.WestBlue);
		daoIle.save(ile6);

		Ile ile7 = new Ile("Ile2_WestBlue", true, false, true, 7, 2, Mer.WestBlue);
		daoIle.save(ile7);

		Ile ile8 = new Ile("Ile3_WestBlue", false, true, false, 8, 3, Mer.WestBlue);
		daoIle.save(ile8);

		Ile ile9 = new Ile("Ile4_WestBlue", false, false, false, 5, 4, Mer.WestBlue, true);
		daoIle.save(ile9);

		Ile ile3 = new Ile("Elena", false, false, true, 8, 1, Mer.NorthBlue);
		daoIle.save(ile3);

		Ile ile10 = new Ile("Ile2_NorthBlue", false, false, true, 8, 2, Mer.NorthBlue);
		daoIle.save(ile10);

		Ile ile11 = new Ile("Ile3_NorthBlue", false, false, false, 4, 3, Mer.NorthBlue);
		daoIle.save(ile11);

		Ile ile12 = new Ile("Ile4_NorthBlue", true, true, true, 8, 4, Mer.NorthBlue, true);
		daoIle.save(ile12);

		Ile ile13 = new Ile("Ile1_SouthBlue", false, true, false, 8, 1, Mer.SouthBlue);
		daoIle.save(ile13);

		Ile ile14 = new Ile("Ile2_SouthBlue", false, true, true, 8, 2, Mer.SouthBlue);
		daoIle.save(ile14);

		Ile ile15 = new Ile("Ile3_SouthBlue", true, true, false, 12, 3, Mer.SouthBlue);
		daoIle.save(ile15);

		Ile ile16 = new Ile("Ile4_SouthBlue", true, false, true, 8, 4, Mer.SouthBlue, true);
		daoIle.save(ile16);

		Ile ile17 = new Ile("Ile1_GrandLine", false, true, true, 4, 1, Mer.GrandLine);
		daoIle.save(ile17);

		Ile ile18 = new Ile("Ile2_GrandLine", true, false, false, 7, 2, Mer.GrandLine);
		daoIle.save(ile18);

		Ile ile19 = new Ile("Ile3_GrandLine", false, true, true, 8, 3, Mer.GrandLine);
		daoIle.save(ile19);

		Ile ile20 = new Ile("Ile4_GrandLine", false, false, false, 8, 4, Mer.GrandLine, true);
		daoIle.save(ile20);

		Ile ile21 = new Ile("Ile1_NewWorld", true, true, true, 8, 1, Mer.NewWorld);
		daoIle.save(ile21);

		Ile ile22 = new Ile("Ile2_NewWorld", true, false, false, 12, 2, Mer.NewWorld);
		daoIle.save(ile22);

		Ile ile23 = new Ile("Ile3_NewWorld", false, true, false, 8, 3, Mer.NewWorld);
		daoIle.save(ile23);

		Ile ile24 = new Ile("Ile4_NewWorld", false, false, true, 6, 4, Mer.NewWorld, true);
		daoIle.save(ile24);

		// events
		Evenement event1 = new Evenement(1, 2, 0, Odyssee.Tempete);
		daoEvenement.save(event1);

		Evenement event2 = new Evenement(2, 2, 25, Odyssee.Bataille);
		daoEvenement.save(event2);

		Evenement event3 = new Evenement(0, 0, 50, Odyssee.Tresor);
		daoEvenement.save(event3);

		Evenement event4 = new Evenement(2, 1, 0, Odyssee.Monstre);
		daoEvenement.save(event4);

		Evenement event5 = new Evenement(-2, 0, -5, Odyssee.Restaurant);
		daoEvenement.save(event5);

		// joueurs
		Joueur joueur1 = new Joueur("player1", "password");
		daoCompte.save(joueur1);

		Joueur joueur2 = new Joueur("player2", "password");
		daoCompte.save(joueur2);

		Joueur joueur3 = new Joueur("player3", "password");
		daoCompte.save(joueur3);

		Joueur joueur4 = new Joueur("player4", "password");
		daoCompte.save(joueur4);

		Joueur joueur5 = new Joueur("player5", "password");
		daoCompte.save(joueur5);

		// actions
		// les actions sont save après partie
		Action action1 = new Action(event1.getDegatNavire(), event1.getDegatMembre(), event1.getTresor(), event1);
		Action action2 = new Action(event2.getDegatNavire(), event2.getDegatMembre(), event2.getTresor(), event2);
		Action action3 = new Action(event3.getDegatNavire(), event3.getDegatMembre(), event3.getTresor(), event3);
		List<Action> actionsPartie1 = new ArrayList<Action>();
		Collections.addAll(actionsPartie1, action1, action2);
		List<Action> actionsPartie2 = new ArrayList<Action>();
		Collections.addAll(actionsPartie2, action3);

		// parties
		Partie partie1 = new Partie(LocalDate.of(2023, 10, 10), true, 25, 57, equipage1, ile15, navire2, joueur5,
				actionsPartie1, 0);
		daoPartie.save(partie1);
		membre1.setPartie(partie1);
		daoMembre.save(membre1);
		membre2.setPartie(partie1);
		daoMembre.save(membre2);
		membre3.setPartie(partie1);
		daoMembre.save(membre3);
		action1.setPartie(partie1);
		daoAction.save(action1);
		action2.setPartie(partie1);
		daoAction.save(action2);

		Partie partie2 = new Partie(LocalDate.of(2023, 10, 10), false, 38, 68, equipage2, ile20, navire1, joueur5,
				actionsPartie2, 8);
		daoPartie.save(partie2);
		membre4.setPartie(partie2);
		daoMembre.save(membre4);
		membre5.setPartie(partie2);
		daoMembre.save(membre5);
		membre6.setPartie(partie2);
		daoMembre.save(membre6);
		action3.setPartie(partie2);
		daoAction.save(action3);

	}
}
