SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', '11');
INSERT INTO `user` VALUES ('2', 'ls', '12');

use test

drop table if exists user;

CREATE TABLE `user` (
  id tinyint(4) NOT NULL AUTO_INCREMENT,
  name varchar(200) NOT NULL,
  age int(11) NOT NULL,、
	phone varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
	flag int(4)
	
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


select * from user
desc user;
