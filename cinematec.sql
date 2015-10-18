--
-- Base de Dados: `cinematec`
--
CREATE DATABASE IF NOT EXISTS `cinematec` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cinematec`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `filme`
--

CREATE TABLE IF NOT EXISTS `filme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL,
  `genero` int(11) NOT NULL,
  `sinopse` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nome` (`nome`,`genero`)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ingresso`
--

CREATE TABLE IF NOT EXISTS `ingresso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `secaoId` int(11) NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `secaoId` (`secaoId`)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `sala`
--

CREATE TABLE IF NOT EXISTS `sala` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `quantidadeAssentos` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `numero` (`numero`)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `secao`
--

CREATE TABLE IF NOT EXISTS `secao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salaId` int(11) NOT NULL,
  `filmeId` int(11) NOT NULL,
  `dataHoraInicio` datetime DEFAULT NULL,
  `tempoDuracaoMinutos` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `salaId` (`salaId`),
  KEY `filmeId` (`filmeId`)
);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `ingresso`
--
ALTER TABLE `ingresso`
  ADD CONSTRAINT `ingresso_secao_secaoId` FOREIGN KEY (`secaoId`) REFERENCES `secao` (`id`);

--
-- Limitadores para a tabela `secao`
--
ALTER TABLE `secao`
  ADD CONSTRAINT `secao_sala_salaID` FOREIGN KEY (`salaId`) REFERENCES `sala` (`id`),
  ADD CONSTRAINT `secao_filme_filmeId` FOREIGN KEY (`filmeId`) REFERENCES `filme` (`id`);
