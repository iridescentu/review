-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: lms
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `delivery_message` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `order_date` datetime(6) NOT NULL,
  `payment_date` datetime(6) DEFAULT NULL,
  `payment_method` varchar(255) NOT NULL,
  `payment_status` bit(1) NOT NULL,
  `phone_num` varchar(255) NOT NULL,
  `recipient` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_amount` decimal(38,2) DEFAULT NULL,
  `member_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK2vq7lo4gkknrmghj3rqpqqg6s` (`member_id`),
  CONSTRAINT `FK2vq7lo4gkknrmghj3rqpqqg6s` FOREIGN KEY (`member_id`) REFERENCES `members` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'123 Main St','Handle with care','john.doe@example.com','2024-02-05 16:25:47.322157','2024-02-05 16:25:47.334150','Credit Card',_binary '','123-4567-8901','John Doe','결제 완료',199000.00,3),(2,'대전','','jihee@email.com','2024-02-06 11:43:30.746822','2024-02-06 11:43:30.753813','',_binary '','010-1234-5678','윤지희','결제 완료',199000.00,3),(3,'대전 서구','','abcde@gmail.com','2024-02-06 16:08:23.675957','2024-02-06 16:08:23.681954','',_binary '','010-1234-5678','윤지희','결제 완료',99000.00,3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-08 20:04:18
