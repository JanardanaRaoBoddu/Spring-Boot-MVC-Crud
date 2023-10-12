CREATE DATABASE  IF NOT EXISTS `employee_dir`;
USE `employee_dir`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `employee` VALUES 
	(1,'JanardanRao','Boddu','janardanaraoboddu@gmail.com'),
	(2,'Prasad','Seepana','prasadseepana@gmail.com'),
	(3,'Saikiran','Thota','saikiranthota@gmail.com'),
	(4,'UdayBhaskar','Laveti','udaybhaskarlaveti@gmail.com'),
	(5,'SaiKumar','Chukka','saikumarchukka@gmail.com');