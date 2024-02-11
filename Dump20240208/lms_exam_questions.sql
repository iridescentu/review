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
-- Table structure for table `exam_questions`
--

DROP TABLE IF EXISTS `exam_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_questions` (
  `exam_question_id` bigint NOT NULL AUTO_INCREMENT,
  `correct_option_index` int NOT NULL,
  `quest_paragraph` varchar(255) DEFAULT NULL,
  `question_text` varchar(255) NOT NULL,
  `wrong_ans_expl` varchar(255) DEFAULT NULL,
  `exam_id` bigint NOT NULL,
  PRIMARY KEY (`exam_question_id`),
  KEY `FK5cd6sjmccb11rrwpyabyc81c0` (`exam_id`),
  CONSTRAINT `FK5cd6sjmccb11rrwpyabyc81c0` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_questions`
--

LOCK TABLES `exam_questions` WRITE;
/*!40000 ALTER TABLE `exam_questions` DISABLE KEYS */;
INSERT INTO `exam_questions` VALUES (1,3,'시험 본문 어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구','시험 문제','시험 문제에 대한 해설',1),(2,0,'시험 본문 어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구','What is Java?','시험 문제에 대한 해설',1),(3,1,'시험 본문 어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구','What is OOP?','시험 문제에 대한 해설',1),(4,1,'시험 본문 어쩌구저쩌구어쩌구저쩌구어쩌구저쩌구','What is OOP?','시험 문제에 대한 해설',2),(5,1,'시험 본문','시험 문제','시험 문제에 대한 해설',2);
/*!40000 ALTER TABLE `exam_questions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-08 20:04:16
