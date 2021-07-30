/*
Navicat MySQL Data Transfer

Source Server         : YHT
Source Server Version : 50730
Source Host           : 121.41.91.101:3306
Source Database       : booksys

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2020-07-11 22:25:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `backlog`
-- ----------------------------
DROP TABLE IF EXISTS `backlog`;
CREATE TABLE `backlog` (
  `back_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `book_id` int(10) NOT NULL,
  `back_date` varchar(255) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  PRIMARY KEY (`back_id`),
  KEY `b1` (`user_id`),
  KEY `b2` (`book_id`),
  CONSTRAINT `b1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `b2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of backlog
-- ----------------------------
INSERT INTO `backlog` VALUES ('1', '1', '1', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('2', '1', '2', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('3', '2', '1', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('4', '2', '2', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('5', '2', '4', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('6', '1', '1', '2020-07-09 00:00:00');
INSERT INTO `backlog` VALUES ('8', '3', '1', '2020-07-10 00:00:00');
INSERT INTO `backlog` VALUES ('9', '2', '4', '2020-07-10 00:00:00');
INSERT INTO `backlog` VALUES ('10', '2', '2', '2020-07-10 00:00:00');
INSERT INTO `backlog` VALUES ('11', '2', '2', '2020-07-10 00:00:00');
INSERT INTO `backlog` VALUES ('12', '2', '4', '2020-07-11 00:00:00');
INSERT INTO `backlog` VALUES ('13', '8', '4', '2020-07-11 00:00:00');
INSERT INTO `backlog` VALUES ('14', '2', '1', '2020-07-11 00:00:00');
INSERT INTO `backlog` VALUES ('15', '2', '11', '2020-07-11 13:46:41');
INSERT INTO `backlog` VALUES ('16', '2', '5', '2020-07-11 13:46:43');
INSERT INTO `backlog` VALUES ('17', '2', '2', '2020-07-11 13:46:44');
INSERT INTO `backlog` VALUES ('18', '2', '12', '2020-07-11 22:06:36');
INSERT INTO `backlog` VALUES ('19', '2', '4', '2020-07-11 22:11:26');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `num` int(10) NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '山海经', '远古幻想生物图鉴', '玄幻', '45');
INSERT INTO `book` VALUES ('2', '诛仙', '修仙佳作之一', '修真', '72');
INSERT INTO `book` VALUES ('4', '求魔', '耳根3部曲第二部', '修真', '1');
INSERT INTO `book` VALUES ('5', '仙逆', '耳根三部曲第一部', '修真', '24');
INSERT INTO `book` VALUES ('7', '神医系统', '系统流作品', '都市', '19');
INSERT INTO `book` VALUES ('10', '斗破苍穹', '天蚕土豆巅峰', '玄幻', '10');
INSERT INTO `book` VALUES ('11', '武动乾坤', '天蚕土豆第二部', '玄幻', '10');
INSERT INTO `book` VALUES ('12', '修真聊天群', '有趣的都市修仙佳作', '都市', '19');

-- ----------------------------
-- Table structure for `borrowlog`
-- ----------------------------
DROP TABLE IF EXISTS `borrowlog`;
CREATE TABLE `borrowlog` (
  `borrow_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `book_id` int(10) NOT NULL,
  `borrow_date` varchar(255) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  PRIMARY KEY (`borrow_id`),
  KEY `a1` (`user_id`),
  KEY `a2` (`book_id`),
  CONSTRAINT `a1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `a2` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowlog
-- ----------------------------
INSERT INTO `borrowlog` VALUES ('4', '1', '2', '2020-07-09 00:00:00');
INSERT INTO `borrowlog` VALUES ('7', '2', '1', '2020-07-10 00:00:00');
INSERT INTO `borrowlog` VALUES ('8', '2', '1', '2020-07-10 00:00:00');
INSERT INTO `borrowlog` VALUES ('9', '2', '2', '2020-07-10 00:00:00');
INSERT INTO `borrowlog` VALUES ('11', '2', '2', '2020-07-10 00:00:00');
INSERT INTO `borrowlog` VALUES ('13', '2', '1', '2020-07-10 00:00:00');
INSERT INTO `borrowlog` VALUES ('15', '2', '1', '2020-07-11 00:00:00');
INSERT INTO `borrowlog` VALUES ('16', '8', '7', '2020-07-11 00:00:00');
INSERT INTO `borrowlog` VALUES ('17', '8', '5', '2020-07-11 00:00:00');
INSERT INTO `borrowlog` VALUES ('19', '8', '4', '2020-07-11 00:00:00');
INSERT INTO `borrowlog` VALUES ('20', '2', '1', '2020-07-11 00:00:00');
INSERT INTO `borrowlog` VALUES ('25', '2', '12', '2020-07-11 22:06:28');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `regtime` varchar(255) NOT NULL DEFAULT 'CURRENT_TIMESTAMP',
  `role` varchar(255) NOT NULL DEFAULT '',
  `borrow_num` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', '2020-07-08 00:00:00', '管理员', '1');
INSERT INTO `user` VALUES ('2', 'cyt', '123', '2020-07-11 13:46:44', '普通用户', '8');
INSERT INTO `user` VALUES ('3', 'cyt2', '1234', '2020-07-10 00:00:00', '普通用户', '1');
INSERT INTO `user` VALUES ('4', 'cyt12', '1233', '2020-07-10 00:00:00', '普通用户', '0');
INSERT INTO `user` VALUES ('8', 'CYT1', '123456', '2020-07-11 00:00:00', '普通用户', '3');
INSERT INTO `user` VALUES ('14', 'yht', '123', '2020-07-11 13:45:06', '普通用户', '0');
INSERT INTO `user` VALUES ('15', 'yht1', '123', '2020-07-11 22:03:18', '普通用户', '0');
INSERT INTO `user` VALUES ('16', 'admin2', '123456', '2020-07-11 22:06:06', '管理员', '0');
INSERT INTO `user` VALUES ('17', '陈祎天', '1694458081', '2020-07-11 22:09:23', '管理员', '0');
