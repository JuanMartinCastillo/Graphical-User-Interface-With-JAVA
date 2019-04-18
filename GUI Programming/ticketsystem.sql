-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ticketsystem
CREATE DATABASE IF NOT EXISTS `ticketsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ticketsystem`;

-- Dumping structure for table ticketsystem.tech/ticket
CREATE TABLE IF NOT EXISTS `tech/ticket` (
  `id` int(11) DEFAULT NULL,
  `username` int(11) DEFAULT NULL,
  `Column 3` int(11) DEFAULT NULL,
  `Column 4` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ticketsystem.tech/ticket: ~0 rows (approximately)
DELETE FROM `tech/ticket`;
/*!40000 ALTER TABLE `tech/ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `tech/ticket` ENABLE KEYS */;

-- Dumping structure for table ticketsystem.tech_ticket
CREATE TABLE IF NOT EXISTS `tech_ticket` (
  `Tech` char(50) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  KEY `number` (`number`),
  CONSTRAINT `tech_ticket_ibfk_1` FOREIGN KEY (`number`) REFERENCES `tickets` (`number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ticketsystem.tech_ticket: ~0 rows (approximately)
DELETE FROM `tech_ticket`;
/*!40000 ALTER TABLE `tech_ticket` DISABLE KEYS */;
INSERT INTO `tech_ticket` (`Tech`, `number`, `status`) VALUES
	('John', NULL, 'Open');
/*!40000 ALTER TABLE `tech_ticket` ENABLE KEYS */;

-- Dumping structure for table ticketsystem.tickets
CREATE TABLE IF NOT EXISTS `tickets` (
  `number` int(11) NOT NULL AUTO_INCREMENT,
  `Tech` char(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `priority` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `closeDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketsystem.tickets: ~31 rows (approximately)
DELETE FROM `tickets`;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` (`number`, `Tech`, `date`, `description`, `priority`, `status`, `closeDate`) VALUES
	(5, '1', '18/01/1970', 'asd', '', 'Closed', '01/12/2017 21:42:16.000'),
	(13, 'johan', '18/01/1970', 'asd', '', 'Closed', '03/12/2017 19:19:32.000'),
	(14, 'johan', '18/01/1970', 'asdasd', '', 'Closed', '03/12/2017 19:18:47.000'),
	(15, 'ad', '01/12/2017', 'as', '', 'Closed', '03/12/2017 19:17:20.000'),
	(16, '4141', '01/12/2017', 'asda', '', 'Closed', '03/12/2017 19:17:11.000'),
	(17, 'John', '01/12/2017', 'asd', 'Urgent', 'Closed', '03/12/2017 19:16:46.000'),
	(18, 'Johan', '01/12/2017 21:58:29.000', 'data connection', 'Urgent', 'Closed', '03/12/2017 18:47:39.000'),
	(19, 'johan', '01/12/2017 22:08:42.000', 'asdasd', 'Long term', 'Closed', '03/12/2017 18:47:28.000'),
	(21, '', '03/12/2017 18:11:43.000', '', 'Long term', 'Closed', '03/12/2017 18:35:28.000'),
	(22, '', '03/12/2017 18:11:56.000', '', 'Urgent', 'Closed', '03/12/2017 18:14:14.000'),
	(23, 'johan', '03/12/2017 19:27:07.000', 'soso', 'Urgent', 'Closed', '03/12/2017 19:28:22.000'),
	(24, 'johan', '03/12/2017 19:47:50.000', 'acispd', 'Normal', 'Open', NULL),
	(25, 'johan', '03/12/2017 19:47:58.000', 'asdasd', 'Long term', 'Open', NULL),
	(26, 'johan', '03/12/2017 19:48:06.000', 'asd', 'Urgent', 'Open', NULL),
	(28, 'Johan', '10/12/2017 19:13:54.000', 'issue', 'Urgent', 'Closed', '10/12/2017 19:14:40.000'),
	(30, 'Johan', '10/12/2017 20:23:36.000', 'sdas', 'Long term', 'Open', NULL),
	(31, 'Johan', '10/12/2017 20:26:10.000', 'asas', 'Urgent', 'Open', NULL),
	(36, 'Johan', '10/12/2017 20:49:15.000', '', 'Long term', 'Closed', '29/12/2017 14:16:10.000'),
	(37, 'Johan', '10/12/2017 20:51:04.000', 'nuevo', 'Urgent', 'Open', NULL),
	(38, 'Johan', '10/12/2017 20:52:03.000', 'otro', 'Urgent', 'Open', NULL),
	(39, 'Johan', '10/12/2017 20:53:19.000', 'unoMas', 'Urgent', 'Open', NULL),
	(40, 'Johan', '10/12/2017 20:53:48.000', 'dfsd', 'Urgent', 'Open', NULL),
	(41, 'Johan', '10/12/2017 20:55:24.000', 'aver', 'Urgent', 'Open', NULL),
	(42, 'Johan,James,John', '10/12/2017 21:15:40.000', 'zzzz', 'Urgent', 'Closed', '27/12/2017 21:05:50.000'),
	(44, 'Johan', '27/12/2017 19:24:05.000', 'Johan', 'Urgent', 'Open', NULL),
	(45, 'John', '27/12/2017 20:14:09.000', 'John', 'Urgent', 'Open', NULL),
	(46, 'John', '27/12/2017 20:53:47.000', 'John', 'Long term', 'Open', NULL),
	(47, 'John', '27/12/2017 20:54:21.000', 'John', 'Long term', 'Open', NULL),
	(50, 'James', '29/12/2017 13:58:59.000', 'James', 'Normal', 'Open', NULL),
	(51, 'John', '29/12/2017 14:06:54.000', 'big ass', 'Normal', 'Closed', '29/12/2017 14:08:24.000'),
	(52, 'James', '02/01/2018 18:40:41.000', 'luggyygjhbjhbjhb', 'Long term', 'Open', NULL);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

-- Dumping structure for table ticketsystem.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- Dumping data for table ticketsystem.user: ~5 rows (approximately)
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `type`) VALUES
	(1, 'John', 'Johnpass123', 'tech'),
	(2, 'James', 'Jamespass123', 'tech'),
	(3, 'Johan', 'Johanpass123', 'tech'),
	(4, 'manager', 'manager', 'manager'),
	(5, 'admin', 'admin', 'admin'),
	(8, 'tipo', 'popo', 'manager');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
