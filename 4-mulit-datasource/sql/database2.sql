CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `test`.`test` (`id`, `value`) VALUES ('1', '张三');
INSERT INTO `test`.`test` (`id`, `value`) VALUES ('2', '李四');
INSERT INTO `test`.`test` (`id`, `value`) VALUES ('4', '赵六');
