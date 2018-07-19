CREATE DATABASE  IF NOT EXISTS `scheme1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `scheme1`;
-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: scheme1
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_ssn` bigint(20) NOT NULL,
  `client_name` varchar(255) NOT NULL,
  `combo_size` varchar(255) NOT NULL,
  `dateTime` datetime DEFAULT NULL,
  `discount_code` varchar(255) DEFAULT NULL,
  `drink` varchar(255) NOT NULL,
  `french_fries` varchar(255) NOT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `sandwichComposition` varchar(255) DEFAULT NULL,
  `sandwich_name` varchar(255) NOT NULL,
  `sauce_addings` varchar(255) DEFAULT NULL,
  `total_price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (6,55546,'ClientA','ULTRA','2018-06-22 06:05:27','D20','COKEZERO','YES','DEBITCARD, CREDITCARD','A 100% beef patty seasoned with a pinch of salt and pepper, then topped with melted white cheddar, zesty barbecue ranch sauce and crispy tortilla strips, all on a classic bun','BBQMEAL','MAYONNAISE, GARLIC, ONION, PEPPERBLACK',4.41),(7,55546,'ClientA','MEDIUM','2018-06-22 06:23:55',NULL,'COKEZERO','YES','CASH',' A juicy 100% beef patty simply seasoned with a pinch of salt and pepper, melty American cheese, tangy pickles, minced onions, ketchup and mustard','CHEESEMEAL','MAYONNAISE',2.50),(8,33354,'ClientB','BIG','2018-06-22 06:26:04','D50','COKEZERO','YES','CREDITCARD','A double layer of sear-sizzled 100% pure beef mingled with special sauce on a sesame seed bun and topped with melty American cheese, crisp lettuce, minced onions and tangy pickles','BIGMEAL','GARLIC, ONION, KETCHUP, MUSTARD',2.75),(11,46587,'ClientC','SMALL','2018-06-28 19:21:15','D80','SPRITE','YES','DEBITCARD',' A juicy 100% beef patty simply seasoned with a pinch of salt and pepper, melty American cheese, tangy pickles, minced onions, ketchup and mustard','CHEESEMEAL','ONION',0.31),(12,11111,'ClientD','SMALL','2018-06-28 19:34:56',NULL,'COKEZERO','NO!','CASH',' A juicy 100% beef patty simply seasoned with a pinch of salt and pepper, melty American cheese, tangy pickles, minced onions, ketchup and mustard','CHEESEMEAL','MAYONNAISE',1.50);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-28 19:46:07
