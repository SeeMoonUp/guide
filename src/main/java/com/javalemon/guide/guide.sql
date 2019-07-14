create DATABASE guide;
use guide;
CREATE TABLE `guide_message` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `content` varchar(32) NOT NULL,
  `sendUserId` INT(32) NOT NULL,
  `sendUserName` varchar(32) NOT NULL,
  `receiveUserId` INT(32) NOT NULL,
  `createTime` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;