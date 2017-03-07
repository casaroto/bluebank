
use mysql;

CREATE USER blue;

update user set host = 'localhost' where user='blue';

update user set password=PASSWORD('6945') where User='blue';

set password for 'blue'@'localhost' = PASSWORD('6945'); 

FLUSH PRIVILEGES;

GRANT ALL PRIVILEGES ON * . * TO 'blue'@'localhost';

CREATE DATABASE bluebank;

USE bluebank;


CREATE TABLE `correntista` (
  `idcorrentista` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpfCnpj` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`idcorrentista`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `conta` (
  `idconta` int(11) NOT NULL,
  `idcorrentista` int(11) DEFAULT NULL,
  `banco` int(4) NOT NULL, 
  `agencia` int(11) DEFAULT NULL,
  `dac_agencia` int(11) DEFAULT NULL,
  `conta` int(11) DEFAULT NULL,
  `dac_conta` int(11) DEFAULT NULL, 
  `saldo` decimal DEFAULT NULL,
  PRIMARY KEY (`idconta`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `autorizado_transferencia` (
  `idautorizado_transferencia` int(11) NOT NULL,
  `idcorrentista_origem` int(11) DEFAULT NULL,
  `idcorrentista_destino` int(11) DEFAULT NULL,
  PRIMARY KEY (`idautorizado_transferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `transferencia` (
  `idtransferencia` int(11) NOT NULL,
  `idcorrentista_origem` int(11) DEFAULT NULL,
  `idcorrentista_destino` int(11) DEFAULT NULL,
  `data` datetime DEFAULT NULL,
  `valor` decimal DEFAULT NULL,
  `efetuada` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtransferencia`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


insert into correntista values (1, 'Ana Maria','58424255135'); 
insert into correntista values (2, 'Maria Luiza','38521876300'); 
insert into correntista values (3, 'Orlando Silva','33165275670'); 
insert into correntista values (4, 'Osvaldo Augusto','44044173656'); 
insert into correntista values (5, 'Tatiana Cristina','12864164264'); 

insert into conta values (1, 1, 100, 1400, 0, 132132, 9, 12000); 
insert into conta values (2, 2, 237, 1500, 1, 312132, 1, 20000); 
insert into conta values (3, 3, 34, 1100, 2, 443221, 0, 300); 
insert into conta values (4, 4, 33, 112, 5, 14050, 2, 4040); 
insert into conta values (5, 5, 212, 5000, 3, 405060, 1, 5050); 

insert into autorizado_transferencia values (1, 1, 2);
insert into autorizado_transferencia values (2, 1, 3);
insert into autorizado_transferencia values (3, 1, 4);

insert into autorizado_transferencia values (4, 2, 4);
insert into autorizado_transferencia values (5, 2, 5);

insert into transferencia values (1, 1, 2,'2017-01-10', 140, true);
insert into transferencia values (2, 1, 3,'2017-02-28', 5500, true); 




