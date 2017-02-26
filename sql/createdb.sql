

CREATE TABLE `clientes` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `cpfCnpj` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



CREATE TABLE `contas` (
  `idcontas` int(11) NOT NULL,
  `agencia` int(11) DEFAULT NULL,
  `dac_agencia` int(11) DEFAULT NULL,
  `conta` int(11) DEFAULT NULL,
  `dac_conta` int(11) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcontas`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



