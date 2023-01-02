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
-- Table structure for table `highestgrossers`
--

DROP TABLE IF EXISTS `highestgrossers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `highestgrossers` (
  `YEAR` int DEFAULT NULL,
  `MOVIE` varchar(100) NOT NULL,
  `GENRE` varchar(100) DEFAULT NULL,
  `MPAA RATING` varchar(100) DEFAULT NULL,
  `DISTRIBUTOR` varchar(100) DEFAULT NULL,
  `TOTAL FOR YEAR` bigint DEFAULT NULL,
  `TOTAL IN 2019 DOLLARS` bigint DEFAULT NULL,
  `TICKETS SOLD` bigint DEFAULT NULL,
  PRIMARY KEY (`MOVIE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `highestgrossers`
--

LOCK TABLES `highestgrossers` WRITE;
/*!40000 ALTER TABLE `highestgrossers` DISABLE KEYS */;
INSERT INTO `highestgrossers` VALUES (2019,'Avengers: Endgame','NaN','PG-13','Walt Disney',858373000,858373002,93708843),(2020,'Bad Boys For Life','NaN','R','Sony Pictures',204417855,204417848,22316359),(1995,'Batman Forever','Drama','PG-13','Warner Bros.',184031112,387522978,42306002),(2018,'Black Panther','Action','PG-13','Walt Disney',700059566,703901821,76845177),(2016,'Finding Dory','Action','PG','Walt Disney',486295561,514967322,56219140),(2003,'Finding Nemo','Adventure','G','Walt Disney',339714367,516050346,56337374),(2014,'Guardians of the Galaxy','Adventure','PG-13','Walt Disney',333055258,373413235,40765637),(2011,'Harry Potter and the Deathly Hallows: Part II','Action','PG-13','Warner Bros.',381011219,440108798,48046812),(2001,'Harry Potter and the Sorcerer’s Stone','Adventure','PG','Warner Bros.',300404434,486166890,53074988),(2000,'How the Grinch Stole Christmas','Adventure','PG','Universal',253367455,430583644,47006948),(1996,'Independence Day','Adventure','PG-13','20th Century Fox',306169255,634504608,69269062),(2013,'Iron Man 3','Adventure','PG-13','Walt Disney',408992272,460808016,50306552),(1997,'Men in Black','Adventure','PG-13','Sony Pictures',250650052,500207943,54607854),(2006,'Pirates of the Caribbean: Dead Man’s Chest','Action','PG-13','Walt Disney',423315812,591995851,64628368),(2021,'Shang-Chi and the Legend of the Ten Rings','NaN','PG-13','Walt Disney',224226704,224226704,24478897),(2004,'Shrek 2','Adventure','PG','Dreamworks SKG',441226247,650826473,71050925),(2002,'Spider-Man','Adventure','PG-13','Sony Pictures',403706375,636480273,69484746),(2007,'Spider-Man 3','Adventure','PG-13','Sony Pictures',336530303,448054878,48914288),(1999,'Star Wars Ep. I: The Phantom Menace','Adventure','PG','20th Century Fox',430443350,776153749,84732942),(2005,'Star Wars Ep. III: Revenge of the Sith','Action','PG-13','20th Century Fox',380270577,543413171,59324582),(2015,'Star Wars Ep. VII: The Force Awakens','Action','PG-13','Walt Disney',742208942,806480887,88043765),(2017,'Star Wars Ep. VIII: The Last Jedi','Action','PG-13','Walt Disney',517218368,528173936,57660910),(2012,'The Avengers','Adventure','PG-13','Walt Disney',623357910,717331462,78311295),(2008,'The Dark Knight','Adventure','PG-13','Warner Bros.',531001578,677433772,73955652),(1998,'Titanic','Adventure','PG-13','Paramount Pictures',443319081,865842808,94524324),(2010,'Toy Story 3','Action','G','Walt Disney',415004880,481805411,52598844),(2009,'Transformers: Revenge of the Fallen','Action','PG-13','Paramount Pictures',402111870,491112631,53614916);
/*!40000 ALTER TABLE `highestgrossers` ENABLE KEYS */;
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
