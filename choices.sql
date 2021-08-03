/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 03/08/2021 07:19:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choices
-- ----------------------------
DROP TABLE IF EXISTS `choices`;
CREATE TABLE `choices` (
  `id` int NOT NULL AUTO_INCREMENT,
  `questionId` int DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `isAnswer` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of choices
-- ----------------------------
BEGIN;
INSERT INTO `choices` VALUES (1, 1, 'A class is a blue print from which individual objects are created. A class can contain fields and methods to describe the behavior of an object.', 1);
INSERT INTO `choices` VALUES (2, 1, 'class is a special data type.', 0);
INSERT INTO `choices` VALUES (3, 1, 'class is used to allocate memory to a data type.', 0);
INSERT INTO `choices` VALUES (4, 1, 'none of the above.', 0);
INSERT INTO `choices` VALUES (5, 2, '8 bit', 0);
INSERT INTO `choices` VALUES (6, 2, '16 bit', 1);
INSERT INTO `choices` VALUES (7, 2, '32 bit', 0);
INSERT INTO `choices` VALUES (8, 2, 'not precisely defined', 0);
INSERT INTO `choices` VALUES (9, 3, '0.0d', 1);
INSERT INTO `choices` VALUES (10, 3, '0.0f', 0);
INSERT INTO `choices` VALUES (11, 3, '0', 0);
INSERT INTO `choices` VALUES (12, 3, 'not defined', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
