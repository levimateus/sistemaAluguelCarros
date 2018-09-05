-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 28-Jun-2016 às 21:38
-- Versão do servidor: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alugacarros`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluguel`
--

CREATE TABLE `aluguel` (
  `alug_cod` int(11) NOT NULL,
  `alug_dt` datetime DEFAULT NULL,
  `alug_devol_prev_dt` datetime DEFAULT NULL,
  `alug_devol_dt` datetime DEFAULT NULL,
  `clie_cod` int(11) DEFAULT NULL,
  `func_cod` int(11) DEFAULT NULL,
  `carr_cod` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--

CREATE TABLE `carro` (
  `carr_cod` int(11) NOT NULL,
  `carr_aluguel_vl` decimal(8,2) DEFAULT NULL,
  `carr_placa_ds` varchar(7) DEFAULT NULL,
  `carr_municipio_ds` varchar(50) DEFAULT NULL,
  `carr_uf` char(2) DEFAULT NULL,
  `carr_cor` varchar(20) DEFAULT NULL,
  `carr_ano` decimal(4,0) DEFAULT NULL,
  `carr_modelo_ds` varchar(20) DEFAULT NULL,
  `carr_marca` varchar(20) DEFAULT NULL,
  `carr_cadastro_dt` datetime DEFAULT NULL,
  `tpca_cod` int(11) DEFAULT NULL,
  `carr_ocupado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`carr_cod`, `carr_aluguel_vl`, `carr_placa_ds`, `carr_municipio_ds`, `carr_uf`, `carr_cor`, `carr_ano`, `carr_modelo_ds`, `carr_marca`, `carr_cadastro_dt`, `tpca_cod`, `carr_ocupado`) VALUES
(1, '0.00', 'DZX1234', 'Guarulhos', 'SP', 'Prata', '2016', 'Novo Cobalt', 'Chevrolet', '2016-06-28 00:00:00', 7, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `clie_cod` int(11) NOT NULL,
  `clie_debito` decimal(8,2) DEFAULT NULL,
  `clie_debito_ant` decimal(8,2) DEFAULT NULL,
  `clie_cpf` varchar(11) DEFAULT NULL,
  `clie_rg` varchar(11) DEFAULT NULL,
  `clie_cnh` varchar(11) DEFAULT NULL,
  `clie_nasc_dt` date DEFAULT NULL,
  `clie_cad_dt` date DEFAULT NULL,
  `clie_nm` varchar(50) DEFAULT NULL,
  `clie_end_ds` varchar(150) DEFAULT NULL,
  `clie_cid_ds` varchar(50) DEFAULT NULL,
  `clie_uf` char(2) DEFAULT NULL,
  `clie_telefone_ds` varchar(9) DEFAULT NULL,
  `clie_telefone_ddd` char(3) DEFAULT NULL,
  `clie_telefone_ddi` char(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`clie_cod`, `clie_debito`, `clie_debito_ant`, `clie_cpf`, `clie_rg`, `clie_cnh`, `clie_nasc_dt`, `clie_cad_dt`, `clie_nm`, `clie_end_ds`, `clie_cid_ds`, `clie_uf`, `clie_telefone_ds`, `clie_telefone_ddd`, `clie_telefone_ddi`) VALUES
(18, '0.00', '0.00', '6546545', '6546464', '465465654', '1968-08-04', '2016-06-28', 'Nelson Albino da Silva', 'Av Avenida', 'Guarulhos', 'SP', '21459871', '11', '+55'),
(19, '0.00', '0.00', '987654469', '21332132', '12331221', '1954-05-28', '2016-06-28', 'João Sabino', 'adasdasdas', 'Guarulhos', 'SP', '1234567', '11', '+55'),
(20, '0.00', '0.00', '65432198', '6543214', '321654', '2000-10-24', '2016-06-28', 'Ester', 'Av José Miguel', 'Guarulhos', 'SP', '6543210', '11', '+55'),
(21, '0.00', '0.00', '12345678910', '6455646445', '56465465465', '1997-12-26', '2016-06-28', 'Mateus', 'asdasdasdas', 'Guarulhos', 'SP', '12345678', '11', '+55');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `func_cod` int(11) NOT NULL,
  `func_matr_cod` varchar(11) DEFAULT NULL,
  `func_cpf` varchar(11) DEFAULT NULL,
  `func_rg` varchar(11) DEFAULT NULL,
  `func_cnh` varchar(11) DEFAULT NULL,
  `func_nasc_dt` date DEFAULT NULL,
  `func_cad_dt` date DEFAULT NULL,
  `func_nm` varchar(50) DEFAULT NULL,
  `func_end_ds` varchar(150) DEFAULT NULL,
  `func_cid_ds` varchar(50) DEFAULT NULL,
  `func_uf` char(2) DEFAULT NULL,
  `func_telefone_ds` varchar(9) DEFAULT NULL,
  `func_telefone_ddd` char(3) DEFAULT NULL,
  `func_telefone_ddi` char(4) DEFAULT NULL,
  `func_login` varchar(256) DEFAULT NULL,
  `func_senha` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`func_cod`, `func_matr_cod`, `func_cpf`, `func_rg`, `func_cnh`, `func_nasc_dt`, `func_cad_dt`, `func_nm`, `func_end_ds`, `func_cid_ds`, `func_uf`, `func_telefone_ds`, `func_telefone_ddd`, `func_telefone_ddi`, `func_login`, `func_senha`) VALUES
(30, '123456', '476520000', '54676000', '1234567', '1997-12-26', '2016-06-27', 'Mateus Levi da Silva Martins', 'Av Salgado Filho 2252', 'Guarulhos', 'SP', '24000000', '11', '+55', 'mateus', '123456'),
(32, '216', '456465', '456465', '', '1996-06-26', '2016-06-28', 'André', '', '', '', '', 'DDD', 'DDI', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipocarro`
--

CREATE TABLE `tipocarro` (
  `tpca_cod` int(11) NOT NULL,
  `tpca_ds` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipocarro`
--

INSERT INTO `tipocarro` (`tpca_cod`, `tpca_ds`) VALUES
(10, 'Caminhão'),
(11, 'Moto'),
(8, 'Ônibus'),
(7, 'Passeio'),
(9, 'Utilitário');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluguel`
--
ALTER TABLE `aluguel`
  ADD PRIMARY KEY (`alug_cod`),
  ADD KEY `aluguel_fk_cliente` (`clie_cod`),
  ADD KEY `aluguel_fk_funcionario` (`func_cod`),
  ADD KEY `aluguel_fk_carro` (`carr_cod`);

--
-- Indexes for table `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`carr_cod`),
  ADD UNIQUE KEY `carr_unique_placa` (`carr_placa_ds`),
  ADD KEY `carro_fk_tipoCarro` (`tpca_cod`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`clie_cod`),
  ADD UNIQUE KEY `clie_uniq_cpf` (`clie_cpf`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`func_cod`),
  ADD UNIQUE KEY `func_unic_login` (`func_login`),
  ADD UNIQUE KEY `func_uniq_login` (`func_login`),
  ADD UNIQUE KEY `func_uniq_cpf` (`func_cpf`),
  ADD UNIQUE KEY `func_unique_cpf` (`func_cpf`);

--
-- Indexes for table `tipocarro`
--
ALTER TABLE `tipocarro`
  ADD PRIMARY KEY (`tpca_cod`),
  ADD UNIQUE KEY `tpca_ds_unique` (`tpca_ds`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluguel`
--
ALTER TABLE `aluguel`
  MODIFY `alug_cod` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `carro`
--
ALTER TABLE `carro`
  MODIFY `carr_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `clie_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `func_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `tipocarro`
--
ALTER TABLE `tipocarro`
  MODIFY `tpca_cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluguel`
--
ALTER TABLE `aluguel`
  ADD CONSTRAINT `aluguel_fk_carro` FOREIGN KEY (`carr_cod`) REFERENCES `carro` (`carr_cod`),
  ADD CONSTRAINT `aluguel_fk_cliente` FOREIGN KEY (`clie_cod`) REFERENCES `cliente` (`clie_cod`),
  ADD CONSTRAINT `aluguel_fk_funcionario` FOREIGN KEY (`func_cod`) REFERENCES `funcionario` (`func_cod`);

--
-- Limitadores para a tabela `carro`
--
ALTER TABLE `carro`
  ADD CONSTRAINT `carro_fk_tipoCarro` FOREIGN KEY (`tpca_cod`) REFERENCES `tipocarro` (`tpca_cod`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
