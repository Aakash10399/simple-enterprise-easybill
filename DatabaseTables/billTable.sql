CREATE TABLE IF NOT EXISTS `billTable` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`GSTIN` varchar(100) NOT NULL,
`products` varchar(3000) NOT NULL,
`sgst` varchar(3000) NOT NULL,
`cgst` varchar(3000) NOT NULL,
`price` varchar(3000) NOT NULL,
`quantity` varchar(3000) NOT NULL, 
PRIMARY KEY (`id`),
UNIQUE KEY `GSTIN` (`GSTIN`)
);