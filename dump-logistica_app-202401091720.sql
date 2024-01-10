-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: logistica0.cs4kmk27dc0y.eu-north-1.rds.amazonaws.com    Database: logistica_app
-- ------------------------------------------------------
-- Server version	8.0.33

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `Aeropuerto`
--

DROP TABLE IF EXISTS `Aeropuerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Aeropuerto` (
  `id` int unsigned NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Aeropuerto`
--

LOCK TABLES `Aeropuerto` WRITE;
/*!40000 ALTER TABLE `Aeropuerto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Aeropuerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Coordenada`
--

DROP TABLE IF EXISTS `Coordenada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Coordenada` (
  `id` int unsigned NOT NULL,
  `latitud` double NOT NULL,
  `longitud` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Coordenada`
--

LOCK TABLES `Coordenada` WRITE;
/*!40000 ALTER TABLE `Coordenada` DISABLE KEYS */;
/*!40000 ALTER TABLE `Coordenada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Direccion`
--

DROP TABLE IF EXISTS `Direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Direccion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `pais` varchar(50) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `ciudad` varchar(50) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `esc` varchar(10) DEFAULT NULL,
  `piso` int DEFAULT NULL,
  `puerta` char(1) DEFAULT NULL,
  `codigo_postal` int DEFAULT NULL,
  `usuario_id` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Direccion_FK` (`usuario_id`),
  CONSTRAINT `Direccion_FK` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Direccion`
--

LOCK TABLES `Direccion` WRITE;
/*!40000 ALTER TABLE `Direccion` DISABLE KEYS */;
INSERT INTO `Direccion` VALUES (1,'a','a','a',1,'a','',1,'',1,NULL),(2,'España','Gipuzkoa','Donosti',1,'Madrid','',1,'',73,1);
/*!40000 ALTER TABLE `Direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empaquetado`
--

DROP TABLE IF EXISTS `Empaquetado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Empaquetado` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `peso` varchar(50) DEFAULT NULL,
  `tarifa_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Empaquetado_UniqueID_IDX` (`id`) USING BTREE,
  KEY `Empaquetado_tarifa_id_IDX` (`tarifa_id`) USING BTREE,
  CONSTRAINT `Empaquetado_FK` FOREIGN KEY (`tarifa_id`) REFERENCES `Tarifa` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empaquetado`
--

LOCK TABLES `Empaquetado` WRITE;
/*!40000 ALTER TABLE `Empaquetado` DISABLE KEYS */;
/*!40000 ALTER TABLE `Empaquetado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Factura`
--

DROP TABLE IF EXISTS `Factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Factura` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numero` varchar(225) NOT NULL,
  `numero_total` double NOT NULL,
  `fecha` date NOT NULL,
  `usuario_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Factura_usuario_id_IDX` (`usuario_id`) USING BTREE,
  CONSTRAINT `Factura_FK` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Factura`
--

LOCK TABLES `Factura` WRITE;
/*!40000 ALTER TABLE `Factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `Factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operacion`
--

DROP TABLE IF EXISTS `Operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Operacion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `empaquetado_id` int unsigned NOT NULL,
  `factura_id` int unsigned NOT NULL,
  `direccion_id` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Operacion_direccion_id_IDX` (`direccion_id`) USING BTREE,
  KEY `Operacion_empaquetado_id_IDX` (`empaquetado_id`) USING BTREE,
  KEY `Operacion_factura_id_IDX` (`factura_id`) USING BTREE,
  CONSTRAINT `Operacion_FK` FOREIGN KEY (`factura_id`) REFERENCES `Factura` (`id`),
  CONSTRAINT `Operacion_FK_1` FOREIGN KEY (`direccion_id`) REFERENCES `Direccion` (`id`),
  CONSTRAINT `Operacion_FK_2` FOREIGN KEY (`empaquetado_id`) REFERENCES `Empaquetado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operacion`
--

LOCK TABLES `Operacion` WRITE;
/*!40000 ALTER TABLE `Operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Puerto`
--

DROP TABLE IF EXISTS `Puerto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Puerto` (
  `id` int unsigned NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Puerto`
--

LOCK TABLES `Puerto` WRITE;
/*!40000 ALTER TABLE `Puerto` DISABLE KEYS */;
/*!40000 ALTER TABLE `Puerto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ruta`
--

DROP TABLE IF EXISTS `Ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ruta` (
  `id` int unsigned NOT NULL,
  `operaciónid` int NOT NULL,
  `tipo` int NOT NULL,
  `origen` int unsigned NOT NULL,
  `destino` int unsigned NOT NULL,
  `salide` datetime NOT NULL,
  `llegada` datetime NOT NULL,
  `aeropuerto_origen` int unsigned DEFAULT NULL,
  `aeropuerto_destino` int unsigned DEFAULT NULL,
  `id_vuelo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `aerolinea` varchar(100) DEFAULT NULL,
  `puerto_origen` int unsigned DEFAULT NULL,
  `puerto_destino` int unsigned DEFAULT NULL,
  `nombre_barco` varchar(100) DEFAULT NULL,
  `id_contenedor` varchar(255) DEFAULT NULL,
  `vehículo` varchar(255) DEFAULT NULL,
  `matrículo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Ruta_FK` (`origen`),
  KEY `Ruta_FK_1` (`destino`),
  KEY `Ruta_FK_2` (`aeropuerto_origen`),
  KEY `Ruta_FK_3` (`aeropuerto_destino`),
  KEY `Ruta_FK_4` (`puerto_origen`),
  KEY `Ruta_FK_5` (`puerto_destino`),
  CONSTRAINT `Ruta_FK` FOREIGN KEY (`origen`) REFERENCES `Coordenada` (`id`),
  CONSTRAINT `Ruta_FK_1` FOREIGN KEY (`destino`) REFERENCES `Coordenada` (`id`),
  CONSTRAINT `Ruta_FK_2` FOREIGN KEY (`aeropuerto_origen`) REFERENCES `Aeropuerto` (`id`),
  CONSTRAINT `Ruta_FK_3` FOREIGN KEY (`aeropuerto_destino`) REFERENCES `Aeropuerto` (`id`),
  CONSTRAINT `Ruta_FK_4` FOREIGN KEY (`puerto_origen`) REFERENCES `Puerto` (`id`),
  CONSTRAINT `Ruta_FK_5` FOREIGN KEY (`puerto_destino`) REFERENCES `Puerto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ruta`
--

LOCK TABLES `Ruta` WRITE;
/*!40000 ALTER TABLE `Ruta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tarifa`
--

DROP TABLE IF EXISTS `Tarifa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Tarifa` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `peso` double NOT NULL,
  `anchura` double NOT NULL,
  `altura` double NOT NULL,
  `diagonal` double NOT NULL,
  `precio` double NOT NULL,
  `nombre` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tarifa`
--

LOCK TABLES `Tarifa` WRITE;
/*!40000 ALTER TABLE `Tarifa` DISABLE KEYS */;
INSERT INTO `Tarifa` VALUES (1,5.5,100,100,97,24,'Standar');
/*!40000 ALTER TABLE `Tarifa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nick` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `password_salt` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `ultimo_login` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'unai','1234',' ',1,'6','updev96@gmail.com',NULL),(8,'a','a',NULL,1,'a','a',NULL),(9,'e','e',NULL,1,'e','e',NULL),(10,'i','i',NULL,0,'i','i',NULL),(11,'u','u',NULL,0,'u','u',NULL),(12,'Andres','1',NULL,0,'1','1',NULL),(13,'2','2',NULL,0,'2','2',NULL),(14,'3','3',NULL,0,'3','3',NULL),(16,'4','4',NULL,0,'4','4',NULL),(17,'5','a',NULL,1,'a','5',NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'logistica_app'
--
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-09 17:20:38
