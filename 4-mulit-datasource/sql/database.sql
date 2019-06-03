DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `value` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 分别插入主库，从库
INSERT INTO `test` (`id`, `value`) VALUES ('1', '从库');
INSERT INTO `test` (`id`, `value`) VALUES ('1', '主库');
