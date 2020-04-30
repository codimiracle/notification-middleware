/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : notification_service

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-04-29 16:38:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for notification
-- ----------------------------
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `sender_id` int(11) DEFAULT NULL COMMENT '发送者',
  `receiver_id` int(11) DEFAULT NULL COMMENT '接收者',
  `type` varchar(255) DEFAULT NULL COMMENT '通知类型',
  `payload` text COMMENT '通知内容',
  `read` tinyint(1) DEFAULT '0' COMMENT '已读标识（0: 未读, 1:已读）',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '删除标识',
  `deleted_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
