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

 Date: 03/08/2021 07:19:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for quiztypes
-- ----------------------------
DROP TABLE IF EXISTS `quiztypes`;
CREATE TABLE `quiztypes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `difficulty` int DEFAULT NULL,
  `timeLimit` int DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of quiztypes
-- ----------------------------
BEGIN;
INSERT INTO `quiztypes` VALUES (1, 'Java', 2, 15, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
