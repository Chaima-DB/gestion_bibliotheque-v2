-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 01 avr. 2020 à 16:29
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bibliotheque`
--

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ref` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `fournisseur` bigint(20) DEFAULT NULL,
  `bibliotheque` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrtr6slytyko9ayila5b31rq8f` (`bibliotheque`),
  KEY `FKkfykf34ybkhip50cm47u6ymwf` (`fournisseur`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id`, `ref`, `total`, `fournisseur`, `bibliotheque`) VALUES
(1, 'achat1', 1200, 1, 1),
(2, 'achat2', 1200, 1, 1),
(3, 'achat3', 1200, 1, 1),
(4, 'achat4', 1200, 1, 1),
(5, 'achat5', 100300, 1, 2),
(6, 'achat6', 100300, 1, 2),
(7, 'achat7', 100300, 1, 2),
(8, 'achat8', 100300, 1, 2),
(9, 'achat9', 100300, 1, 2),
(10, 'achat10', 300, 1, 2),
(11, 'achat11', 300, 1, 1),
(12, 'achat12', 300, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `achat_detail`
--

DROP TABLE IF EXISTS `achat_detail`;
CREATE TABLE IF NOT EXISTS `achat_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prix_unitaire` double NOT NULL,
  `qte` double NOT NULL,
  `achat` bigint(20) DEFAULT NULL,
  `livre` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6myuj8uen501ade0ftn9vc8k8` (`achat`),
  KEY `FK6ntvres59mj8q6tsm5cg01ffr` (`livre`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `achat_detail`
--

INSERT INTO `achat_detail` (`id`, `prix_unitaire`, `qte`, `achat`, `livre`) VALUES
(1, 100, 30, 4, 1),
(2, 100, 30, 5, 1),
(3, 100, 1000, 5, 2),
(4, 100, 30, 6, 1),
(5, 100, 1000, 6, 2),
(6, 100, 30, 8, 1),
(7, 100, 1000, 8, 2),
(8, 100, 30, 9, 3),
(9, 100, 1000, 9, 2),
(10, 100, 30, 10, 3),
(11, 100, 20, 11, 3),
(12, 100, 80, 11, 2),
(13, 100, 20, 12, 1),
(14, 100, 80, 12, 2);

-- --------------------------------------------------------

--
-- Structure de la table `adherent`
--

DROP TABLE IF EXISTS `adherent`;
CREATE TABLE IF NOT EXISTS `adherent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_photo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `type_adherent` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrm81xmchv6c88i7ssjjlqb0w5` (`type_adherent`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `adherent`
--

INSERT INTO `adherent` (`id`, `cin`, `date_inscription`, `email`, `login`, `nom`, `nom_photo`, `password`, `prenom`, `tel`, `type_adherent`) VALUES
(1, 'EE1', NULL, NULL, NULL, 'nom1', NULL, NULL, 'prenom1', NULL, NULL),
(2, 'EE2', NULL, NULL, NULL, 'nom2', NULL, NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_contrat` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nom_photo` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_c0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `agent`
--

DROP TABLE IF EXISTS `agent`;
CREATE TABLE IF NOT EXISTS `agent` (
  `id` bigint(20) NOT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `bibliotheque` bigint(20) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl3s11abvuio45b7ffhxf0h2q5` (`bibliotheque`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `bibliotheque`
--

DROP TABLE IF EXISTS `bibliotheque`;
CREATE TABLE IF NOT EXISTS `bibliotheque` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bibliotheque`
--

INSERT INTO `bibliotheque` (`id`, `adresse`, `libelle`, `nom`, `ref`) VALUES
(1, 'adress1', NULL, 'North Bibliothèque', 'biblio1'),
(2, 'adress2', NULL, 'Ouest Bibliothèque', 'biblio2');

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_emprunt` date DEFAULT NULL,
  `ref` varchar(255) DEFAULT NULL,
  `adherent` bigint(20) DEFAULT NULL,
  `bibliotheque` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl97vo8tjcwra3pmfy6qj5esgt` (`adherent`),
  KEY `FKpexlb7l1p6bfjp2xuepg6x8yl` (`bibliotheque`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt`
--

INSERT INTO `emprunt` (`id`, `date_emprunt`, `ref`, `adherent`, `bibliotheque`) VALUES
(6, '2020-03-23', 'emp7', 1, 2),
(7, '2020-03-23', 'emp8', 2, 2),
(8, '2020-03-23', 'emp9', 1, 1),
(9, '2020-03-23', 'emp1', 1, 1),
(10, '2020-03-23', 'emp2', 1, 1),
(11, '2020-03-23', 'emp3', 1, 1),
(12, '2020-03-23', 'emp4', 1, 1),
(13, '2020-03-23', 'emp20', 1, 1),
(14, '2020-03-23', 'emp21', 1, 1),
(15, '2020-03-23', 'emp12', 1, 1),
(16, '2020-03-23', 'emp13', 1, 1),
(17, '2020-03-23', 'emp14', 1, 1),
(18, '2020-03-25', 'emp16', 1, 1),
(19, '2020-03-25', 'emp22', 1, 1),
(20, '2020-03-25', 'emp23', 1, 1),
(21, '2020-03-25', 'emp24', 1, 1),
(22, '2020-03-25', 'emp26', 1, 1),
(23, '2020-03-25', 'emp40', 1, 1),
(24, '2020-03-25', 'emp41', 1, 1),
(25, '2020-03-25', 'emp42', 1, 1),
(26, '2020-03-25', 'emp43', 1, 1),
(27, '2020-03-25', 'emp44', 1, 2),
(28, '2020-03-25', 'emp45', 1, 2),
(29, '2020-03-25', 'emp46', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `emprunt_detail`
--

DROP TABLE IF EXISTS `emprunt_detail`;
CREATE TABLE IF NOT EXISTS `emprunt_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_retour_effective` date DEFAULT NULL,
  `date_retour_prevu` date DEFAULT NULL,
  `emprunt` bigint(20) DEFAULT NULL,
  `livre` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK258ms5h1fk7iqydwek507o5gg` (`emprunt`),
  KEY `FKmue16nn8bj26dew02i6nrgc1x` (`livre`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `emprunt_detail`
--

INSERT INTO `emprunt_detail` (`id`, `date_retour_effective`, `date_retour_prevu`, `emprunt`, `livre`) VALUES
(1, NULL, NULL, 18, 2),
(2, NULL, NULL, 18, 1),
(3, NULL, '2020-04-14', 24, 1),
(4, NULL, NULL, 24, 3),
(5, NULL, '2020-04-14', 25, 1),
(6, NULL, NULL, 25, 3),
(7, NULL, '2020-04-14', 26, 1),
(8, NULL, '2020-04-12', 27, 3),
(9, NULL, '2020-04-12', 28, 3),
(10, NULL, '2020-04-14', 28, 1),
(11, NULL, '2020-04-01', 29, 2),
(12, NULL, '2020-04-14', 29, 1);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `adresse`, `cin`, `email`, `nom`, `prenom`) VALUES
(1, NULL, 'FF1', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(38),
(38),
(38);

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auteur` varchar(255) DEFAULT NULL,
  `date_edition` date DEFAULT NULL,
  `disponible` int(11) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `nbr_jour_emprunt` int(11) NOT NULL,
  `nbr_page` bigint(20) NOT NULL,
  `nom_photo` varchar(255) DEFAULT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `tome` varchar(255) DEFAULT NULL,
  `categorie` bigint(20) DEFAULT NULL,
  `theme` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdovufn5jal0ylqs7859sqp90k` (`categorie`),
  KEY `FK6wht3imrwp5cyqr44kv5eup76` (`theme`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livre`
--

INSERT INTO `livre` (`id`, `auteur`, `date_edition`, `disponible`, `isbn`, `nbr_jour_emprunt`, `nbr_page`, `nom_photo`, `resume`, `titre`, `tome`, `categorie`, `theme`) VALUES
(1, 'auteur1', NULL, 0, 'isbn-1', 20, 20, 'photo1', 'resume1', 'titre-1', 'tome1', NULL, NULL),
(2, 'auteur1', NULL, 0, 'isbn-2', 7, 100, 'photo2', 'resume2', 'titre-2', 'tome1', NULL, NULL),
(3, 'auteur2', '1987-12-15', 0, 'isbn-3', 18, 100, 'photo3', 'resume3', 'titre-3', 'tome2', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adherent` tinyblob,
  `annuler_reservation` datetime DEFAULT NULL,
  `code_reservation` varchar(255) DEFAULT NULL,
  `date_demande_reservation` datetime DEFAULT NULL,
  `date_reservation` datetime DEFAULT NULL,
  `fine_reservation` datetime DEFAULT NULL,
  `livre` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKryvib60qt4n4ondnuat8ca9if` (`livre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` bigint(20) NOT NULL,
  `qte_disponible` int(11) NOT NULL,
  `qte_loue` int(11) NOT NULL,
  `bibliotheque` bigint(20) NOT NULL,
  `qte_achete` int(11) NOT NULL,
  `livre` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK30mvfatcmc75otknjh3u49m6j` (`bibliotheque`),
  KEY `FKejledkmj1uhqtlxiqpdyefmun` (`livre`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`id`, `qte_disponible`, `qte_loue`, `bibliotheque`, `qte_achete`, `livre`) VALUES
(30, 216, 4, 1, 220, 1),
(29, 118, 2, 2, 120, 3),
(34, 29, 1, 2, 60, 1),
(35, 1000, 0, 2, 3000, 2),
(37, 159, 1, 1, 160, 2);

-- --------------------------------------------------------

--
-- Structure de la table `theme`
--

DROP TABLE IF EXISTS `theme`;
CREATE TABLE IF NOT EXISTS `theme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type_adherent`
--

DROP TABLE IF EXISTS `type_adherent`;
CREATE TABLE IF NOT EXISTS `type_adherent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `profession` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `type_adherent`
--

INSERT INTO `type_adherent` (`id`, `profession`) VALUES
(1, 'professeur'),
(2, 'etudiant');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
