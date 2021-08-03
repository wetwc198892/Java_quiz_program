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

 Date: 03/08/2021 07:19:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for questions
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quizTypeId` int DEFAULT NULL,
  `Description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of questions
-- ----------------------------
BEGIN;
INSERT INTO `questions` VALUES (1, 1, 'What is a class in java?');
INSERT INTO `questions` VALUES (2, 1, 'What is the size of boolean variable?');
INSERT INTO `questions` VALUES (3, 1, 'What is the default value of double variable?');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
