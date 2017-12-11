CREATE DATABASE IF NOT EXISTS `message`;
USE `message`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB;

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `message_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `from_user_name` varchar(255) NOT NULL,
  `to_user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB;