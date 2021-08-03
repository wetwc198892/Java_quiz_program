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

 Date: 03/08/2021 07:19:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for submissions
-- ----------------------------
DROP TABLE IF EXISTS `submissions`;
CREATE TABLE `submissions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `quizTypeId` int DEFAULT NULL,
  `startTime` varchar(30) DEFAULT NULL,
  `endTime` varchar(30) DEFAULT NULL,
  `pass` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of submissions
-- ----------------------------
BEGIN;
INSERT INTO `submissions` VALUES (1, 1, 1, '08-03-2021 02:36:28', '08-03-2021 02:44:39', 0);
INSERT INTO `submissions` VALUES (3, 1, 1, '08-03-2021 03:03:16', '08-03-2021 03:03:21', 0);
INSERT INTO `submissions` VALUES (4, 1, 1, '08-03-2021 03:12:30', '08-03-2021 03:16:36', 0);
INSERT INTO `submissions` VALUES (5, 1, 1, '08-03-2021 04:51:04', '08-03-2021 04:51:14', 0);
INSERT INTO `submissions` VALUES (6, 1, 1, '08-03-2021 04:54:37', '08-03-2021 04:54:39', 0);
INSERT INTO `submissions` VALUES (7, 1, 1, '08-03-2021 04:55:07', '08-03-2021 04:55:09', 0);
INSERT INTO `submissions` VALUES (8, 1, 1, '08-03-2021 05:03:52', '08-03-2021 05:03:58', 0);
INSERT INTO `submissions` VALUES (9, 1, 1, '08-03-2021 05:06:38', '08-03-2021 05:06:43', 0);
INSERT INTO `submissions` VALUES (10, 1, 1, '08-03-2021 05:07:24', '08-03-2021 05:09:48', 0);
INSERT INTO `submissions` VALUES (11, 1, 1, '08-03-2021 05:51:16', '08-03-2021 05:51:21', 0);
INSERT INTO `submissions` VALUES (12, 1, 1, '08-03-2021 06:08:48', '08-03-2021 06:08:51', 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
