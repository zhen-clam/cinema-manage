/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : vip

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-21 07:29:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '张三', '123456');
INSERT INTO `admin` VALUES ('2', '李四', '123456');
INSERT INTO `admin` VALUES ('3', 'admin', '123');

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `money` varchar(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `userId` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of consumption
-- ----------------------------
INSERT INTO `consumption` VALUES ('11', '李峰', '10', '2020-06-16 19:02:15', '1002');
INSERT INTO `consumption` VALUES ('12', '李峰', '10', '2020-06-16 19:03:07', '1002');
INSERT INTO `consumption` VALUES ('13', '张三', '100', '2020-06-16 19:05:46', '1003');
INSERT INTO `consumption` VALUES ('14', '张三', '100', '2020-06-16 19:11:44', '1003');
INSERT INTO `consumption` VALUES ('15', '王伟', '100', '2020-06-21 07:25:11', '1004');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` bigint(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `money` int(10) DEFAULT NULL,
  `time` varchar(30) DEFAULT NULL,
  `userId` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES ('21', '李峰', '100', '2020-06-16 18:01:45', '1002');
INSERT INTO `recharge` VALUES ('22', 'test', '60', '2020-06-16 18:20:06', '1009');
INSERT INTO `recharge` VALUES ('23', '张飒', '100', '2020-06-16 18:40:50', '1001');
INSERT INTO `recharge` VALUES ('24', '张飒', '10', '2020-06-16 19:01:47', '1001');
INSERT INTO `recharge` VALUES ('25', '王伟', '50', '2020-06-21 07:25:55', '1004');

-- ----------------------------
-- Table structure for vipcard
-- ----------------------------
DROP TABLE IF EXISTS `vipcard`;
CREATE TABLE `vipcard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `status` varchar(4) CHARACTER SET utf8mb4 DEFAULT NULL,
  `integral` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipcard
-- ----------------------------
INSERT INTO `vipcard` VALUES ('1001', '张飒', '77', '正常', '91');
INSERT INTO `vipcard` VALUES ('1002', '李峰', '96', '正常', '50');
INSERT INTO `vipcard` VALUES ('1003', '张三', '1042', '挂失', '86');
INSERT INTO `vipcard` VALUES ('1004', '王伟', '178', '正常', '74');
INSERT INTO `vipcard` VALUES ('1005', '王静', '78', '正常', '90');
INSERT INTO `vipcard` VALUES ('1006', '吴彤', '47', '正常', '33');
INSERT INTO `vipcard` VALUES ('1007', '吴峰', '54', '正常', '88');
INSERT INTO `vipcard` VALUES ('1008', '振宇', '90', '正常', '90');
INSERT INTO `vipcard` VALUES ('1009', 'test', '99', '正常', '85');

-- ----------------------------
-- Table structure for vipusers
-- ----------------------------
DROP TABLE IF EXISTS `vipusers`;
CREATE TABLE `vipusers` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cid` int(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `tip` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vipusers
-- ----------------------------
INSERT INTO `vipusers` VALUES ('1', '张飒', '1001', '2020-06-09', '17862883351', '是');
INSERT INTO `vipusers` VALUES ('2', '李峰', '1002', '2020-06-09', '15684136743', '是');
INSERT INTO `vipusers` VALUES ('3', '张三', '1003', '1999-06-08', '19278654387', '否');
INSERT INTO `vipusers` VALUES ('4', '王伟', '1004', '2020-06-07', '17866543210', '是');
INSERT INTO `vipusers` VALUES ('5', '王静', '1005', '2020-06-16', '18976543289', '是');
INSERT INTO `vipusers` VALUES ('6', '吴彤', '1006', '2020-06-05', '17897654321', '是');
INSERT INTO `vipusers` VALUES ('7', '吴峰', '1007', '2020-06-03', '17862667543', '否');
INSERT INTO `vipusers` VALUES ('8', '振宇', '1008', '2020-06-04', '13408763452', '是');
INSERT INTO `vipusers` VALUES ('9', 'test', '1009', '2010-06-21', '1908999000', '是');
