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
-- Table structure for table `topgrossingsources`
--

DROP TABLE IF EXISTS `topgrossingsources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topgrossingsources` (
  `RANK` int DEFAULT NULL,
  `SOURCES` varchar(100) NOT NULL,
  `MOVIES` int DEFAULT NULL,
  `TOTAL GROSS` bigint DEFAULT NULL,
  `AVERAGE GROSS` bigint DEFAULT NULL,
  `MARKET SHARE` double DEFAULT NULL,
  PRIMARY KEY (`SOURCES`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topgrossingsources`
--

LOCK TABLES `topgrossingsources` WRITE;
/*!40000 ALTER TABLE `topgrossingsources` DISABLE KEYS */;
INSERT INTO `topgrossingsources` VALUES (3,'Based on Comic/Graphic Novel',249,23369989130,93855378,9.83),(7,'Based on Factual Book/Article',295,7443681990,25232820,3.13),(2,'Based on Fiction Book/Short Story',2150,47005613207,21863076,19.77),(9,'Based on Folk Tale/Legend/Fairytale',78,3406118495,43668186,1.43),(10,'Based on Play',271,2111190923,7790372,0.89),(5,'Based on Real Life Events',3225,11398356297,3534374,4.79),(6,'Based on TV',231,11305006312,48939421,4.75),(1,'Original Screenplay',7946,106375000000,13387264,44.74),(4,'Remake',328,12832659970,39123963,5.4),(8,'Spin-Off',41,3833128331,93490935,1.61);
/*!40000 ALTER TABLE `topgrossingsources` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 13:20:39
