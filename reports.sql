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

 Date: 03/08/2021 07:19:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for reports
-- ----------------------------
DROP TABLE IF EXISTS `reports`;
CREATE TABLE `reports` (
  `id` int NOT NULL AUTO_INCREMENT,
  `submissionId` int DEFAULT NULL,
  `questionId` varchar(255) DEFAULT NULL,
  `selectIdx` varchar(255) DEFAULT NULL,
  `answerIdx` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of reports
-- ----------------------------
BEGIN;
INSERT INTO `reports` VALUES (1, 5, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (2, 6, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (3, 7, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (4, 8, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (5, 9, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (6, 10, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (7, 11, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
INSERT INTO `reports` VALUES (8, 12, '[1, 2, 3]', '{1=1, 2=0, 3=0}', '{1=1, 2=6, 3=9}');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
