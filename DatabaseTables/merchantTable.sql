CREATE TABLE IF NOT EXISTS `merchantTable` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`merchantName` varchar(3000) NOT NULL,
`uid` varchar(100) NOT NULL,
`pass` varchar(3000) NOT NULL,
`products` varchar(3000) NOT NULL,
`sgst` varchar(3000) NOT NULL,
`cgst` varchar(3000) NOT NULL,
`price` varchar(3000) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `uid` (`uid`)
);