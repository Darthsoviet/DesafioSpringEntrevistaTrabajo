-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: challenge
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `challenge`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `challenge` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `challenge`;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` double NOT NULL,
  `description` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id_UNIQUE` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,1.2,'test','2020-01-11',1),(2,1.2,'test','2020-01-12',1),(3,1.2,'test','2020-01-12',1),(4,1.2,'test','2020-01-12',1),(5,1.2,'test','2020-01-12',1),(6,1.2,'test','2020-01-12',1),(7,1.2,'test','2020-01-12',1),(8,1.2,'test','2020-01-12',1),(9,1.2,'test','2020-01-12',1),(10,1.2,'test','2020-01-12',1),(11,1.2,'test','2020-01-12',1),(12,1.2,'test','2020-01-13',1),(13,1.2,'test','2020-01-12',1),(14,1.2,'test','2020-01-12',1),(15,1.2,'test','2020-01-12',1),(16,1.2,'test','2020-01-13',1),(17,1.2,'test','2020-01-13',1),(18,1.2,'test','2020-01-12',1),(19,1.2,'test','2020-01-13',1),(20,1.2,'test','2020-01-01',1),(21,1.2,'test','2020-01-01',1),(22,1.2,'test','2020-01-01',1),(23,1.2,'test','2019-12-31',1),(24,1.2,'test','2019-12-31',1),(25,1.2,'test','2019-12-31',1),(26,1.2,'test','2019-12-31',1),(27,1.2,'test','2019-12-31',1),(28,1.2,'test','2019-12-31',1),(29,1.2,'test','2020-01-01',1),(30,1.2,'test','2020-01-01',1),(31,1.2,'test','2020-01-01',1),(32,1.2,'test','2020-01-01',1),(33,1.2,'test','2020-01-01',1),(34,1.2,'test','2020-01-01',1),(35,1.2,'test','2020-01-01',1),(36,1.2,'test','2020-01-01',1),(37,1.2,'test','2020-01-01',1),(38,1.2,'test','2020-01-01',1),(39,1.2,'test','2020-01-01',1),(40,1.2,'test','2020-01-01',1),(41,1.2,'test','2020-01-01',1),(42,1.2,'test','2020-01-01',1),(43,1.2,'test','2020-01-01',1),(44,1.2,'test','2020-01-01',1),(45,1.2,'test','2020-01-01',1),(46,1.7,'test','2020-01-01',1),(47,1.7,'test','2020-01-01',20),(48,1.7,'test','2020-01-01',20),(49,1.7,'test','2018-01-01',1),(50,1.7,'test','2018-01-01',1),(51,1.7,'test','2018-01-02',1),(52,1.7,'test','2020-01-13',1),(53,1.7,'test','2020-01-13',1),(54,1.7,'test','2020-01-13',1),(55,100,'test','2020-01-13',1),(56,100,'test','2020-01-16',1),(57,100,'test','2020-01-25',1),(58,100,'test','2020-01-25',1),(59,120,'test','2020-01-25',1),(60,120,'test','2020-02-25',1),(61,5,'test','2019-11-09',123),(62,5,'test','2019-11-10',123),(65,20,'test','2019-11-16',123),(66,25,'test','2019-11-24',123),(67,25,'test','2019-11-24',123),(68,25,'test','2019-11-25',123),(69,25,'test','2019-11-28',123),(70,25,'test','2019-11-29',123),(72,5,'test','2019-11-30',123),(73,20,'test','2019-12-01',123),(74,20,'test','2019-12-01',123),(75,20,'test','2019-12-01',123),(76,20,'test','2019-12-01',123),(77,20,'test','2019-12-01',123),(78,20,'test','2019-12-01',123),(79,33,'test','2019-12-08',123),(80,33,'test','2019-12-08',123),(81,34,'test','2019-12-08',123),(82,20,'test','2019-11-29',123),(83,100,'test','2020-06-26',3),(84,20,'test','2019-11-29',123),(85,40,'test','2020-06-25',3),(86,500,'test 2','2020-06-30',3),(87,699,'test3 ','2020-07-11',3),(88,300,'ff','2020-06-08',2),(89,666,'test4','2020-06-25',3),(90,20,'test big textttttttttttttttttttttttttttttttttttt','2019-11-29',123),(91,20,'test big textttttttttttttttttttttttttttttttttttt','2019-11-29',1),(92,0.1,'r','2020-06-30',3),(93,10,'test','2020-06-23',4);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 18:54:48
