/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.22 : Database - pcor4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pcor4` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pcor4`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) NOT NULL DEFAULT '',
  `Counter` int DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('DKPorudzbina',53);

/*Table structure for table `dkporudzbina` */

DROP TABLE IF EXISTS `dkporudzbina`;

CREATE TABLE `dkporudzbina` (
  `SifraPorudzbine` int NOT NULL,
  `Palacinka` varchar(55) DEFAULT NULL,
  `Preliv` varchar(55) DEFAULT NULL,
  `Voce` varchar(55) DEFAULT NULL,
  `SifraStola` int DEFAULT '0',
  PRIMARY KEY (`SifraPorudzbine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dkporudzbina` */

insert  into `dkporudzbina`(`SifraPorudzbine`,`Palacinka`,`Preliv`,`Voce`,`SifraStola`) values 
(52,'KLASICNA','Gold bela cokolada','sumsko voce',2),
(53,'RED VELVET','Gold bela cokolada','visnje',4);

/*Table structure for table `dksto` */

DROP TABLE IF EXISTS `dksto`;

CREATE TABLE `dksto` (
  `SifraStola` int NOT NULL DEFAULT '0',
  `NazivStola` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`SifraStola`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `dksto` */

insert  into `dksto`(`SifraStola`,`NazivStola`) values 
(1,'Sto1'),
(2,'Sto2'),
(3,'Sto3'),
(4,'Sto4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
