
USE bluebank;

DROP TABLE correntista;
DROP TABLE conta;
DROP TABLE saldo;
DROP TABLE transferencia;

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


CREATE TABLE `saldo` (
  `idsaldo` int(11) NOT NULL,
  `idcorrentista` int(11) DEFAULT NULL,
  `valor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsaldo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `transferencia` (
  `idtransferencia` int(11) NOT NULL,
  `idcorrentista_origem` int(11) DEFAULT NULL,
  `idcorrentista_destino` int(11) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `efetuada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtransferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


insert into correntista values (1, 'Ana Maria','58424255135'); 
insert into correntista values (2, 'Maria Luiza','38521876300'); 
insert into correntista values (3, 'Osvaldo Silva','33165275670'); 





