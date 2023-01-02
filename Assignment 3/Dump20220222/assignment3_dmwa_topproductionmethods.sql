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
-- Table structure for table `topproductionmethods`
--

DROP TABLE IF EXISTS `topproductionmethods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topproductionmethods` (
  `RANK` int DEFAULT NULL,
  `PRODUCTION METHODS` varchar(100) NOT NULL,
  `MOVIES` int DEFAULT NULL,
  `TOTAL GROSS` bigint DEFAULT NULL,
  `AVERAGE GROSS` bigint DEFAULT NULL,
  `MARKET SHARE` double DEFAULT NULL,
  PRIMARY KEY (`PRODUCTION METHODS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topproductionmethods`
--

LOCK TABLES `topproductionmethods` WRITE;
/*!40000 ALTER TABLE `topproductionmethods` DISABLE KEYS */;
INSERT INTO `topproductionmethods` VALUES (2,'Animation/Live Action',264,30346622254,114949327,12.76),(3,'Digital Animation',365,23920180508,65534741,10.06),(4,'Hand Animation',164,2960497487,18051814,1.25),(1,'Live Action',14613,179637000000,12292972,75.56),(6,'Multiple Production Methods',26,43728300,1681858,0.02),(7,'Rotoscoping',4,8468385,2117096,0),(5,'Stop-Motion Animation',37,676490120,18283517,0.28);
/*!40000 ALTER TABLE `topproductionmethods` ENABLE KEYS */;
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
