use test;


select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_name developer,a.employ_name tester,qa_creationdt,qa_updatedt,bug_deleted_flag
from qa_buglist
join qa_project on bug_project_id = project_id  
join qa_crtype on cr_id = bug_cr_type_id  
join qa_rtype on object_id = qa_type_id  
join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   
join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  
where bug_deleted_flag =0 order by 1 desc


select count(1)
from qa_buglist
join qa_project on bug_project_id = project_id  
join qa_crtype on cr_id = bug_cr_type_id  
join qa_rtype on object_id = qa_type_id  
join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   
join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  
where bug_deleted_flag =0 

SELECT * FROM QA_BUGLIST;

CREATE TABLE `QA_BUGLIST`(
`BUG_ID` int(4) NOT NULL AUTO_INCREMENT,
`BUG_PROJECT_ID` int,
`BUG_CR_TYPE_ID` int,
`BUG_CR_NUM` VARCHAR(100),
`BUG_TASK_NUM` VARCHAR(100),
`QA_TYPE_ID` int,
`BUG_DESCRIPTION` VARCHAR(2000),
`BUG_RCA` VARCHAR(2000),
`BUG_SOLUTION` VARCHAR(2000),
`QA_ASSIGNEE_ID` int,
`QA_TESTER_ID` int,
`QA_CREATIONDT` datetime,
`QA_UPDATEDT` datetime,
`BUG_DELETED_FLAG` BIT default 0,
`BUG_DELETED_COMMENT` VARCHAR(100),
PRIMARY KEY (`BUG_ID`)
)ENGINE=InnoDB AUTO_INCREMENT=300;

alter table qa_buglist add column bug_status_id int default 1 not null 

ALTER TABLE `article`
ADD CONSTRAINT `fk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `QA_BUGLIST`  ADD  CONSTRAINT `FK_BUG_PROJECT` FOREIGN KEY(`BUG_PROJECT_ID`) REFERENCES `QA_PROJECT` (`PROJECT_ID`);
ALTER TABLE QA_BUGLIST  ADD  CONSTRAINT `FK_BUG_CR_TYPE` FOREIGN KEY(BUG_CR_TYPE_ID) REFERENCES `QA_CRTYPE` (`CR_ID`);
ALTER TABLE QA_BUGLIST  ADD  CONSTRAINT `FK_BUG_QA_TYPE_ID` FOREIGN KEY(QA_TYPE_ID) REFERENCES `QA_RTYPE` (OBJECT_ID);
ALTER TABLE QA_BUGLIST   ADD  CONSTRAINT `FK_BUG_ASSIGN_ID` FOREIGN KEY(`QA_ASSIGNEE_ID`) REFERENCES QA_EMPLOY (EMPLOY_ID);
ALTER TABLE QA_BUGLIST ADD  CONSTRAINT `FK_BUG_qa_ID` FOREIGN KEY(`QA_TESTER_ID`) REFERENCES QA_EMPLOY (EMPLOY_ID);


SELECT * FROM QA_BUGLIST;

INSERT QA_BUGLIST(BUG_PROJECT_ID,BUG_CR_TYPE_ID,BUG_CR_NUM,BUG_TASK_NUM,QA_TYPE_ID,BUG_DESCRIPTION,BUG_RCA,BUG_SOLUTION,QA_ASSIGNEE_ID,QA_TESTER_ID,QA_CREATIONDT,QA_UPDATEDT)
VALUES(3,2,NULL,'',3,'注册接口存在幂等性问题','唯一键','jiejue',1,27,curdate(),curdate());




INSERT QA_PROJECT(PROJECT_NAME,PROJECT_CREATION_DT,PROJECT_UPDATE_DT,PROJECT_DELETED_FLAG)
VALUES('alimama',now(),now(),0)


SELECT * FROM QA_PROJECT;
SELECT * FROM QA_CRTYPE;
SELECT * FROM QA_RTYPE;
SELECT * FROM QA_EMPLOY;


CREATE TABLE `QA_BUGSTATUS` (
`STATUS_ID` INT NOT NULL AUTO_INCREMENT,
`STATUS_DES` VARCHAR(100),
`STATUS_CREATION_DT` DATE,
`STATUS_UPDATE_DT` DATE,
`STATUS_DELETED_FLAG` BIT DEFAULT 0,
PRIMARY KEY (`STATUS_ID`)
)ENGINE=INNODB AUTO_INCREMENT=1;


CREATE TABLE `QA_PROJECT` (
`PROJECT_ID` INT NOT NULL AUTO_INCREMENT,
`PROJECT_NAME` VARCHAR(100),
`PROJECT_CREATION_DT` DATE,
`PROJECT_UPDATE_DT` DATE,
`PROJECT_DELETED_FLAG` BIT default 0,
PRIMARY KEY (`PROJECT_ID`)
)ENGINE=InnoDB AUTO_INCREMENT=1;


INSERT QA_CRTYPE(CR_NAME,CR_CREATION_DT,CR_UPDATE_DT) VALUES('内部不收费CR',curdate(),curdate());
INSERT QA_CRTYPE(CR_NAME,CR_CREATION_DT,CR_UPDATE_DT) VALUES('标准收费CR',curdate(),curdate());
INSERT QA_CRTYPE(CR_NAME,CR_CREATION_DT,CR_UPDATE_DT) VALUES('bugFix CR',curdate(),curdate());


CREATE TABLE `QA_CRTYPE` (
`CR_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`CR_NAME` VARCHAR(100),
`CR_CREATION_DT` DATE,
`CR_UPDATE_DT` DATE,
`CR_DELETED_FLAG` BIT default 0)
ENGINE=InnoDB AUTO_INCREMENT=1;





