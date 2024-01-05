package UnePiece;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

		Pirate capitaine2 = new Pirate(18, 30, 40, true, true, "Moria");
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

		Pirate capitaine10 = new Pirate(80,80,80, true, true, "BarbeBlanche");
		daoPirate.save(capitaine10);

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

		Bateau bateau2 = new Bateau("Moyenne barque", 3, 4, 5, true);
		daoBateau.save(bateau2);
		
		Bateau bateau3 = new Bateau("Grande barque", 4, 6, 10, true);
		daoBateau.save(bateau3);
		
		Bateau bateau4 = new Bateau("Petit voilier", 5, 8, 12, true);
		daoBateau.save(bateau4);
		
		Bateau bateau5 = new Bateau("Moyen voilier", 6, 10, 14, true);
		daoBateau.save(bateau5);
		
		Bateau bateau6 = new Bateau("Grand voilier", 7, 12, 16, false);
		daoBateau.save(bateau6);
		
		Bateau bateau7 = new Bateau("Vogue Merry", 7, 25, 30, false);
		daoBateau.save(bateau7);

		Bateau bateau8 = new Bateau("Thousand Sunny", 10, 50, 50, false);
		daoBateau.save(bateau8);

		// navires
		Navire navire1 = new Navire(bateau3.getRobustesse(), bateau3);
		daoNavire.save(navire1);

		Navire navire2 = new Navire(bateau2.getRobustesse(), bateau1);
		daoNavire.save(navire2);

		// iles
		Ile ile1 = new Ile("Fuschia Village", true, true, true, 5, 1, Mer.EastBlue);
		daoIle.save(ile1);

		Ile ile2a = new Ile("Shells Town", true, false, false, 9, 2, Mer.EastBlue);
		daoIle.save(ile2a);
		Ile ile2b = new Ile("Village Syrup", false, false, true, 8, 2, Mer.EastBlue);
		daoIle.save(ile2b);

		Ile ile3a = new Ile("Village Shimotsuki", true, true, false, 8, 3, Mer.EastBlue);
		daoIle.save(ile3a);
		Ile ile3b = new Ile("Royaume d'Oykot", true, false, true, 10, 3, Mer.EastBlue);
		daoIle.save(ile3b);
		
		Ile ile4 = new Ile("Ile des animaux rares", false, false, false, 4, 4, Mer.EastBlue);
		daoIle.save(ile4);

		Ile ile5a = new Ile("Loguetown", false, true, true, 7, 5, Mer.EastBlue, true);
		daoIle.save(ile5a);
		Ile ile5b = new Ile("Village Kokoyashi", true, false, true, 6, 5, Mer.EastBlue);
		daoIle.save(ile5b);
		
		Ile ile6 = new Ile("Arlong Park", true, true, false, 2, 6, Mer.EastBlue, true);
		daoIle.save(ile6);

		
		Ile ile7a = new Ile("Pays de Ka", false, true, true, 10, 1, Mer.WestBlue);
		daoIle.save(ile7a);
		Ile ile7b = new Ile("Pays de Ji", true, false, true, 12, 1, Mer.WestBlue);
		daoIle.save(ile7b);

		Ile ile8a = new Ile("Pays des fleurs", true, false, false, 7, 2, Mer.WestBlue);
		daoIle.save(ile8a);
		Ile ile8b = new Ile("Ile de Toroa", false, true, false, 6, 2, Mer.WestBlue);
		daoIle.save(ile8b);

		Ile ile9a = new Ile("Royaume de l'Illisia", false, true, false, 8, 3, Mer.WestBlue);
		daoIle.save(ile9a);
		Ile ile9b = new Ile("Royaume de Ballywood", false, false, true, 7, 3, Mer.WestBlue);
		daoIle.save(ile9b);

		Ile ile10a = new Ile("Ohara", true, false, false, 5, 4, Mer.WestBlue, true);
		daoIle.save(ile10a);
		Ile ile10b = new Ile("God Valley", false, false, true, 5, 4, Mer.WestBlue, true);
		daoIle.save(ile10b);
		

		Ile ile11a = new Ile("Royaume de Luvneel", false, true, true, 8, 1, Mer.NorthBlue);
		daoIle.save(ile11a);
		Ile ile11b = new Ile("Spider Miles", true, false, true, 10, 1, Mer.NorthBlue);
		daoIle.save(ile11b);

		Ile ile12a = new Ile("Royaume de Flevance", true, true, false, 8, 2, Mer.NorthBlue);
		daoIle.save(ile12a);
		Ile ile12b = new Ile("Ile de Swallow", true, false, false, 7, 2, Mer.NorthBlue);
		daoIle.save(ile12b);

		Ile ile13a = new Ile("Ile de Minion", false, false, false, 2, 3, Mer.NorthBlue);
		daoIle.save(ile13a);
		Ile ile13b = new Ile("Ile de Rubeck", false, false, true, 4, 3, Mer.NorthBlue);
		daoIle.save(ile13b);

		Ile ile14a = new Ile("Notice", true, true, false, 5, 4, Mer.NorthBlue, true);
		daoIle.save(ile14a);
		Ile ile14b = new Ile("Royaume de Germa", true, true, true, 8, 4, Mer.NorthBlue, true);
		daoIle.save(ile14b);
		

		Ile ile15 = new Ile("Royaume de Briss", false, true, false, 7, 1, Mer.SouthBlue);
		daoIle.save(ile15);

		Ile ile16a = new Ile("Royaume Dezoizo", false, true, true, 8, 2, Mer.SouthBlue);
		daoIle.save(ile16a);
		Ile ile16b = new Ile("Batterilla", true, false, true, 9, 2, Mer.SouthBlue);
		daoIle.save(ile16b);

		Ile ile17a = new Ile("Ile de Karate", true, true, false, 10, 3, Mer.SouthBlue);
		daoIle.save(ile17a);
		Ile ile17b = new Ile("Saint Reia", true, false, false, 9, 3, Mer.SouthBlue);
		daoIle.save(ile17b);

		Ile ile18 = new Ile("Royaume de Sorbet", true, true, true, 5, 4, Mer.SouthBlue, true);
		daoIle.save(ile18);
		

		Ile ile19 = new Ile("Cap des Jumaeaux", false, true, true, 4, 1, Mer.GrandLine);
		daoIle.save(ile19);

		Ile ile20a = new Ile("Royaume de Drum", true, false, false, 7, 2, Mer.GrandLine);
		daoIle.save(ile20a);
		Ile ile20b = new Ile("Banaro", true, true, false, 9, 2, Mer.GrandLine);
		daoIle.save(ile20b);
		Ile ile20c = new Ile("Whiskey Peak", false, true, false, 6, 2, Mer.GrandLine);
		daoIle.save(ile20c);
		Ile ile20d = new Ile("Gare de Shift", false, false, true, 11, 2, Mer.GrandLine, true);
		daoIle.save(ile20d);

		Ile ile21a = new Ile("Baltigo", true, false, true, 8, 3, Mer.GrandLine);
		daoIle.save(ile21a);
		Ile ile21b = new Ile("Water 7", false, true, true, 7, 3, Mer.GrandLine);
		daoIle.save(ile21b);
		Ile ile21c = new Ile("Long Ring Long Land", false, false, false, 2, 3, Mer.GrandLine);
		daoIle.save(ile21c);

		Ile ile22a = new Ile("Balgimoa", false, false, true, 5, 4, Mer.GrandLine, true);
		daoIle.save(ile22a);
		Ile ile22b = new Ile("Enies Loby", false, true, true, 8, 4, Mer.GrandLine);
		daoIle.save(ile22b);
		Ile ile22c = new Ile("Ile de Kuraigama", true, true, false, 7, 4, Mer.GrandLine, true);
		daoIle.save(ile22c);
		Ile ile22d = new Ile("Kedetrav", true, false, false, 6, 4, Mer.GrandLine, true);
		daoIle.save(ile22d);
		
		Ile ile23a = new Ile("Marine Ford", true, false, true, 8, 5, Mer.GrandLine);
		daoIle.save(ile23a);
		Ile ile23b = new Ile("Impel Down", true, true, false, 7, 5, Mer.GrandLine, true);
		daoIle.save(ile23b);

		Ile ile24 = new Ile("Archipel de Sabaody", true, false, true, 4, 6, Mer.GrandLine, true);
		daoIle.save(ile24);
		
		
		Ile ile25a = new Ile("Punk Hazard", true, true, true, 8, 1, Mer.NewWorld);
		daoIle.save(ile25a);
		Ile ile25b = new Ile("Ile de Rajin", false, true, true, 6, 1, Mer.NewWorld);
		daoIle.save(ile25b);

		Ile ile26a = new Ile("Ile de Maubeugemour", true, false, false, 5, 2, Mer.NewWorld);
		daoIle.save(ile26a);
		Ile ile26b = new Ile("End Point", false, false, true, 6, 2, Mer.NewWorld);
		daoIle.save(ile26b);
		Ile ile26c = new Ile("Piriodo Island", false, true, false, 4, 2, Mer.NewWorld);
		daoIle.save(ile26c);

		Ile ile27a = new Ile("Dressrosa", false, true, true, 8, 3, Mer.NewWorld);
		daoIle.save(ile27a);
		Ile ile27b = new Ile("Green Bit", false, true, false, 7, 3, Mer.NewWorld);
		daoIle.save(ile27b);
		
		Ile ile28a = new Ile("Ile des Pirates", true, true, true, 12, 4, Mer.NewWorld);
		daoIle.save(ile28a);
		Ile ile28b = new Ile("Pays de Wa", true, true, false, 9, 4, Mer.NewWorld);
		daoIle.save(ile28b);
		Ile ile28c = new Ile("Royaume de Prodence", false, true, true, 10, 4, Mer.NewWorld);
		daoIle.save(ile28c);
		
		Ile ile29a = new Ile("Elbaf", true, true, false, 8, 5, Mer.NewWorld);
		daoIle.save(ile29a);
		Ile ile29b = new Ile("Onigashima", false, true, true, 9, 5, Mer.NewWorld);
		daoIle.save(ile29b);

		Ile ile30 = new Ile("Laugh Tale", true, true, true, 10, 6, Mer.NewWorld, true);
		daoIle.save(ile30);

		// events
		Evenement event1a = new Evenement(1, 1, 0, Odyssee.Tempete);
		daoEvenement.save(event1a);
		Evenement event1b = new Evenement(2, 1, 0, Odyssee.Tempete);
		daoEvenement.save(event1b);
		Evenement event1c = new Evenement(3, 1, -5, Odyssee.Tempete);
		daoEvenement.save(event1c);

		Evenement event2a = new Evenement(1, 1, 50, Odyssee.Bataille);
		daoEvenement.save(event2a);
		Evenement event2b = new Evenement(2, 2, 25, Odyssee.Bataille);
		daoEvenement.save(event2b);
		Evenement event2c = new Evenement(2, 5, -50, Odyssee.Bataille);
		daoEvenement.save(event2c);

		Evenement event3a = new Evenement(0, -5, 50, Odyssee.Tresor);
		daoEvenement.save(event3a);
		Evenement event3b = new Evenement(0, 0, 20, Odyssee.Tresor);
		daoEvenement.save(event3b);
		Evenement event3c = new Evenement(0, 1, -5, Odyssee.Tresor);
		daoEvenement.save(event3c);

		Evenement event4a = new Evenement(1, 2, 0, Odyssee.Monstre);
		daoEvenement.save(event4a);
		Evenement event4b = new Evenement(2, 3, 0, Odyssee.Monstre);
		daoEvenement.save(event4b);
		Evenement event4c = new Evenement(5, 4, -5, Odyssee.Monstre);
		daoEvenement.save(event4c);

		Evenement event5a = new Evenement(0,-10,-10, Odyssee.Restaurant);
		daoEvenement.save(event5a);
		Evenement event5b = new Evenement(0,-5,-15, Odyssee.Restaurant);
		daoEvenement.save(event5b);
		Evenement event5c = new Evenement(0,-2,-25, Odyssee.Restaurant);
		daoEvenement.save(event5c);

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

		/*
		// actions
		// les actions sont save après partie
		Action action1 = new Action(event1.getDegatNavire(), event1.getDegatMembre(), event1.getTresor(), event1);
		Action action2 = new Action(event2.getDegatNavire(), event2.getDegatMembre(), event2.getTresor(), event2);
		Action action3 = new Action(event3.getDegatNavire(), event3.getDegatMembre(), event3.getTresor(), event3);
		Set<Action> actionsPartie1 = new HashSet<Action>();
		Collections.addAll(actionsPartie1, action1, action2);
		Set<Action> actionsPartie2 = new HashSet<Action>();
		Collections.addAll(actionsPartie2, action3);
		*/

		// parties
		Partie partie1 = new Partie(LocalDate.of(2023, 10, 10), true, 25, 57, equipage1, ile15, navire2, joueur5,
				actionsPartie1, 0);
		daoPartie.save(partie1);
		//	 save membres avec partie
		membre1.setPartie(partie1);
		daoMembre.save(membre1);
		membre2.setPartie(partie1);
		daoMembre.save(membre2);
		membre3.setPartie(partie1);
		daoMembre.save(membre3);
		//	 save actions avec partie
		action1.setPartie(partie1);
		daoAction.save(action1);
		action2.setPartie(partie1);
		daoAction.save(action2);
		
		Partie partie2 = new Partie(LocalDate.of(2023, 10, 10), false, 38, 68, equipage2, ile24, navire1, joueur5,
				actionsPartie2, 8);
		daoPartie.save(partie2);
		//	save membres avec partie
		membre4.setPartie(partie2);
		daoMembre.save(membre4);
		membre5.setPartie(partie2);
		daoMembre.save(membre5);
		membre6.setPartie(partie2);
		daoMembre.save(membre6);
		// 	save actions avec partie
		action3.setPartie(partie2);
		daoAction.save(action3);

	}
}
