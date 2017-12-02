-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: movies
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `sid` varchar(10) NOT NULL,
  `ticket_id` varchar(20) NOT NULL,
  `movie_name` varchar(50) NOT NULL,
  `total_cost` int(11) NOT NULL,
  PRIMARY KEY (`sid`,`ticket_id`),
  KEY `ticket_id` (`ticket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES ('1','150917001','Spiderman',400),('10','18111736','Spiderman',200),('11','181117456','Wonderwoman',400),('12','18111789','Wonderwoman',300),('13','181117931','Dangal',800),('14','181117116','Dangal',600),('15','181117577','Wonderwoman',200),('16','181117566','Annabelle',400),('17','181117119','Spiderman',200),('18','181117657','Spiderman',400),('19','181117487','Spiderman',300),('2','150917002','Spiderman',200),('20','181117762','Spiderman',200),('21','181117261','Spiderman',500),('22','181117621','Annabelle',400),('23','211117162','Spiderman',200),('24','211117987','Spiderman',400),('25','221117317','Spiderman',600),('26','261117336','Spiderman',200),('27','261117158','Baby Driver',1000),('28','271117429','Wonderwoman',600),('29','271117428','Spiderman',200),('3','161117001','Spiderman',600),('30','271117931','Dunkirk',800),('31','271117925','Dunkirk',400),('32','271117648','Logan',600),('4','171117001','Dunkirk',300),('5','17111701','Dunkirk',300),('6','1711170257','Logan',800),('7','181117808','Spiderman',200),('8','181117339','Wonderwoman',200),('9','181117260','Spiderman',200);
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_info`
--

DROP TABLE IF EXISTS `customer_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_info` (
  `ticket_id` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `movie_name` varchar(50) NOT NULL,
  `time` varchar(20) NOT NULL,
  `seat_number` varchar(30) NOT NULL,
  `screen_no` int(11) NOT NULL,
  `phone_no` varchar(15) NOT NULL,
  `date` date DEFAULT NULL,
  `seats_booked` int(11) NOT NULL,
  `booking_mode` varchar(10) NOT NULL,
  PRIMARY KEY (`ticket_id`),
  CONSTRAINT `customer_info_ibfk_1` FOREIGN KEY (`ticket_id`) REFERENCES `cost` (`ticket_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_info`
--

LOCK TABLES `customer_info` WRITE;
/*!40000 ALTER TABLE `customer_info` DISABLE KEYS */;
INSERT INTO `customer_info` VALUES ('150917001','John','Spiderman','09:00 am','S1 S2',1,'7000079999','2017-09-15',2,'COUNTER'),('150917002','Smith','Spiderman','09:00 am','S4',1,'7000078888','2017-09-15',1,'COUNTER'),('161117001','Michael','Spiderman','09:00 am','G1 G2 G4',1,'9731460394','2017-11-16',3,'COUNTER'),('171117001','Dwayne','Dunkirk','12:00 pm','S9 G9',1,'9039937464','2017-11-17',2,'COUNTER'),('17111701','Shubh','Dunkirk','12:00 pm','G10 S10 ',1,'7022770227','2017-11-17',2,'COUNTER'),('1711170257','Akshat','Logan','09:00 pm','G1 G7 G10 S1 S10 ',1,'9987654321','2017-11-17',5,'COUNTER'),('181117116','Hukum','Dangal','03:00 pm','G4 G5 G6 ',5,'9273846573','2017-11-18',3,'COUNTER'),('181117119','Ali','Spiderman','12:00 pm','G1 ',4,'1230495768','2017-11-18',1,'COUNTER'),('181117260','Turing','Spiderman','09:00 am','G8 ',1,'1010101010','2017-11-18',1,'COUNTER'),('181117261','dq','Spiderman','12:00 pm','G8 G9 S9 ',4,'dq','2017-11-18',3,'COUNTER'),('181117339','Turing','Wonderwoman','09:00 pm','G7 ',4,'1010101010','2017-11-18',1,'COUNTER'),('18111736','dsa','Spiderman','09:00 am','G7 ',1,'7788344428','2017-11-18',1,'COUNTER'),('181117456','TT','Wonderwoman','09:00 pm','G6 G7 ',4,'9911228833','2017-11-18',2,'COUNTER'),('181117487','APJ','Spiderman','12:00 pm','G10 S10 ',4,'1234543212','2017-11-18',2,'COUNTER'),('181117566','Robert','Annabelle','09:00 pm','S1 S2 S3 S4 ',5,'7777123456','2017-11-18',4,'COUNTER'),('181117577','Deep','Wonderwoman','09:00 pm','S5 S7 ',4,'2235544','2017-11-18',2,'COUNTER'),('181117621','asd','Annabelle','06:00 pm','G5 G7 ',3,'123','2017-11-18',2,'COUNTER'),('181117657','Alibaba','Spiderman','12:00 pm','G1 G2 ',4,'7384639264','2017-11-18',2,'COUNTER'),('181117762','APJ 2','Spiderman','12:00 pm','G9 ',4,'6543212345','2017-11-18',1,'COUNTER'),('181117808','Robin','Spiderman','09:00 am','G3 ',1,'9988776655','2017-11-18',1,'COUNTER'),('18111789','Alan Turing','Wonderwoman','09:00 pm','G8 S8 ',4,'1010101010','2017-11-18',2,'COUNTER'),('181117931','Leonardo','Dangal','09:00 pm','G5 G6 G7 S5 S6 ',3,'8833004424','2017-11-18',5,'COUNTER'),('211117162','Akshay','Spiderman','12:00 pm','S1 S2 ',4,'4123284756','2017-11-21',2,'COUNTER'),('211117987','Kumar','Spiderman','12:00 pm','G6 G7 ',4,'1263547586','2017-11-21',2,'COUNTER'),('221117317','Kings','Spiderman','06:00 pm','G1 G2 S1 S2 ',2,'1826473267','2017-11-22',4,'COUNTER'),('261117158','SHUBHARTI','Baby Driver','03:00 pm','G6 G7 G8 G9 G10 ',1,'917000079368','2017-11-26',5,'COUNTER'),('261117336','ANKIT','Spiderman','09:00 am','G10 ',1,'1314353423','2017-11-26',1,'COUNTER'),('271117428','Jenie','Spiderman','09:00 am','G3 ',1,'2738473857','2017-11-27',1,'COUNTER'),('271117429','shreyank','Wonderwoman','12:00 pm','G1 G2 G3 ',3,'8197571243','2017-11-27',3,'SMS'),('271117648','Loki','Logan','03:00 pm','G6 G7 G8 ',3,'7000079368','2017-11-27',3,'SMS'),('271117925','Kevin','Dunkirk','12:00 pm','G7 G8 ',1,'7000079368','2017-11-27',2,'SMS'),('271117931','Tony stark','Dunkirk','12:00 pm','G1 G2 G3 G4 ',1,'2244117890','2017-11-27',4,'COUNTER');
/*!40000 ALTER TABLE `customer_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie_details`
--

DROP TABLE IF EXISTS `movie_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movie_details` (
  `movie_name` varchar(50) NOT NULL,
  `star_cast` varchar(50) NOT NULL,
  `ratings` int(11) NOT NULL,
  `duration` varchar(10) NOT NULL,
  `U_A_rating` varchar(5) NOT NULL,
  PRIMARY KEY (`movie_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_details`
--

LOCK TABLES `movie_details` WRITE;
/*!40000 ALTER TABLE `movie_details` DISABLE KEYS */;
INSERT INTO `movie_details` VALUES ('Annabelle : Creation','Stephanie Sigman, Talitha Bateman',7,'110 mins','A'),('Baahubali: The Beginning','Prabhas',8,'159 mins','UA'),('Baby Driver','Ansel Elgort',8,'113 mins','UA'),('Dangal','Aamir Khan',9,'169 mins','UA'),('Dunkirk','Fionn Whitehead',8,'120 mins','U'),('Logan','Hugh Jackman',8,'142 mins','A'),('Spider-Man: Homecoming','Tom Holland',8,'133 mins','UA'),('Wonder Woman','Gal Gadot',8,'141 mins','UA');
/*!40000 ALTER TABLE `movie_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_details`
--

DROP TABLE IF EXISTS `screen_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_details` (
  `sid` varchar(10) NOT NULL,
  `screen_no` int(11) NOT NULL,
  `movie_name` varchar(50) NOT NULL,
  `time` int(11) NOT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `screen_details_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `cost` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_details`
--

LOCK TABLES `screen_details` WRITE;
/*!40000 ALTER TABLE `screen_details` DISABLE KEYS */;
INSERT INTO `screen_details` VALUES ('1',1,'Spiderman',900),('10',1,'Spiderman',900),('11',4,'Wonderwoman',2100),('12',4,'Wonderwoman',2100),('13',3,'Dangal',2100),('14',5,'Dangal',1500),('15',4,'Wonderwoman',2100),('16',5,'Annabelle',2100),('17',4,'Spiderman',1200),('18',4,'Spiderman',1200),('19',4,'Spiderman',1200),('2',1,'Spiderman',900),('20',4,'Spiderman',1200),('21',4,'Spiderman',1200),('22',3,'Annabelle',1800),('23',4,'Spiderman',1200),('24',4,'Spiderman',1200),('25',2,'Spiderman',1800),('26',1,'Spiderman',900),('27',1,'Baby Driver',1500),('28',3,'Wonderwoman',1200),('29',1,'Spiderman',900),('3',1,'Spiderman',900),('30',1,'Dunkirk',1200),('31',1,'Dunkirk',1200),('32',3,'Logan',1500),('4',1,'Dunkirk',1200),('5',1,'Dunkirk',1200),('6',1,'Logan',2100),('7',1,'Spiderman',900),('8',4,'Wonderwoman',2100),('9',1,'Spiderman',900);
/*!40000 ALTER TABLE `screen_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_movie_map`
--

DROP TABLE IF EXISTS `screen_movie_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_movie_map` (
  `screen_no` int(11) DEFAULT NULL,
  `movie_name` varchar(30) DEFAULT NULL,
  `time` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_movie_map`
--

LOCK TABLES `screen_movie_map` WRITE;
/*!40000 ALTER TABLE `screen_movie_map` DISABLE KEYS */;
INSERT INTO `screen_movie_map` VALUES (1,'Spiderman','09:00 am'),(1,'Dunkirk','12:00 pm'),(1,'Baby Driver','03:00 pm'),(1,'Wonderwoman','06:00 pm'),(1,'Logan','09:00 pm'),(2,'Annabelle','09:00 am'),(2,'Dangal','12:00 pm'),(2,'Baahubali','03:00 pm'),(2,'Spiderman','06:00 pm'),(2,'Dunkirk','09:00 pm'),(3,'Baby Driver','09:00 am'),(3,'Wonderwoman','12:00 pm'),(3,'Logan','03:00 pm'),(3,'Annabelle','06:00 pm'),(3,'Dangal','09:00 pm'),(4,'Baahubali','09:00 am'),(4,'Spiderman','12:00 pm'),(4,'Dunkirk','03:00 pm'),(4,'Baby Driver','06:00 pm'),(4,'Wonderwoman','09:00 pm'),(5,'Logan','09:00 am'),(5,'Annabelle','12:00 pm'),(5,'Dangal','03:00 pm'),(5,'Baahubali','06:00 pm'),(5,'Annabelle','09:00 pm');
/*!40000 ALTER TABLE `screen_movie_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_info`
--

DROP TABLE IF EXISTS `seat_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_info` (
  `sid` varchar(10) NOT NULL,
  `screen_no` int(11) NOT NULL,
  `seats_booked` int(11) NOT NULL,
  `seats_available` int(11) NOT NULL,
  `total_seats` int(11) NOT NULL,
  `seat_number` varchar(30) NOT NULL,
  PRIMARY KEY (`sid`),
  CONSTRAINT `seat_info_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `cost` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_info`
--

LOCK TABLES `seat_info` WRITE;
/*!40000 ALTER TABLE `seat_info` DISABLE KEYS */;
INSERT INTO `seat_info` VALUES ('1',1,2,18,20,'S1 S2'),('10',1,1,11,20,'G7 '),('11',4,2,17,20,'G6 G7 '),('12',4,2,17,20,'G8 S8 '),('13',3,5,15,20,'G5 G6 G7 S5 S6 '),('14',5,3,12,20,'G4 G5 G6 '),('15',4,2,17,20,'S5 S7 '),('16',5,4,16,20,'S1 S2 S3 S4 '),('17',4,1,11,20,'G1 '),('18',4,2,10,20,'G1 G2 '),('19',4,2,10,20,'G10 S10 '),('2',1,1,17,20,'S4'),('20',4,1,11,20,'G9 '),('21',4,3,9,20,'G8 G9 S9 '),('22',3,2,14,20,'G5 G7 '),('23',4,2,10,20,'S1 S2 '),('24',4,2,10,20,'G6 G7 '),('25',2,4,8,20,'G1 G2 S1 S2 '),('26',1,1,11,20,'G10 '),('27',1,5,15,20,'G6 G7 G8 G9 G10 '),('28',3,3,16,20,'G1 G2 G3 '),('29',1,1,11,20,'G3 '),('3',1,3,14,20,'G1 G2 G4'),('30',1,4,12,20,'G1 G2 G3 G4 '),('31',1,2,14,20,'G7 G8 '),('32',3,3,12,20,'G6 G7 G8 '),('4',1,2,18,20,'S9 G9'),('5',1,2,16,20,'G10 S10 '),('6',1,5,15,20,'G1 G7 G10 S1 S10 '),('7',1,1,13,20,'G3 '),('8',4,1,19,20,'G7 '),('9',1,1,12,20,'G8 ');
/*!40000 ALTER TABLE `seat_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-27 18:40:11
