CREATE DATABASE  IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `tb_hospede`
--

DROP TABLE IF EXISTS `tb_hospede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_hospede` (
  `cpf` varchar(14) NOT NULL,
  `nome` varchar(100) NOT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_hospede`
--

LOCK TABLES `tb_hospede` WRITE;
/*!40000 ALTER TABLE `tb_hospede` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_hospede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_quarto`
--

DROP TABLE IF EXISTS `tb_quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_quarto` (
  `num_quarto` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`num_quarto`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_quarto`
--

LOCK TABLES `tb_quarto` WRITE;
/*!40000 ALTER TABLE `tb_quarto` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_quarto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reserva`
--

DROP TABLE IF EXISTS `tb_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reserva` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(14) DEFAULT NULL,
  `num_quarto` int NOT NULL,
  `data_checkin` date NOT NULL,
  `data_checkout` datetime DEFAULT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `cpf` (`cpf`),
  KEY `num_quarto` (`num_quarto`),
  CONSTRAINT `tb_reserva_ibfk_1` FOREIGN KEY (`cpf`) REFERENCES `tb_hospede` (`cpf`),
  CONSTRAINT `tb_reserva_ibfk_2` FOREIGN KEY (`num_quarto`) REFERENCES `tb_quarto` (`num_quarto`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reserva`
--

LOCK TABLES `tb_reserva` WRITE;
/*!40000 ALTER TABLE `tb_reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'hotel'
--

--
-- Dumping routines for database 'hotel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-17 14:52:19
