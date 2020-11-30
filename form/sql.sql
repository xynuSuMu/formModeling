# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.7.31)
# Database: activiti
# Generation Time: 2020-11-30 09:36:00 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table form_sys_component
# ------------------------------------------------------------

DROP TABLE IF EXISTS `form_sys_component`;

CREATE TABLE `form_sys_component` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名称',
  `field_key` varchar(100) NOT NULL DEFAULT '' COMMENT '字段名称',
  `select_key` varchar(100) NOT NULL DEFAULT '' COMMENT '组件对应的key',
  `select_value` varchar(100) NOT NULL DEFAULT '' COMMENT '组件对应的value',
  `select_sort` int(3) NOT NULL COMMENT '组件的排序',
  PRIMARY KEY (`id`),
  KEY `index_name_key` (`table_name`,`field_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统组件数据';



# Dump of table form_sys_field_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `form_sys_field_info`;

CREATE TABLE `form_sys_field_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) DEFAULT '' COMMENT '表名称',
  `field_key` varchar(100) DEFAULT NULL COMMENT '字段名称',
  `field_type` varchar(100) DEFAULT NULL COMMENT '类型',
  `field_name` varchar(100) DEFAULT NULL COMMENT '字段名称',
  `scope_value` varchar(100) DEFAULT NULL COMMENT '值范围',
  `required` tinyint(1) DEFAULT NULL COMMENT '是否必填',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='表单字段信息';



# Dump of table form_sys_html
# ------------------------------------------------------------

DROP TABLE IF EXISTS `form_sys_html`;

CREATE TABLE `form_sys_html` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `html_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表单名称',
  `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
  `html_desc` varchar(100) NOT NULL DEFAULT '' COMMENT '描述',
  `field_html` longtext NOT NULL COMMENT 'html表单',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  `date_update` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新时间',
  `date_delete` timestamp NULL DEFAULT NULL COMMENT '数据删除时间',
  PRIMARY KEY (`id`),
  KEY `index_name_key` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='保存表单';



# Dump of table form_sys_html_rule
# ------------------------------------------------------------

DROP TABLE IF EXISTS `form_sys_html_rule`;

CREATE TABLE `form_sys_html_rule` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `table_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表名',
  `html_name` varchar(100) NOT NULL DEFAULT '' COMMENT '表单样式ID',
  `field_key` varchar(100) NOT NULL DEFAULT '' COMMENT '字段名称',
  `required` tinyint(1) DEFAULT NULL COMMENT '是否必填',
  `edit` tinyint(1) DEFAULT NULL COMMENT '是否可编辑',
  `date_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
  `date_update` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '数据更新时间',
  `date_delete` timestamp NULL DEFAULT NULL COMMENT '数据删除时间',
  PRIMARY KEY (`id`),
  KEY `index_name_key` (`table_name`),
  KEY `index_html_id` (`html_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='每种表单样式的字段规则';



# Dump of table form_sys_table_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `form_sys_table_info`;

CREATE TABLE `form_sys_table_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `table_name` longtext NOT NULL COMMENT '表名称',
  `table_desc` varchar(100) NOT NULL DEFAULT '' COMMENT '表单描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
