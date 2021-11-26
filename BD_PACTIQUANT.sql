CREATE DATABASE  IF NOT EXISTS `practiquant` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `practiquant`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: practiquant
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `codperfil` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `fnacim` date DEFAULT NULL,
  `resumen` varchar(500) DEFAULT NULL,
  `estado` smallint DEFAULT NULL,
  PRIMARY KEY (`codperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (4,'Esteban','Romero','1999-09-14','Aquí va curriculum',1),(5,'Graña','Montero','1940-07-04','Aquí va descripcion de empresa',1),(6,'Pepe','Luna','2001-10-04','Aquí va curriculum',1);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postulacion`
--

DROP TABLE IF EXISTS `postulacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postulacion` (
  `codpostulacion` int NOT NULL AUTO_INCREMENT,
  `detallepostulante` varchar(500) NOT NULL,
  `fechapostulacion` date DEFAULT NULL,
  `codpractica` int DEFAULT NULL,
  `codperfil` int DEFAULT NULL,
  `estado` smallint DEFAULT NULL,
  PRIMARY KEY (`codpostulacion`),
  KEY `codpractica` (`codpractica`),
  KEY `codperfil` (`codperfil`),
  CONSTRAINT `postulacion_ibfk_1` FOREIGN KEY (`codpractica`) REFERENCES `practica` (`codpractica`),
  CONSTRAINT `postulacion_ibfk_2` FOREIGN KEY (`codperfil`) REFERENCES `perfil` (`codperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postulacion`
--

LOCK TABLES `postulacion` WRITE;
/*!40000 ALTER TABLE `postulacion` DISABLE KEYS */;
INSERT INTO `postulacion` VALUES (4,'Dios mioquericodiosmio4','2021-11-25',4,6,1),(5,'Prueba2','2021-10-25',4,4,1),(6,'Prueba3','2021-10-25',5,4,1),(7,'Dios mio','2021-11-24',4,6,1);
/*!40000 ALTER TABLE `postulacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `practica`
--

DROP TABLE IF EXISTS `practica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `practica` (
  `codpractica` int NOT NULL AUTO_INCREMENT,
  `detallepractica` varchar(500) NOT NULL,
  `requisitopractica` varchar(500) NOT NULL,
  `fechatermino` date NOT NULL,
  `codperfil` int DEFAULT NULL,
  `estado` smallint DEFAULT NULL,
  PRIMARY KEY (`codpractica`),
  KEY `codperfil` (`codperfil`),
  CONSTRAINT `practica_ibfk_1` FOREIGN KEY (`codperfil`) REFERENCES `perfil` (`codperfil`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `practica`
--

LOCK TABLES `practica` WRITE;
/*!40000 ALTER TABLE `practica` DISABLE KEYS */;
INSERT INTO `practica` VALUES (4,'sadas','dasdas','2021-10-14',4,1),(5,'df','sdsd','2021-10-20',5,1);
/*!40000 ALTER TABLE `practica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (5,'Producto1',18);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rol_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_puhr3k3l7bj71hb7hk7ktpxn0` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (7,'admin@gmail.com','admin','admin','$2a$10$sgwXdtdgnmUDTMrbrfk1XeBoETnviSujqeHFxh5RSD4/fnVtouCqm'),(8,'danielcastilla909@gmail.com','daniel','daniel','$2a$10$TVG94zjvs2AWlOjWwOR/t.4tf.07Ic0WnMRaaANnO4j2fgnyNyMeG'),(9,'f1234@gmail.com','Daniel','admin2','$2a$10$V0tGRKinprsHhojciwJW2O3GLkSFgPZ/oz2LOvf5whqLEtC0rRJGe'),(10,'pppp@gmail.com','Jose','admin2020','$2a$10$KGaBcN8QcbCLzhI7LHxYcuQdAtIJ/NqTLsIC2miAQXm1BwUeMCWKi'),(11,'ppp@gmail.com','Diego','admin2021','$2a$10$oH7QWv3sYuSz6Mgr.xeAjeOIHMnVyjw7uDUOr2Ow0AFuBCifivakG'),(12,'pp@gmail.com','Jesus','admin2022','$2a$10$Yv71ZYH1OOCSlTokRxDQEeMOdQK4PaoV.bDL7gzKZ2nflS7YjTlq2');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_role`
--

DROP TABLE IF EXISTS `usuario_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_role` (
  `usuario_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `FK5wxqd7u43doy9467aiaebgjuu` (`rol_id`),
  CONSTRAINT `FK5wxqd7u43doy9467aiaebgjuu` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`),
  CONSTRAINT `FKpc2qjts6sqq4hja9f6i3hf0ep` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_role`
--

LOCK TABLES `usuario_role` WRITE;
/*!40000 ALTER TABLE `usuario_role` DISABLE KEYS */;
INSERT INTO `usuario_role` VALUES (7,1),(9,1),(10,1),(11,1),(12,1),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2);
/*!40000 ALTER TABLE `usuario_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'practiquant'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarpostulaciones` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarpostulaciones`(codperfil int)
begin
select * from tb_Postulacion as p where p.codperfil = codperfil;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarpracticas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarpracticas`(codperfil int)
begin
select * from tb_Practica as p where p.codperfil = codperfil;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_postular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_postular`(detalle varchar(500),estado varchar(25),codpractica int, codperfil int )
begin
insert into tb_postulacion values (null,detalle, Now(),estado, codpractica,codperfil);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_publicarpractica` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_publicarpractica`(detalle varchar(500),reqs varchar(25),fecha date, codperfil int )
begin
insert into tb_postulacion values (null,detalle, Now(),estado, codpractica,codperfil);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_registrarusuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_registrarusuario`(usuario char(4),clave char(5), idtipo int )
begin
insert into usuario values (null,usuario, clave,idtipo);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25 23:31:55
