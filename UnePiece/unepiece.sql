-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 14 déc. 2023 à 22:56
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `unepiece`
--

-- --------------------------------------------------------

--
-- Structure de la table `action`
--

DROP TABLE IF EXISTS `action`;
CREATE TABLE IF NOT EXISTS `action` (
  `id` int NOT NULL AUTO_INCREMENT,
  `choix` bit(1) NOT NULL,
  `degat_membre` int DEFAULT NULL,
  `degat_navire` int DEFAULT NULL,
  `tresors` int NOT NULL,
  `id_event` int NOT NULL,
  `partie` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s27338m18ub7c6d0hbkvia92l` (`id_event`),
  KEY `FKbr9cbouk25niio2r6cq25vw1j` (`partie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `bateau`
--

DROP TABLE IF EXISTS `bateau`;
CREATE TABLE IF NOT EXISTS `bateau` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capacite` int NOT NULL,
  `debut` bit(1) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` int NOT NULL,
  `robustesse` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `bateau`
--

INSERT INTO `bateau` (`id`, `capacite`, `debut`, `nom`, `prix`, `robustesse`) VALUES
(1, 8, b'0', 'Batosurlo', 10, 12),
(2, 12, b'1', 'Batosurlhuile', 13, 15),
(3, 15, b'1', 'Ohedubato', 8, 10),
(4, 20, b'1', 'Kividansunananas', 3, 3);

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `dtype` varchar(31) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id` int NOT NULL AUTO_INCREMENT,
  `degat_membre` int DEFAULT NULL,
  `degat_navire` int DEFAULT NULL,
  `odyssee` enum('Bataille','Monstre','Restaurant','Tempete','Tresor') DEFAULT NULL,
  `tresor` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`id`, `degat_membre`, `degat_navire`, `odyssee`, `tresor`) VALUES
(1, 10, 20, 'Monstre', 10),
(2, 20, 30, 'Bataille', 20),
(3, 0, 0, 'Tresor', 100),
(4, 0, 0, 'Restaurant', 20),
(5, 50, 50, 'Tempete', 0);

-- --------------------------------------------------------

--
-- Structure de la table `ile`
--

DROP TABLE IF EXISTS `ile`;
CREATE TABLE IF NOT EXISTS `ile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `attente` int NOT NULL,
  `auberge` bit(1) NOT NULL,
  `chantier` bit(1) NOT NULL,
  `mer` tinyint DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `ordre` int NOT NULL,
  `taverne` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ;

--
-- Déchargement des données de la table `ile`
--

INSERT INTO `ile` (`id`, `attente`, `auberge`, `chantier`, `mer`, `nom`, `ordre`, `taverne`) VALUES
(1, 10, b'1', b'1', 0, 'Dawn', 3, b'1'),
(2, 20, b'0', b'1', 5, 'Laugh Tale', 8, b'1'),
(3, 13, b'1', b'1', 3, 'Dézoizo', 4, b'0'),
(4, 25, b'1', b'1', 4, 'Alabasta', 6, b'1');

-- --------------------------------------------------------

--
-- Structure de la table `membre`
--

DROP TABLE IF EXISTS `membre`;
CREATE TABLE IF NOT EXISTS `membre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `power` int NOT NULL,
  `pv` int NOT NULL,
  `partie` int NOT NULL,
  `id_pirate` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_10qew2bgr7hdgkrlqp5ofmclc` (`id_pirate`),
  KEY `FKc6sxiajgpk4wsih7wrgq5r6ex` (`partie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `navire`
--

DROP TABLE IF EXISTS `navire`;
CREATE TABLE IF NOT EXISTS `navire` (
  `id` int NOT NULL AUTO_INCREMENT,
  `robustesse` int NOT NULL,
  `id_bateau` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3qj733h1sxundt9an33uxs6ju` (`id_bateau`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `navire`
--

INSERT INTO `navire` (`id`, `robustesse`, `id_bateau`) VALUES
(3, 12, 1),
(4, 15, 3);

-- --------------------------------------------------------

--
-- Structure de la table `partie`
--

DROP TABLE IF EXISTS `partie`;
CREATE TABLE IF NOT EXISTS `partie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_debut` date DEFAULT NULL,
  `duree` int NOT NULL,
  `termine` bit(1) NOT NULL,
  `tresor` int NOT NULL,
  `id_ile` int DEFAULT NULL,
  `id_joueur` int DEFAULT NULL,
  `id_navire` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_nrstqosuaqmhwtrdevm6yuymg` (`id_ile`),
  UNIQUE KEY `UK_gbmr2umrpkq751c1svycftmgn` (`id_joueur`),
  UNIQUE KEY `UK_qrypk7te082xmpm141awtn63p` (`id_navire`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `pirate`
--

DROP TABLE IF EXISTS `pirate`;
CREATE TABLE IF NOT EXISTS `pirate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `capitaine` bit(1) NOT NULL,
  `fruit` bit(1) NOT NULL,
  `power` int NOT NULL,
  `prime` int NOT NULL,
  `pv` int NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `pirate`
--

INSERT INTO `pirate` (`id`, `capitaine`, `fruit`, `power`, `prime`, `pv`, `nom`) VALUES
(4, b'1', b'1', 15, 20, 15, 'Luffy'),
(5, b'0', b'0', 12, 15, 12, 'Zorro'),
(6, b'1', b'0', 18, 15, 18, 'Nefertari Vivi'),
(7, b'0', b'0', 13, 13, 20, 'Gaimon'),
(8, b'0', b'0', 4, 8, 8, 'Laboon');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `action`
--
ALTER TABLE `action`
  ADD CONSTRAINT `FK6i2apmcjrqnuwjqga94tu9aau` FOREIGN KEY (`id_event`) REFERENCES `evenement` (`id`),
  ADD CONSTRAINT `FKbr9cbouk25niio2r6cq25vw1j` FOREIGN KEY (`partie`) REFERENCES `partie` (`id`);

--
-- Contraintes pour la table `membre`
--
ALTER TABLE `membre`
  ADD CONSTRAINT `FKc6sxiajgpk4wsih7wrgq5r6ex` FOREIGN KEY (`partie`) REFERENCES `partie` (`id`),
  ADD CONSTRAINT `FKiu5t8d09otxe65fkvaqsw7wmo` FOREIGN KEY (`id_pirate`) REFERENCES `pirate` (`id`);

--
-- Contraintes pour la table `navire`
--
ALTER TABLE `navire`
  ADD CONSTRAINT `FK15tnnjtxqfmgvt09c0auw37jp` FOREIGN KEY (`id_bateau`) REFERENCES `bateau` (`id`);

--
-- Contraintes pour la table `partie`
--
ALTER TABLE `partie`
  ADD CONSTRAINT `FK3g5oit5796h5yu9i2eonk2f59` FOREIGN KEY (`id_ile`) REFERENCES `ile` (`id`),
  ADD CONSTRAINT `FKh7pyim6ww1obhwaq1yvfhsade` FOREIGN KEY (`id_navire`) REFERENCES `navire` (`id`),
  ADD CONSTRAINT `FKratkp75k89y14stjx2mbsvjf9` FOREIGN KEY (`id_joueur`) REFERENCES `compte` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
