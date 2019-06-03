
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `value` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `biz`.`test` (`id`, `value`) VALUES ('3', '从库');

