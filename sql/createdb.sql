

CREATE TABLE `correntista` (
  `idcorrentista` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpfCnpj` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`idcorrentista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE `conta` (
  `idconta` int(11) NOT NULL,
  `agencia` int(11) DEFAULT NULL,
  `dac_agencia` int(11) DEFAULT NULL,
  `conta` int(11) DEFAULT NULL,
  `dac_conta` int(11) DEFAULT NULL,
  `idcorrentista` int(11) DEFAULT NULL,
  PRIMARY KEY (`idconta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



