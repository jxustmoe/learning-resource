CREATE TABLE IF NOT EXISTS `category` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `pid` int(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
CREATE TABLE IF NOT EXISTS `resource` (
  `id` INT(50) NOT NULL AUTO_INCREMENT,
  `name` CHAR(50) DEFAULT NULL,
  `categoryid` CHAR(50) DEFAULT NULL,
  `link` CHAR(255) DEFAULT NULL,
  `uploadtime` CHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;