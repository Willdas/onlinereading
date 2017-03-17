/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : onlineread

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2017-03-17 15:26:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` varchar(200) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `author` varchar(20) DEFAULT NULL,
  `describes` varchar(100) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `price` double(20,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('111', 'java', 'KK11', null, '2013-03-11', 'java', '24.80');
INSERT INTO `books` VALUES ('222', 'PHP', 'KK22', null, '2013-05-22', 'PHP', '23.20');
INSERT INTO `books` VALUES ('333', 'HTML', 'KK33', null, '2013-03-29', 'HTML', '23.30');
INSERT INTO `books` VALUES ('444', 'mySQL', 'KK44', null, '2013-05-22', 'SQL', '25.80');
