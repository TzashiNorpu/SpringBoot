-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id`       INT(11) NOT NULL AUTO_INCREMENT,
  `lastName` VARCHAR(255)     DEFAULT NULL,
  `email`    VARCHAR(255)     DEFAULT NULL,
  `gender`   INT(2)           DEFAULT NULL,
  `d_id`     INT(11)          DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

INSERT INTO employee(lastName,email,gender,d_id) VALUES ('Tzashinorpu','123@qq.com',1,1);
INSERT INTO employee(lastName,email,gender,d_id) VALUES ('Tseringlobsong','456@qq.com',1,0);