SELECT * FROM QA_EMPLOY;
SELECT * FROM QA_RTYPE;

SET SQL_SAFE_UPDATES = 0;
update QA_EMPLOY set employ_group =2 where EMPLOY_NAME =  '张三';

INSERT into  `QA_EMPLOY`(`EMPLOY_NAME`,`EMPLOY_CREATION_DT`,`EMPLOY_UPDATE_DT`) VALUES('张三',curdate(),curdate());
INSERT into  `QA_EMPLOY`(`EMPLOY_NAME`,`EMPLOY_CREATION_DT`,`EMPLOY_UPDATE_DT`) VALUES('李四',curdate(),curdate());

INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('UAT测试','20181204','20181204') ;
INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('proc测试','20181204','20181204') ;
INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('api测试','20181204','20181204') ;
INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('性能测试','20181204','20181204') ;
INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('ui测试','20181204','20181204') ;
INSERT QA_RTYPE(OBJECT_NAME,OBJECT_CREATION_DT,OBJECT_UPDATE_DT) VALUES('自动化测试','20181204','20181204') ;


CREATE TABLE `QA_RTYPE` (
`OBJECT_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`OBJECT_NAME` VARCHAR(100),
`OBJECT_CREATION_DT` DATE,
`OBJECT_UPDATE_DT` DATE,
`OBJECT_DELETED_FLAG` BIT DEFAULT 0)
ENGINE=InnoDB AUTO_INCREMENT=1;


##DROP TABLE  QA_RTYPE

CREATE TABLE `QA_EMPLOY` (
`EMPLOY_ID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`EMPLOY_NAME` VARCHAR(100),
`EMPLOY_CREATION_DT` date,
`EMPLOY_UPDATE_DT` date,
`EMPLOY_DELETED_FLAG` BIT default 0)
ENGINE=InnoDB AUTO_INCREMENT=1;


ALTER TABLE QA_EMPLOY ADD EMPLOY_GROUP INT DEFAULT 1;
####增加了一个字段，将测试和开发人员放在同一张表中


SELECT PROJECT_NAME,CR_NAME,BUG_CR_NUM,BUG_TASK_NUM,OBJECT_NAME,BUG_DESCRIPTION
,BUG_RCA,BUG_SOLUTION
###B.EMPLOY_NAME,QA_ASSIGNEE_ID,
###A.EMPLOY_NAME,QA_TESTER_ID
,QA_CREATIONDT,QA_UPDATEDT
FROM QA_BUGLIST
JOIN  QA_PROJECT ON BUG_PROJECT_ID = PROJECT_ID
JOIN  QA_CRTYPE ON CR_ID = BUG_CR_TYPE_ID
JOIN  QA_RTYPE ON OBJECT_ID = QA_TYPE_ID
JOIN QA_EMPLOY A ON A.`EMPLOY_ID` = QA_TESTER_ID AND A.`EMPLOY_GROUP` = 1  ###表示测试
JOIN QA_EMPLOY  B ON B.`EMPLOY_ID` = QA_ASSIGNEE_ID AND B.`EMPLOY_GROUP` = 2   ###表示开发人员
;





SELECT *
FROM QA_BUGLIST  JOIN QA_PROJECT ON BUG_PROJECT_ID = PROJECT_ID
JOIN QA_CRTYPE ON CR_ID = BUG_CR_TYPE_ID
JOIN QA_RTYPE ON OBJECT_ID = QA_TYPE_ID
JOIN QA_EMPLOY A ON A.EMPLOY_ID = QA_TESTER_ID AND A.EMPLOY_GROUP = 1
JOIN QA_EMPLOY B ON B.EMPLOY_ID= QA_ASSIGNEE_ID AND B.EMPLOY_GROUP = 2
WHERE BUG_DELETED_FLAG =0





SELECT * FROM QA_PROJECT;
SELECT * FROM QA_CRTYPE;
SELECT * FROM QA_RTYPE;
SELECT * FROM QA_EMPLOY;

update qa_project set PROJECT_NAME = '宜家' where project_id =1;
update qa_project set PROJECT_NAME = '香奈儿' where project_id =2;
update qa_project set PROJECT_NAME = '欧莱雅' where project_id =3;
update qa_project set PROJECT_NAME = '联合利华' where project_id =4;
update qa_project set PROJECT_NAME = '博西' where project_id =5;
update qa_project set PROJECT_NAME = '熙地港' where project_id =6;
update qa_project set PROJECT_NAME = '家乐福' where project_id =7;
update qa_project set PROJECT_NAME = '阿里巴巴' where project_id =8;
update qa_project set PROJECT_NAME = '阿里妈妈' where project_id =9;
update qa_project set PROJECT_NAME = '匡威' where project_id =10;
update qa_project set PROJECT_NAME = '蔻驰' where project_id =11;
update qa_project set PROJECT_NAME = '美宝莲' where project_id =12;
update qa_project set PROJECT_NAME = '3ce' where project_id =13;




=========================================
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT '' COMMENT '昵称',
  `roles` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '身份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'anoy', 'pwd', 'anoy', 'ROLE_USER'), ('2', 'admin', 'pwd', 'admin', 'ROLE_USER,ROLE_ADMIN');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;


update user set password = '$2a$10$A4EZrzoXqj4mVyXiw/fsp.mJ.Ne5aVAMWrMK0mAb2zY7lJ/H6Jryi'






