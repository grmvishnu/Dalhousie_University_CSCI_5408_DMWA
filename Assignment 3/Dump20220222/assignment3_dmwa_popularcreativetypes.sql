-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment3_dmwa
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `popularcreativetypes`
--

DROP TABLE IF EXISTS `popularcreativetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `popularcreativetypes` (
  `RANK` int DEFAULT NULL,
  `CREATIVE TYPES` varchar(100) NOT NULL,
  `MOVIES` int DEFAULT NULL,
  `TOTAL GROSS` bigint DEFAULT NULL,
  `AVERAGE GROSS` bigint DEFAULT NULL,
  `MARKET SHARE` double DEFAULT NULL,
  PRIMARY KEY (`CREATIVE TYPES`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `popularcreativetypes`
--

LOCK TABLES `popularcreativetypes` WRITE;
/*!40000 ALTER TABLE `popularcreativetypes` DISABLE KEYS */;
INSERT INTO `popularcreativetypes` VALUES (1,'Contemporary Fiction',7442,96203727036,12927133,40.46),(7,'Dramatization',1175,15715191699,13374631,6.61),(8,'Factual',2467,2960327207,1199970,1.25),(4,'Fantasy',759,21724062575,28621953,9.14),(6,'Historical Fiction',1487,18521260744,12455454,7.79),(2,'Kids Fiction',564,32035539746,56800602,13.47),(9,'Multiple Creative Types',42,117574526,2799393,0.05),(3,'Science Fiction',724,29922660857,41329642,12.59),(5,'Super Hero',129,20273157911,157156263,8.53);
/*!40000 ALTER TABLE `popularcreativetypes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 13:20:40
