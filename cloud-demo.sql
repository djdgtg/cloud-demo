/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : cloud-demo

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-05-25 15:26:14
*/

SET
FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`
(
    `id`             int(11) NOT NULL AUTO_INCREMENT,
    `authority_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    `name`           varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`authority_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority`
VALUES ('1', 'admin', '超管权限');
INSERT INTO `authority`
VALUES ('2', 'test', '测试权限');
INSERT INTO `authority`
VALUES ('7', 'system', '系统权限');
INSERT INTO `authority`
VALUES ('8', 'examtool', '考务权限');
INSERT INTO `authority`
VALUES ('9', 'visitor', '游客权限');

-- ----------------------------
-- Table structure for discipline
-- ----------------------------
DROP TABLE IF EXISTS `discipline`;
CREATE TABLE `discipline`
(
    `id`                int(11) NOT NULL AUTO_INCREMENT,
    `source`            varchar(255) DEFAULT NULL,
    `discipline_code`   varchar(255) DEFAULT NULL,
    `discipline_detail` varchar(255) DEFAULT NULL,
    `punishment`        varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discipline
-- ----------------------------
INSERT INTO `discipline`
VALUES ('1', '教育部第33号令第九条第一款', '5.1', '携带规定以外的物品进入考场或者未放在指定位置的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('2', '教育部第33号令第九条第一款', '5.2', '未在规定的座位参加考试的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('3', '教育部第33号令第九条第一款', '5.3', '考试开始信号发出前答题或者考试结束信号发出后继续答题的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('4', '教育部第33号令第九条第一款', '5.4', '在考试过程中旁窥、交头接耳、互打暗号或者手势的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('5', '教育部第33号令第九条第一款', '5.5', '在考场或者教育考试机构禁止的范围内，喧哗、吸烟或者实施其他影响考场秩序的行为的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('6', '教育部第33号令第九条第一款', '5.6', '未经考试工作人员同意在考试过程中擅自离开考场的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('7', '教育部第33号令第九条第一款', '5.7', '将试卷、答卷(含答题卡、答题纸等，下同)、草稿纸等考试用纸带出考场的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('8', '教育部第33号令第九条第一款', '5.8', '用规定以外的笔或者纸答题或者在试卷规定以外的地方书写姓名、准考证号或者以其他方式在答卷上标记信息的；', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('9', '教育部第33号令第九条第一款', '5.9', '其他违反考场规则但尚未构成作弊的行为。', '取消该科目的考试成绩');
INSERT INTO `discipline`
VALUES ('10', '教育部第33号令第九条第二款', '6.1', '携带与考试内容相关的材料或者存储有与考试内容相关资料的电子设备参加考试的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('11', '教育部第33号令第九条第二款', '6.2', '抄袭或者协助他人抄袭试题答案或者与考试内容相关的资料的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('12', '教育部第33号令第九条第二款', '6.3', '胁迫他人为自己抄袭提供方便的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('13', '教育部第33号令第九条第二款', '6.4', '携带具有发送或者接收信息功能的设备的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('14', '教育部第33号令第九条第二款', '6.5', '由他人冒名代替参加考试的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('15', '教育部第33号令第九条第二款', '6.6', '故意销毁试卷、答卷或者考试材料的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('16', '教育部第33号令第九条第二款', '6.7', '在答卷上填写与本人身份不符的姓名、准考证号等信息的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('17', '教育部第33号令第九条第二款', '6.8', '传、接物品或交换试卷、答卷、草稿纸的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('18', '教育部第33号令第九条第二款', '6.9', '其他以不正当手段获得或者试图获得试题答案、考试成绩的行为；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('19', '教育部第33号令第九条第二款', '7.1', '通过伪造证件、证明、档案及其他材料获得考试资格和考试成绩的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('20', '教育部第33号令第九条第二款', '7.2', '评卷过程中被认定为答案雷同的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('21', '教育部第33号令第九条第二款', '7.3', '考场纪律混乱、考试秩序失控，出现大面积考试作弊现象的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('22', '教育部第33号令第九条第二款', '7.4', '考试工作人员协助实施作弊行为，事后查实的；', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('23', '教育部第33号令第九条第二款', '7.5', '其他应认定为作弊的行为。', '其所报名参加考试的各科、各阶段成绩无效');
INSERT INTO `discipline`
VALUES ('24', '教育部第33号令第十条', '8.1', '故意扰乱考点、考场、评卷场所等考试工作场所秩序；', '终止其继续参加本科目考试，其当次报名参加考试的各科成绩无效');
INSERT INTO `discipline`
VALUES ('25', '教育部第33号令第十条', '8.2', '拒绝、妨碍考试工作人员履行管理职责；', '终止其继续参加本科目考试，其当次报名参加考试的各科成绩无效');
INSERT INTO `discipline`
VALUES ('26', '教育部第33号令第十条', '8.3', '威胁、侮辱、诽谤、诬陷或者以其他方式侵害考试工作人员、其他考生合法权益的行为；', '终止其继续参加本科目考试，其当次报名参加考试的各科成绩无效');
INSERT INTO `discipline`
VALUES ('27', '教育部第33号令第十条', '8.4', '故意损坏考场设施设备；', '终止其继续参加本科目考试，其当次报名参加考试的各科成绩无效');
INSERT INTO `discipline`
VALUES ('28', '教育部第33号令第十条', '8.5', '其他扰乱考试管理秩序的行为。', '终止其继续参加本科目考试，其当次报名参加考试的各科成绩无效');
INSERT INTO `discipline`
VALUES ('29', '教育部第33号令第九条第三款', '9.1', '组织团伙作弊的；',
        '终止其继续参加本科目考试，其所报名参加考试的各科、各阶段成绩无效。可以视情节轻重，同时给予暂停参加该项考试1至3年的处理；情节特别严重的，可以同时给予暂停参加各种国家教育考试1至3年的处理');
INSERT INTO `discipline`
VALUES ('30', '教育部第33号令第九条第三款', '9.2', '向考场外发送、传递试题信息的;',
        '终止其继续参加本科目考试，其所报名参加考试的各科、各阶段成绩无效。可以视情节轻重，同时给予暂停参加该项考试1至3年的处理；情节特别严重的，可以同时给予暂停参加各种国家教育考试1至4年的处理');
INSERT INTO `discipline`
VALUES ('31', '教育部第33号令第九条第三款', '9.3', '使用相关设备接收信息实施作弊的；',
        '终止其继续参加本科目考试，其所报名参加考试的各科、各阶段成绩无效。可以视情节轻重，同时给予暂停参加该项考试1至3年的处理；情节特别严重的，可以同时给予暂停参加各种国家教育考试1至5年的处理');
INSERT INTO `discipline`
VALUES ('32', '教育部第33号令第九条第三款', '9.4', '伪造、变造身份证、准考证及其他证明材料，由他人代替或者代替考生参加考试的。',
        '终止其继续参加本科目考试，其所报名参加考试的各科、各阶段成绩无效。可以视情节轻重，同时给予暂停参加该项考试1至3年的处理；情节特别严重的，可以同时给予暂停参加各种国家教育考试1至6年的处理');

-- ----------------------------
-- Table structure for error_type
-- ----------------------------
DROP TABLE IF EXISTS `error_type`;
CREATE TABLE `error_type`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `error_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of error_type
-- ----------------------------
INSERT INTO `error_type`
VALUES ('1', '缺考');
INSERT INTO `error_type`
VALUES ('2', '违纪');
INSERT INTO `error_type`
VALUES ('3', '异常');

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `exam_code`   varchar(255) DEFAULT NULL,
    `exam_name`   varchar(255) DEFAULT NULL,
    `school_code` varchar(255) DEFAULT NULL,
    `start_time`  datetime     DEFAULT NULL,
    `end_time`    datetime     DEFAULT NULL,
    `duration`    int(3) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`exam_code`,`school_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam`
VALUES ('7', '001', '高等数学', '10489', '2021-05-14 15:00:00', '2021-05-14 18:00:00', '180');
INSERT INTO `exam`
VALUES ('8', '002', '英语四级', '10489', '2021-05-14 14:00:00', '2021-05-14 16:30:00', '150');
INSERT INTO `exam`
VALUES ('9', '003', '英语六级', '10489', '2021-05-14 14:00:00', '2021-05-14 16:00:00', '120');
INSERT INTO `exam`
VALUES ('10', '001', '专升本-大学英语', '11072', '2021-05-14 14:00:00', '2021-05-14 16:00:00', '120');
INSERT INTO `exam`
VALUES ('11', '002', '成人教育-英语', '11072', '2021-05-14 14:00:00', '2021-05-14 16:30:00', '150');
INSERT INTO `exam`
VALUES ('12', '003', '概率论', '11072', '2021-05-14 14:00:00', '2021-05-14 16:30:00', '150');
INSERT INTO `exam`
VALUES ('13', '001', '哲学', '10495', '2021-05-14 14:00:00', '2021-05-14 16:00:00', '120');
INSERT INTO `exam`
VALUES ('14', '002', '医学基础', '10495', '2021-05-14 14:00:00', '2021-05-14 16:00:00', '120');
INSERT INTO `exam`
VALUES ('15', '003', '法学', '10495', '2021-05-14 14:00:00', '2021-05-14 14:00:00', '120');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`
(
    `client_id`               varchar(128) NOT NULL,
    `resource_ids`            varchar(128)  DEFAULT NULL,
    `client_secret`           varchar(128)  DEFAULT NULL,
    `scope`                   varchar(128)  DEFAULT NULL,
    `authorized_grant_types`  varchar(128)  DEFAULT NULL,
    `web_server_redirect_uri` varchar(128)  DEFAULT NULL,
    `authorities`             varchar(128)  DEFAULT NULL,
    `access_token_validity`   int(11) DEFAULT NULL,
    `refresh_token_validity`  int(11) DEFAULT NULL,
    `additional_information`  varchar(4096) DEFAULT NULL,
    `autoapprove`             varchar(128)  DEFAULT NULL,
    PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details`
VALUES ('client_1', null, '$2a$10$nM5FiLCOZs/H1ujBqDh2Wei6HdmsyzctLChEMwn2RU3G13CX2jv/W', 'select',
        'client_credentials', null, 'oauth2', null, null, null, null);
INSERT INTO `oauth_client_details`
VALUES ('client_2', null, '$2a$10$nM5FiLCOZs/H1ujBqDh2Wei6HdmsyzctLChEMwn2RU3G13CX2jv/W', 'server',
        'password,refresh_token', null, 'oauth2', null, null, null, null);
INSERT INTO `oauth_client_details`
VALUES ('client_3', null, '$2a$10$nM5FiLCOZs/H1ujBqDh2Wei6HdmsyzctLChEMwn2RU3G13CX2jv/W', 'select',
        'authorization_code', 'http://localhost:8848/nacos', 'oauth2', null, null, null, null);
INSERT INTO `oauth_client_details`
VALUES ('client_4', null, '$10$nM5FiLCOZs/H1ujBqDh2Wei6HdmsyzctLChEMwn2RU3G13CX2jv/W', 'server', 'implicit', null,
        'oauth2', null, null, null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`
(
    `id`            int(11) NOT NULL AUTO_INCREMENT,
    `resource_name` varchar(255) DEFAULT NULL,
    `url`           varchar(255) DEFAULT NULL,
    `method`        varchar(255) DEFAULT NULL,
    `permit_all`    bit(1)       DEFAULT b'0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `resource` (`url`,`method`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource`
VALUES ('1', '欢迎页', '/api/hello', 'get', '');
INSERT INTO `resource`
VALUES ('2', '管理页面', '/api/admin', 'get', '\0');
INSERT INTO `resource`
VALUES ('3', '测试页面', '/api/test', 'get', '\0');
INSERT INTO `resource`
VALUES ('4', '登陆页', '/page/login', 'get', '');
INSERT INTO `resource`
VALUES ('5', '首页', '/page/index', 'get', '\0');
INSERT INTO `resource`
VALUES ('6', '用户管理', '/page/user', 'get', '\0');
INSERT INTO `resource`
VALUES ('7', '角色管理', '/page/role', 'get', '\0');
INSERT INTO `resource`
VALUES ('8', '权限管理', '/page/authority', 'get', '\0');
INSERT INTO `resource`
VALUES ('9', '资源管理', '/page/resource', 'get', '\0');
INSERT INTO `resource`
VALUES ('10', '系统查询', '/system', 'get', '\0');
INSERT INTO `resource`
VALUES ('11', '系统编辑', '/system', 'post', '\0');
INSERT INTO `resource`
VALUES ('12', '系统删除', '/system', 'delete', '\0');
INSERT INTO `resource`
VALUES ('14', '欢迎页', '/page/hello', 'get', '');
INSERT INTO `resource`
VALUES ('15', 'API', '/page/api', 'get', '');
INSERT INTO `resource`
VALUES ('16', '学校管理', '/page/school', 'get', '\0');
INSERT INTO `resource`
VALUES ('17', '考场管理', '/page/exam', 'get', '\0');
INSERT INTO `resource`
VALUES ('18', '考生管理', '/page/student', 'get', '\0');
INSERT INTO `resource`
VALUES ('19', '考生统计', '/page/st-statistics', 'get', '\0');
INSERT INTO `resource`
VALUES ('20', '考务查询', '/examtool', 'get', '\0');
INSERT INTO `resource`
VALUES ('21', '考务编辑', '/examtool', 'post', '\0');
INSERT INTO `resource`
VALUES ('22', '考务删除', '/examtool', 'delete', '\0');

-- ----------------------------
-- Table structure for resource_authority
-- ----------------------------
DROP TABLE IF EXISTS `resource_authority`;
CREATE TABLE `resource_authority`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `resource_id`  int(11) DEFAULT NULL,
    `authority_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of resource_authority
-- ----------------------------
INSERT INTO `resource_authority`
VALUES ('22', '2', '1');
INSERT INTO `resource_authority`
VALUES ('23', '3', '2');
INSERT INTO `resource_authority`
VALUES ('58', '13', '1');
INSERT INTO `resource_authority`
VALUES ('59', '13', '7');
INSERT INTO `resource_authority`
VALUES ('65', '6', '1');
INSERT INTO `resource_authority`
VALUES ('66', '6', '7');
INSERT INTO `resource_authority`
VALUES ('67', '7', '1');
INSERT INTO `resource_authority`
VALUES ('68', '7', '7');
INSERT INTO `resource_authority`
VALUES ('69', '8', '1');
INSERT INTO `resource_authority`
VALUES ('70', '8', '7');
INSERT INTO `resource_authority`
VALUES ('71', '9', '1');
INSERT INTO `resource_authority`
VALUES ('72', '9', '2');
INSERT INTO `resource_authority`
VALUES ('73', '9', '7');
INSERT INTO `resource_authority`
VALUES ('80', '10', '1');
INSERT INTO `resource_authority`
VALUES ('81', '10', '7');
INSERT INTO `resource_authority`
VALUES ('82', '11', '1');
INSERT INTO `resource_authority`
VALUES ('83', '11', '7');
INSERT INTO `resource_authority`
VALUES ('84', '12', '1');
INSERT INTO `resource_authority`
VALUES ('85', '5', '1');
INSERT INTO `resource_authority`
VALUES ('86', '5', '7');
INSERT INTO `resource_authority`
VALUES ('87', '5', '2');
INSERT INTO `resource_authority`
VALUES ('88', '5', '8');
INSERT INTO `resource_authority`
VALUES ('89', '5', '9');
INSERT INTO `resource_authority`
VALUES ('91', '17', '1');
INSERT INTO `resource_authority`
VALUES ('92', '17', '8');
INSERT INTO `resource_authority`
VALUES ('99', '20', '1');
INSERT INTO `resource_authority`
VALUES ('100', '20', '8');
INSERT INTO `resource_authority`
VALUES ('101', '21', '1');
INSERT INTO `resource_authority`
VALUES ('102', '21', '8');
INSERT INTO `resource_authority`
VALUES ('103', '22', '1');
INSERT INTO `resource_authority`
VALUES ('106', '16', '1');
INSERT INTO `resource_authority`
VALUES ('107', '16', '8');
INSERT INTO `resource_authority`
VALUES ('108', '18', '1');
INSERT INTO `resource_authority`
VALUES ('109', '18', '8');
INSERT INTO `resource_authority`
VALUES ('110', '19', '1');
INSERT INTO `resource_authority`
VALUES ('111', '19', '8');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `role_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    `name`      varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role`
VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role`
VALUES ('2', 'test', '测试工程师');
INSERT INTO `role`
VALUES ('4', 'system', '系统管理员');
INSERT INTO `role`
VALUES ('7', 'visitor', '游客');
INSERT INTO `role`
VALUES ('8', 'examtool', '考务管理员');

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `role_id`      int(11) DEFAULT NULL,
    `authority_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority`
VALUES ('12', '2', '2');
INSERT INTO `role_authority`
VALUES ('14', '4', '7');
INSERT INTO `role_authority`
VALUES ('18', '1', '1');
INSERT INTO `role_authority`
VALUES ('19', '1', '2');
INSERT INTO `role_authority`
VALUES ('20', '1', '7');
INSERT INTO `role_authority`
VALUES ('24', '8', '8');
INSERT INTO `role_authority`
VALUES ('25', '7', '9');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `school_code` varchar(255) DEFAULT NULL,
    `school_name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`school_code`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school`
VALUES ('16', '10489', '长江大学');
INSERT INTO `school`
VALUES ('17', '11072', '江汉大学');
INSERT INTO `school`
VALUES ('18', '10495', '武汉纺织大学');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`              int(11) NOT NULL AUTO_INCREMENT,
    `student_name`    varchar(255) DEFAULT NULL,
    `password`        varchar(255) DEFAULT NULL,
    `identity_number` varchar(255) DEFAULT NULL,
    `ticket_number`   varchar(255) DEFAULT NULL,
    `site_number`     varchar(255) DEFAULT NULL,
    `register_number` varchar(255) DEFAULT NULL,
    `school_code`     varchar(255) DEFAULT NULL,
    `exam_code`       varchar(255) DEFAULT NULL,
    `error_type`      int(1) DEFAULT NULL,
    `discipline_code` varchar(255) DEFAULT NULL,
    `remark`          varchar(255) DEFAULT NULL,
    `action_remark`   varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `code` (`site_number`,`exam_code`,`school_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=820 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student`
VALUES ('549', '施绮菱', '1406b9', '420105200006225027', '104890000000101', '01', '104890001', '10489', '001', '2', '6.1',
        null, null);
INSERT INTO `student`
VALUES ('550', '韩迎春', 'ed1d39', '420105199910204034', '104890000000102', '02', '104890002', '10489', '001', '2', '5.1',
        null, null);
INSERT INTO `student`
VALUES ('551', '赵宏艳', '4fd0c4', '420105199901115005', '104890000000103', '03', '104890003', '10489', '001', '3', null,
        '异常的考生信息', null);
INSERT INTO `student`
VALUES ('552', '魏太群', 'a84844', '420105200010068618', '104890000000104', '04', '104890004', '10489', '001', '1', null,
        null, null);
INSERT INTO `student`
VALUES ('553', '周凡', '4dee47', '420105199906098689', '104890000000105', '05', '104890005', '10489', '001', '1', null,
        null, null);
INSERT INTO `student`
VALUES ('554', '何虹', 'fafe10', '420105200010125571', '104890000000106', '06', '104890006', '10489', '001', '2', '5.2',
        null, null);
INSERT INTO `student`
VALUES ('555', '金倩', 'caccba', '420105199904169412', '104890000000107', '07', '104890007', '10489', '001', '1', null,
        null, null);
INSERT INTO `student`
VALUES ('556', '姜莉', '9913e3', '420105200004130315', '104890000000108', '08', '104890008', '10489', '001', '3', null,
        null, null);
INSERT INTO `student`
VALUES ('557', '许银姣', '14dde3', '42010520001022481X', '104890000000109', '09', '104890009', '10489', '001', '2', '5.5',
        null, null);
INSERT INTO `student`
VALUES ('558', '吕聪', '3794e3', '420105200011265072', '104890000000110', '10', '104890010', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('559', '卫琰', '9b56a9', '420105199911252345', '104890000000111', '11', '104890011', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('560', '赵迎曼', 'b88abd', '420105199901221331', '104890000000112', '12', '104890012', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('561', '李睿敏', '39b4dc', '420105199910274999', '104890000000113', '13', '104890013', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('562', '孔小兰', '8f6def', '420105200010101641', '104890000000114', '14', '104890014', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('563', '沙桂花', '357970', '420105200006122255', '104890000000115', '15', '104890015', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('564', '褚燕', '2e97e3', '420105199903123025', '104890000000116', '16', '104890016', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('565', '钱冰彤', '4cdbb9', '420105200003023821', '104890000000117', '17', '104890017', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('566', '王开萍', '864caf', '42010519991006465X', '104890000000118', '18', '104890018', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('567', '郑莺', '1e66d8', '420105199909211296', '104890000000119', '19', '104890019', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('568', '赵凯敏', '34d7b2', '420105200010039649', '104890000000120', '20', '104890020', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('569', '陶孝洁', 'b898f9', '420105199909208775', '104890000000121', '21', '104890021', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('570', '陈芯蕊', 'a7cb99', '420105199906115186', '104890000000122', '22', '104890022', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('571', '陈怡', 'f18010', '420105200001039487', '104890000000123', '23', '104890023', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('572', '秦娅', '7b3d3e', '420105199903252855', '104890000000124', '24', '104890024', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('573', '冯念念', '59c445', '420105199903166367', '104890000000125', '25', '104890025', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('574', '蒋桂花', '956237', '420105200009152126', '104890000000126', '26', '104890026', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('575', '王武琴', 'ab8e11', '420105199901049984', '104890000000127', '27', '104890027', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('576', '何秋菊', '11d4ac', '420105199906074994', '104890000000128', '28', '104890028', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('577', '王筠', '2e6416', '420105200010063132', '104890000000129', '29', '104890029', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('578', '姜秀丽', '38ac12', '420105200011085639', '104890000000130', '30', '104890030', '10489', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('579', '李金花', 'b1d3c5', '420105200008111103', '104890000000201', '01', '104890031', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('580', '华媛元', '7639c5', '420105199903128790', '104890000000202', '02', '104890032', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('581', '赵静', 'f5a1a9', '420105199910279917', '104890000000203', '03', '104890033', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('582', '习明露', '23a055', '420105199910091623', '104890000000204', '04', '104890034', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('583', '张琰', 'a25d08', '420105199906030529', '104890000000205', '05', '104890035', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('584', '蒋静娴', 'e951fb', '420105199901102271', '104890000000206', '06', '104890036', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('585', '杨玉凤', 'e40682', '420105200007239850', '104890000000207', '07', '104890037', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('586', '褚婷', '6e2da2', '420105200004095775', '104890000000208', '08', '104890038', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('587', '蒋志桃', '026e39', '420105199901040744', '104890000000209', '09', '104890039', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('588', '尤心媛', 'b07166', '420105199904072282', '104890000000210', '10', '104890040', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('589', '陶痴梦', '691c62', '420105200006059268', '104890000000211', '11', '104890041', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('590', '沈玉晶', '17a8bf', '420105200006010704', '104890000000212', '12', '104890042', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('591', '赵雅瑄', 'efc1a3', '420105199901137116', '104890000000213', '13', '104890043', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('592', '周欣', '9e52d9', '420105199909150833', '104890000000214', '14', '104890044', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('593', '孔馨语', '421561', '420105199911104238', '104890000000215', '15', '104890045', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('594', '沈晓云', '3453ce', '420105199909221224', '104890000000216', '16', '104890046', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('595', '金欢', '3865d6', '420105199911225865', '104890000000217', '17', '104890047', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('596', '彭琦', 'c950fb', '420105199908279037', '104890000000218', '18', '104890048', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('597', '秦菜玲', '4d61b9', '420105200003153217', '104890000000219', '19', '104890049', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('598', '严琳', '6c0109', '420105200011111155', '104890000000220', '20', '104890050', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('599', '孔谷波', '3da7b7', '420105199911055798', '104890000000221', '21', '104890051', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('600', '吕书同', '088359', '42010519990907093X', '104890000000222', '22', '104890052', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('601', '云竹', '8132bb', '420105199907225491', '104890000000223', '23', '104890053', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('602', '尤筠', '58024f', '420105199901208498', '104890000000224', '24', '104890054', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('603', '魏青', 'ea6166', '42010520000225826X', '104890000000225', '25', '104890055', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('604', '褚露', '349f82', '420105199905046297', '104890000000226', '26', '104890056', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('605', '孙玉婷', 'a6616a', '420105199906092267', '104890000000227', '27', '104890057', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('606', '百里文倩', 'b12f6e', '420105199904108863', '104890000000228', '28', '104890058', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('607', '蒋敏婷', '38b629', '420105200006125325', '104890000000229', '29', '104890059', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('608', '曹金玫', 'dda3cd', '420105200011277200', '104890000000230', '30', '104890060', '10489', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('609', '施英', '33f322', '420105200007057141', '104890000000301', '01', '104890061', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('610', '谭彤', '93d9f6', '420105200005087312', '104890000000302', '02', '104890062', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('611', '戚向萍', '6ee36c', '42010519990626822X', '104890000000303', '03', '104890063', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('612', '杨晶', '4cf3d1', '420105199910222638', '104890000000304', '04', '104890064', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('613', '李功碧', 'f4872b', '420105199907109669', '104890000000305', '05', '104890065', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('614', '姜洋', 'af25dd', '420105199903238367', '104890000000306', '06', '104890066', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('615', '陈聪', '414e07', '420105200002186120', '104890000000307', '07', '104890067', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('616', '韩融', '6762b7', '420105200006028082', '104890000000308', '08', '104890068', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('617', '秦旭', '056552', '420105200006094098', '104890000000309', '09', '104890069', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('618', '周婷婷', '876272', '420105200007172756', '104890000000310', '10', '104890070', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('619', '许红燕', 'bbce0b', '420105200009194828', '104890000000311', '11', '104890071', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('620', '蒋秋荣', 'c05928', '420105200011148249', '104890000000312', '12', '104890072', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('621', '孙园', '8cf28b', '42010519990503961X', '104890000000313', '13', '104890073', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('622', '杨鑫琳', 'a1146c', '420105200001170178', '104890000000314', '14', '104890074', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('623', '张淑芬', '6e7e20', '420105199901271059', '104890000000315', '15', '104890075', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('624', '吴妍', 'ad1998', '420105200008118129', '104890000000316', '16', '104890076', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('625', '蒋琰', '95b2ba', '42010520001125333X', '104890000000317', '17', '104890077', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('626', '王花娥', '1a35cd', '420105200009120554', '104890000000318', '18', '104890078', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('627', '褚朱婷', '55a6cd', '420105199907019671', '104890000000319', '19', '104890079', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('628', '吕之山', 'a1460a', '420105200004068646', '104890000000320', '20', '104890080', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('629', '蒋有菊', '7f5047', '420105200010197866', '104890000000321', '21', '104890081', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('630', '陈彩菊', '0d01a6', '420105200001211814', '104890000000322', '22', '104890082', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('631', '施婉', 'd88d1c', '420105199906219575', '104890000000323', '23', '104890083', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('632', '郁小珍', '859ec1', '420105200003183845', '104890000000324', '24', '104890084', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('633', '魏静娴', '5ee586', '420105200008230196', '104890000000325', '25', '104890085', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('634', '何亚', '2c70d1', '420105200003239741', '104890000000326', '26', '104890086', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('635', '吴彩艳', '50532f', '420105199906245095', '104890000000327', '27', '104890087', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('636', '冯春喜', '3c1c4c', '42010520000618603X', '104890000000328', '28', '104890088', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('637', '牟夏梅', 'fe9f8e', '420105199909133144', '104890000000329', '29', '104890089', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('638', '冯倩', '192870', '420105200011197913', '104890000000330', '30', '104890090', '10489', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('639', '戚金玫', 'd4d5b3', '420105199908016077', '110720000000101', '01', '110720001', '11072', '001', '1', null,
        null, null);
INSERT INTO `student`
VALUES ('640', '周纨', '95915f', '420105199901176975', '110720000000102', '02', '110720002', '11072', '001', '2', '5.2',
        null, null);
INSERT INTO `student`
VALUES ('641', '淳于冰露', 'd69922', '420105200001212657', '110720000000103', '03', '110720003', '11072', '001', '3', null,
        '异常222', null);
INSERT INTO `student`
VALUES ('642', '陶幻波', '78779a', '420105199907179464', '110720000000104', '04', '110720004', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('643', '秦梓涵', 'f2cb42', '420105200003265293', '110720000000105', '05', '110720005', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('644', '尤寻文', '1c964b', '420105199911194042', '110720000000106', '06', '110720006', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('645', '姜成龙', '85c79d', '420105200005114341', '110720000000107', '07', '110720007', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('646', '金娟', '85015f', '420105200012214427', '110720000000108', '08', '110720008', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('647', '沈雪梅', '20b1fb', '420105199903058518', '110720000000109', '09', '110720009', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('648', '雷良翠', 'b6a535', '420105199911207771', '110720000000110', '10', '110720010', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('649', '钱绮菱', 'a4b9c4', '420105199906187788', '110720000000111', '11', '110720011', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('650', '金婷', '99c9d3', '420105200007068115', '110720000000112', '12', '110720012', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('651', '魏梓涵', 'e58ea3', '420105200008082891', '110720000000113', '13', '110720013', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('652', '李粤', 'a6482a', '420105200005176286', '110720000000114', '14', '110720014', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('653', '吴枝', '3e09c6', '420105199908124289', '110720000000115', '15', '110720015', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('654', '陈蓓', '40def7', '420105199904058245', '110720000000116', '16', '110720016', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('655', '杨招弟', '94e722', '420105200011221113', '110720000000117', '17', '110720017', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('656', '施敏茹', 'fd76b1', '420105200004160557', '110720000000118', '18', '110720018', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('657', '陶秋', '2ec843', '420105200005073607', '110720000000119', '19', '110720019', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('658', '韩咏', '5c032b', '420105200004027369', '110720000000120', '20', '110720020', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('659', '朱发弟', '758b90', '420105199905133841', '110720000000121', '21', '110720021', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('660', '姜雅瑄', '34c04a', '420105200005045261', '110720000000122', '22', '110720022', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('661', '李枫', 'd866e8', '420105200007186592', '110720000000123', '23', '110720023', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('662', '何枫', '0763af', '420105199907276328', '110720000000124', '24', '110720024', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('663', '沈冰露', '1b0395', '42010519990313345X', '110720000000125', '25', '110720025', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('664', '家春文', '816c3c', '420105200002253469', '110720000000126', '26', '110720026', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('665', '云旭', '0290bf', '420105200009051608', '110720000000127', '27', '110720027', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('666', '王明艳', '0e3c87', '420105200001252683', '110720000000128', '28', '110720028', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('667', '张紫萱', '267598', '420105199905191013', '110720000000129', '29', '110720029', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('668', '王丽', '9a9dae', '42010519991106167X', '110720000000130', '30', '110720030', '11072', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('669', '严计香', '111154', '420105199902203111', '110720000000201', '01', '110720031', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('670', '蒋启英', '0de970', '420105200010018311', '110720000000202', '02', '110720032', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('671', '卫姚', 'a2f901', '420105199911192944', '110720000000203', '03', '110720033', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('672', '杨静', 'd91e8d', '420105200007062960', '110720000000204', '04', '110720034', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('673', '杨树平', '29862e', '420105199901170557', '110720000000205', '05', '110720035', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('674', '吕代云', '7ef816', '420105200007116930', '110720000000206', '06', '110720036', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('675', '孔亦寒', 'cc54ce', '42010519990525896X', '110720000000207', '07', '110720037', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('676', '蒋兰兰', '79c01b', '420105199905257334', '110720000000208', '08', '110720038', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('677', '曹红燕', '723adf', '420105199905053657', '110720000000209', '09', '110720039', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('678', '田飘', '7a7db6', '420105199908152597', '110720000000210', '10', '110720040', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('679', '陈梦', 'f81360', '42010519990802961X', '110720000000211', '11', '110720041', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('680', '冯蓓', '864d66', '420105199901104832', '110720000000212', '12', '110720042', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('681', '秦文倩', 'e616d0', '420105199910245637', '110720000000213', '13', '110720043', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('682', '魏婉', '714a97', '420105200003033118', '110720000000214', '14', '110720044', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('683', '吕柳', '94ad0b', '420105199901103282', '110720000000215', '15', '110720045', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('684', '杨巧丽', 'fcc8aa', '420105199911051148', '110720000000216', '16', '110720046', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('685', '陶彤', '560374', '420105200006201375', '110720000000217', '17', '110720047', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('686', '朱访琴', '3d3183', '420105199911226948', '110720000000218', '18', '110720048', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('687', '钱雨祺', '91674c', '420105199906224120', '110720000000219', '19', '110720049', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('688', '王宗莉', '24f96e', '420105199908181830', '110720000000220', '20', '110720050', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('689', '魏甜', 'fdaf3b', '420105200007161344', '110720000000221', '21', '110720051', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('690', '沈秀丽', 'cd3d69', '420105199903250177', '110720000000222', '22', '110720052', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('691', '尤夏梅', '4dde65', '420105200003194595', '110720000000223', '23', '110720053', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('692', '王世兰', '375eda', '420105199909131253', '110720000000224', '24', '110720054', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('693', '秦桂花', '14b9b9', '42010519990325333X', '110720000000225', '25', '110720055', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('694', '孙光萍', '926485', '420105200008094059', '110720000000226', '26', '110720056', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('695', '赵勤', 'fb7f45', '42010520001123215X', '110720000000227', '27', '110720057', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('696', '沈莎', 'ba9d0b', '420105199906204920', '110720000000228', '28', '110720058', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('697', '孔玉凤', 'd36cdc', '420105200011141530', '110720000000229', '29', '110720059', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('698', '华英', '897f2c', '420105200006231232', '110720000000230', '30', '110720060', '11072', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('699', '蒋水云', '7e0a70', '420105199903133743', '110720000000301', '01', '110720061', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('700', '卫晶', 'f47d7e', '420105199906162898', '110720000000302', '02', '110720062', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('701', '吕平夏', '2cdd8b', '420105199907033297', '110720000000303', '03', '110720063', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('702', '王大秀', '04a2dd', '420105199904073154', '110720000000304', '04', '110720064', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('703', '吴文静', 'aadd75', '420105199901172333', '110720000000305', '05', '110720065', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('704', '郑蕊', 'd9f056', '420105199901204446', '110720000000306', '06', '110720066', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('705', '金谷山', 'c3133c', '420105200004267338', '110720000000307', '07', '110720067', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('706', '云虹', 'b2a350', '420105200005048284', '110720000000308', '08', '110720068', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('707', '褚宁', '7cc53d', '420105199909082009', '110720000000309', '09', '110720069', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('708', '杨红萍', '79138c', '420105199909236004', '110720000000310', '10', '110720070', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('709', '魏翠红', 'd88440', '420105200011258325', '110720000000311', '11', '110720071', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('710', '张玉婷', '696881', '42010519990210798X', '110720000000312', '12', '110720072', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('711', '王娟', '236cf8', '420105200007046872', '110720000000313', '13', '110720073', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('712', '王荷', '7aa674', '420105200005027432', '110720000000314', '14', '110720074', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('713', '许发弟', '05977a', '420105199903084716', '110720000000315', '15', '110720075', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('714', '张成龙', '97ff0e', '420105200011234948', '110720000000316', '16', '110720076', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('715', '沈恩珍', '2cbf5c', '420105199901220384', '110720000000317', '17', '110720077', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('716', '吴溶艳', '963d74', '420105200004304236', '110720000000318', '18', '110720078', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('717', '李元珊', '74716d', '420105200004104117', '110720000000319', '19', '110720079', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('718', '施蓉', '50ff08', '420105199910180538', '110720000000320', '20', '110720080', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('719', '吕乐萱', 'd499fd', '420105199905180496', '110720000000321', '21', '110720081', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('720', '曹心菲', 'aeefd4', '42010520000426492X', '110720000000322', '22', '110720082', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('721', '韩睿婕', 'b321fb', '420105200003204204', '110720000000323', '23', '110720083', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('722', '褚启英', '0cd857', '420105200010067172', '110720000000324', '24', '110720084', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('723', '严名媛', 'c88b3d', '420105199903141055', '110720000000325', '25', '110720085', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('724', '李妍', 'b3726a', '420105200009045610', '110720000000326', '26', '110720086', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('725', '翟迎曼', '64773c', '420105199908266789', '110720000000327', '27', '110720087', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('726', '孔静欣', 'e9e60c', '420105199911276945', '110720000000328', '28', '110720088', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('727', '吕兰兰', 'ac77ce', '420105199908146111', '110720000000329', '29', '110720089', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('728', '曹佳', 'ea4e62', '420105199902034215', '110720000000330', '30', '110720090', '11072', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('729', '周秋', 'a40ae5', '420105199901013981', '104950000000101', '01', '104950001', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('730', '何小珍', '31ea24', '420105200005047118', '104950000000102', '02', '104950002', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('731', '李珍', '68d5a4', '420105199905082490', '104950000000103', '03', '104950003', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('732', '卫桂兰', '15c698', '420105200002117547', '104950000000104', '04', '104950004', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('733', '杨竹', 'f59f7a', '42010520000811606X', '104950000000105', '05', '104950005', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('734', '孙婉', 'ab3b41', '420105199901148763', '104950000000106', '06', '104950006', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('735', '魏锦', 'e67c51', '420105199911279206', '104950000000107', '07', '104950007', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('736', '华朱娇', '7682ba', '420105200001262582', '104950000000108', '08', '104950008', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('737', '钱淇', '945b5b', '420105200007180334', '104950000000109', '09', '104950009', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('738', '鲁丹', 'c58e71', '42010519990422459X', '104950000000110', '10', '104950010', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('739', '曹火英', '321f04', '420105200005012425', '104950000000111', '11', '104950011', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('740', '魏珊', '70cbd6', '420105199902087296', '104950000000112', '12', '104950012', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('741', '沈丽丽', 'b7305c', '420105199907050505', '104950000000113', '13', '104950013', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('742', '沈叶', '04c3dc', '420105200004168479', '104950000000114', '14', '104950014', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('743', '乐正婷婷', '809643', '420105199911096688', '104950000000115', '15', '104950015', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('744', '孔兴', 'e7fbf4', '420105199909275134', '104950000000116', '16', '104950016', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('745', '周紫君', 'f6736f', '420105199907229353', '104950000000117', '17', '104950017', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('746', '许洋', '823429', '420105199910266796', '104950000000118', '18', '104950018', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('747', '吴聪', '61ad50', '42010520000319005X', '104950000000119', '19', '104950019', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('748', '何晶', 'cdd4d2', '420105200004245091', '104950000000120', '20', '104950020', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('749', '严丹珍', 'fa984f', '420105199903095722', '104950000000121', '21', '104950021', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('750', '富子鑫', '2c070d', '420105199911024465', '104950000000122', '22', '104950022', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('751', '沈侦', '586d3c', '420105199910109029', '104950000000123', '23', '104950023', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('752', '曹红恋', 'eab0e4', '420105200003024634', '104950000000124', '24', '104950024', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('753', '朱欢', 'cefb84', '420105199910112586', '104950000000125', '25', '104950025', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('754', '陈婷婷', 'b145b8', '420105199910199546', '104950000000126', '26', '104950026', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('755', '容南莲', '57c9cc', '420105200005269247', '104950000000127', '27', '104950027', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('756', '赵子鑫', '0645ac', '420105199907174487', '104950000000128', '28', '104950028', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('757', '孙迎曼', '01d178', '420105200004141700', '104950000000129', '29', '104950029', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('758', '任念', 'f3bce3', '420105199907233707', '104950000000130', '30', '104950030', '10495', '001', null, null,
        null, null);
INSERT INTO `student`
VALUES ('759', '周薇', '689b25', '420105200006126205', '104950000000201', '01', '104950031', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('760', '张苑', '619236', '42010519991013200X', '104950000000202', '02', '104950032', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('761', '汲明珠', '06e8c5', '420105199908025862', '104950000000203', '03', '104950033', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('762', '鞠笑白', 'a19d40', '420105199907062696', '104950000000204', '04', '104950034', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('763', '何光桃', 'f6dae9', '420105199911014953', '104950000000205', '05', '104950035', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('764', '彭菲', 'b38b17', '420105200008141783', '104950000000206', '06', '104950036', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('765', '王秀', '9b94a9', '42010520001005200X', '104950000000207', '07', '104950037', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('766', '蒋翡翠', 'e97fa6', '420105199906073692', '104950000000208', '08', '104950038', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('767', '张丽', 'b7c97f', '420105199903178106', '104950000000209', '09', '104950039', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('768', '冯艳红', 'faafc6', '420105200011102136', '104950000000210', '10', '104950040', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('769', '魏开凤', '58066b', '420105200006223080', '104950000000211', '11', '104950041', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('770', '姜兰燕', '56fd92', '420105200004011201', '104950000000212', '12', '104950042', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('771', '穆香薇', '14ba12', '420105200004216848', '104950000000213', '13', '104950043', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('772', '严艳', '05fb7e', '420105199902212616', '104950000000214', '14', '104950044', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('773', '何凡', 'af0f15', '420105199906236877', '104950000000215', '15', '104950045', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('774', '孙燕', '0bf723', '420105200002263341', '104950000000216', '16', '104950046', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('775', '孔红', '740645', '420105199911223034', '104950000000217', '17', '104950047', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('776', '鲍元群', 'e82b33', '420105200005035838', '104950000000218', '18', '104950048', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('777', '戚雪', 'ff846b', '420105200007259886', '104950000000219', '19', '104950049', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('778', '陶嘉', '7f1a04', '420105200003115906', '104950000000220', '20', '104950050', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('779', '陈水云', 'ca665b', '420105199905233500', '104950000000221', '21', '104950051', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('780', '姜娅', '162215', '420105200010265533', '104950000000222', '22', '104950052', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('781', '沈秀芳', '0b00a7', '420105200011204730', '104950000000223', '23', '104950053', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('782', '褚翠红', 'f130c2', '420105200001121800', '104950000000224', '24', '104950054', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('783', '尤敏', '244afb', '420105200008171421', '104950000000225', '25', '104950055', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('784', '周兰兰', 'd9e9fe', '420105199910094584', '104950000000226', '26', '104950056', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('785', '朱颖', '36b0a3', '420105200003127480', '104950000000227', '27', '104950057', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('786', '鲁彩霞', 'e02274', '420105199904158318', '104950000000228', '28', '104950058', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('787', '曹思', 'a406af', '420105199909054198', '104950000000229', '29', '104950059', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('788', '陈之念', '6e6a11', '420105199909213427', '104950000000230', '30', '104950060', '10495', '002', null, null,
        null, null);
INSERT INTO `student`
VALUES ('789', '蒋美娟', '283c01', '420105199904068646', '104950000000301', '01', '104950061', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('790', '严甜', '0f0182', '420105200002214445', '104950000000302', '02', '104950062', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('791', '卫蓉', '7fcdd0', '420105199908122742', '104950000000303', '03', '104950063', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('792', '金朱娇', 'd9d40d', '420105200003157264', '104950000000304', '04', '104950064', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('793', '尤千萍', '0741a5', '420105199905118457', '104950000000305', '05', '104950065', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('794', '朱昌玉', '584722', '420105199903044554', '104950000000306', '06', '104950066', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('795', '孙成龙', '2a7792', '420105200004239422', '104950000000307', '07', '104950067', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('796', '褚苑', 'c8a5a2', '420105200004258095', '104950000000308', '08', '104950068', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('797', '杨黛', '30cd18', '420105199910132755', '104950000000309', '09', '104950069', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('798', '陶海莲', '861e50', '420105199904112897', '104950000000310', '10', '104950070', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('799', '华傲文', 'f87eaf', '420105199906141683', '104950000000311', '11', '104950071', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('800', '褚婉', '963f0f', '420105199907187720', '104950000000312', '12', '104950072', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('801', '郑心菲', 'f31572', '420105199907108041', '104950000000313', '13', '104950073', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('802', '钱锦', 'd0c500', '420105199904250251', '104950000000314', '14', '104950074', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('803', '李大秀', '854690', '420105200002221202', '104950000000315', '15', '104950075', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('804', '姜宁', '247536', '42010520000313295X', '104950000000316', '16', '104950076', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('805', '许心菲', '640992', '420105200004169711', '104950000000317', '17', '104950077', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('806', '杨灿怡', 'ed12de', '420105200009210138', '104950000000318', '18', '104950078', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('807', '秦纨', '54e4e8', '420105200004014511', '104950000000319', '19', '104950079', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('808', '云梦娇', '297bbd', '420105199910268580', '104950000000320', '20', '104950080', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('809', '周胜敏', 'b03769', '420105199907180975', '104950000000321', '21', '104950081', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('810', '何太红', 'f4a16c', '420105200011077903', '104950000000322', '22', '104950082', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('811', '孔心菲', '370419', '420105199903227705', '104950000000323', '23', '104950083', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('812', '娄小兰', '5ffd14', '420105200007017131', '104950000000324', '24', '104950084', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('813', '孔露', '5df82f', '420105199902049679', '104950000000325', '25', '104950085', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('814', '赵惜雪', 'bdeed7', '420105199911164951', '104950000000326', '26', '104950086', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('815', '卫夏梅', 'f2bdf3', '420105200003277040', '104950000000327', '27', '104950087', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('816', '顾甜', '8d6ffd', '420105200005171629', '104950000000328', '28', '104950088', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('817', '吕梦', '3a2d11', '420105200004034841', '104950000000329', '29', '104950089', '10495', '003', null, null,
        null, null);
INSERT INTO `student`
VALUES ('818', '孙芳', 'bb316c', '420105199910016201', '104950000000330', '30', '104950090', '10495', '003', null, null,
        null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    `password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    `name`     varchar(255) CHARACTER SET utf8 DEFAULT NULL,
    `enabled`  bit(1)                          DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES ('1', 'admin', '123456', 'admin', '');
INSERT INTO `user`
VALUES ('2', 'qinchao', '123456', '覃某', '');
INSERT INTO `user`
VALUES ('3', 'test2', '123456', '测试1', '');
INSERT INTO `user`
VALUES ('4', 'system', '123456', '系统管理员', '');
INSERT INTO `user`
VALUES ('5', 'examtool', '123456', '考务员1', '');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) DEFAULT NULL,
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role`
VALUES ('46', '22', '1');
INSERT INTO `user_role`
VALUES ('47', '22', '2');
INSERT INTO `user_role`
VALUES ('48', '22', '4');
INSERT INTO `user_role`
VALUES ('51', '65', '2');
INSERT INTO `user_role`
VALUES ('52', '65', '4');
INSERT INTO `user_role`
VALUES ('53', '65', '7');
INSERT INTO `user_role`
VALUES ('54', '64', '1');
INSERT INTO `user_role`
VALUES ('55', '64', '2');
INSERT INTO `user_role`
VALUES ('56', '64', '4');
INSERT INTO `user_role`
VALUES ('57', '2', '7');
INSERT INTO `user_role`
VALUES ('58', '4', '4');
INSERT INTO `user_role`
VALUES ('59', '5', '8');
INSERT INTO `user_role`
VALUES ('61', '3', '2');
INSERT INTO `user_role`
VALUES ('62', '1', '1');
