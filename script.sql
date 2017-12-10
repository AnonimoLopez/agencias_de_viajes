-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.28-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para agencias_de_viajes
CREATE DATABASE IF NOT EXISTS `agencias_de_viajes` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `agencias_de_viajes`;

-- Volcando estructura para tabla agencias_de_viajes.avion
CREATE TABLE IF NOT EXISTS `avion` (
  `CVE_AVION` int(11) NOT NULL AUTO_INCREMENT,
  `CVE_PILOTO` int(11) NOT NULL,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`CVE_AVION`),
  KEY `FK_AVION_PILOTO` (`CVE_PILOTO`),
  CONSTRAINT `FK_AVION_PILOTO` FOREIGN KEY (`CVE_PILOTO`) REFERENCES `usuario` (`CVE_USUARIO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.avion: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` (`CVE_AVION`, `CVE_PILOTO`, `DESCRIPCION`) VALUES
	(1, 1, 'es bueno');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.ciudad
CREATE TABLE IF NOT EXISTS `ciudad` (
  `CVE_CIUDAD` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) NOT NULL,
  `CVE_PAIS` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`CVE_CIUDAD`),
  KEY `FK_CIUDAD_pais` (`CVE_PAIS`),
  CONSTRAINT `FK_CIUDAD_pais` FOREIGN KEY (`CVE_PAIS`) REFERENCES `pais` (`CVE_PAIS`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.ciudad: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`CVE_CIUDAD`, `NOMBRE`, `CVE_PAIS`) VALUES
	(1, 'wdawdawdwa', 1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.continente
CREATE TABLE IF NOT EXISTS `continente` (
  `CVE_CONTINENTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) NOT NULL,
  PRIMARY KEY (`CVE_CONTINENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.continente: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `continente` DISABLE KEYS */;
INSERT INTO `continente` (`CVE_CONTINENTE`, `NOMBRE`) VALUES
	(1, 'ASIA');
/*!40000 ALTER TABLE `continente` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.pais
CREATE TABLE IF NOT EXISTS `pais` (
  `CVE_PAIS` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) NOT NULL,
  `CVE_CONTINENTE` int(11) DEFAULT NULL,
  PRIMARY KEY (`CVE_PAIS`),
  KEY `FK_pais_continente` (`CVE_CONTINENTE`),
  CONSTRAINT `FK_pais_continente` FOREIGN KEY (`CVE_CONTINENTE`) REFERENCES `continente` (`CVE_CONTINENTE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.pais: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`CVE_PAIS`, `NOMBRE`, `CVE_CONTINENTE`) VALUES
	(1, 'awdwa', 1);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.paquete
CREATE TABLE IF NOT EXISTS `paquete` (
  `cve_paquete` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE1` varchar(50) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  PRIMARY KEY (`cve_paquete`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.paquete: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` (`cve_paquete`, `NOMBRE1`, `DESCRIPCION`) VALUES
	(1, 'TURISTA', 'ESTE PAQUETE INCLUYE DE REGRESO'),
	(2, 'PREMIUM', 'AMAWLKMA'),
	(4, 'expres', 'este paquete es mas rapido y mas simple');
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.paquete_destino
CREATE TABLE IF NOT EXISTS `paquete_destino` (
  `cve_paquete_destino` int(11) NOT NULL AUTO_INCREMENT,
  `cve_paquete` int(11) NOT NULL,
  `cve_ciudad` int(10) NOT NULL,
  `costo` double NOT NULL,
  PRIMARY KEY (`cve_paquete_destino`),
  KEY `FK_paquete_destino_paquete` (`cve_paquete`),
  KEY `FK_paquete_destino_ciudad` (`cve_ciudad`),
  CONSTRAINT `FK_paquete_destino_ciudad` FOREIGN KEY (`cve_ciudad`) REFERENCES `ciudad` (`CVE_CIUDAD`),
  CONSTRAINT `FK_paquete_destino_paquete` FOREIGN KEY (`cve_paquete`) REFERENCES `paquete` (`cve_paquete`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.paquete_destino: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `paquete_destino` DISABLE KEYS */;
INSERT INTO `paquete_destino` (`cve_paquete_destino`, `cve_paquete`, `cve_ciudad`, `costo`) VALUES
	(1, 2, 1, 10000),
	(2, 1, 1, 5000);
/*!40000 ALTER TABLE `paquete_destino` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.personas
CREATE TABLE IF NOT EXISTS `personas` (
  `CVE_PERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(50) NOT NULL,
  `PATERNO` varchar(50) NOT NULL,
  `MATERNO` varchar(50) NOT NULL,
  `TELEFONO` varchar(50) NOT NULL,
  `E-mail` varchar(50) NOT NULL,
  PRIMARY KEY (`CVE_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.personas: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`CVE_PERSONA`, `NOMBRE`, `PATERNO`, `MATERNO`, `TELEFONO`, `E-mail`) VALUES
	(1, 'Pepe', 'Lopez', 'MENDEZ', '9392093', ''),
	(2, 'luz', 'awdwlH', 'aldawl', '9320939', ''),
	(3, 'awdaw', 'awdawd', 'awdwa', 'qe', ''),
	(6, 'rafael', 'hernandez', 'alvarez', '93224455', 'sdads@hotmail.com'),
	(8, 'antonio ', 'sanchez', 'garibay', '99323456', 'asd@hotmail.com');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.tipo_usuario
CREATE TABLE IF NOT EXISTS `tipo_usuario` (
  `CVE_TIPO_EMPLEADO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(50) NOT NULL,
  PRIMARY KEY (`CVE_TIPO_EMPLEADO`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.tipo_usuario: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`CVE_TIPO_EMPLEADO`, `DESCRIPCION`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'CAJERO'),
	(3, 'CLIENTE'),
	(4, 'PILOTO');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `CVE_USUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `CVE_TIPO_USUARIO` int(11) NOT NULL DEFAULT '0',
  `USUARIO` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  PRIMARY KEY (`CVE_USUARIO`),
  KEY `FK_usuario_tipo_usuario` (`CVE_TIPO_USUARIO`),
  CONSTRAINT `FK_CV_EUSUARIOS_PERSONAS` FOREIGN KEY (`CVE_USUARIO`) REFERENCES `personas` (`CVE_PERSONA`),
  CONSTRAINT `FK_usuario_tipo_usuario` FOREIGN KEY (`CVE_TIPO_USUARIO`) REFERENCES `tipo_usuario` (`CVE_TIPO_EMPLEADO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`CVE_USUARIO`, `CVE_TIPO_USUARIO`, `USUARIO`, `PASSWORD`) VALUES
	(1, 1, 'pepe', 'jose'),
	(2, 3, 'lus', 'awjdwalkd'),
	(3, 4, 'c', 'dwad');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `CVE_VENTA` int(11) NOT NULL AUTO_INCREMENT,
  `CVE_VUELO` int(11) NOT NULL,
  `CVE_PAQUETE_DESTINO` int(11) NOT NULL,
  `CVE_CLIENTE` int(11) NOT NULL,
  `SUBTOTAL` int(11) NOT NULL,
  `NO_BOLETOS` int(11) NOT NULL,
  `EFECTIVO` double NOT NULL,
  `TOTAL` double NOT NULL,
  PRIMARY KEY (`CVE_VENTA`),
  KEY `FK_VENTA_VUELO` (`CVE_VUELO`),
  KEY `FK_VENTA_CLIENTE` (`CVE_CLIENTE`),
  KEY `FK_venta_paquete_destino` (`CVE_PAQUETE_DESTINO`),
  CONSTRAINT `FK_VENTA_CLIENTE` FOREIGN KEY (`CVE_CLIENTE`) REFERENCES `usuario` (`CVE_USUARIO`),
  CONSTRAINT `FK_VENTA_VUELO` FOREIGN KEY (`CVE_VUELO`) REFERENCES `vuelo` (`CVE_VUELO`),
  CONSTRAINT `FK_venta_paquete_destino` FOREIGN KEY (`CVE_PAQUETE_DESTINO`) REFERENCES `paquete_destino` (`cve_paquete_destino`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.venta: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` (`CVE_VENTA`, `CVE_VUELO`, `CVE_PAQUETE_DESTINO`, `CVE_CLIENTE`, `SUBTOTAL`, `NO_BOLETOS`, `EFECTIVO`, `TOTAL`) VALUES
	(1, 1, 2, 1, 500, 3, 600, 5000);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

-- Volcando estructura para tabla agencias_de_viajes.vuelo
CREATE TABLE IF NOT EXISTS `vuelo` (
  `CVE_VUELO` int(11) NOT NULL,
  `CVE_AVION` int(11) NOT NULL,
  `NO_DE_ACIENTOS_DISPONIBLES` int(11) NOT NULL DEFAULT '60',
  `HORA_DE_SALIDA` datetime NOT NULL,
  `DISPONIBLE` bit(1) NOT NULL,
  PRIMARY KEY (`CVE_VUELO`),
  KEY `FK_VUELO_AVION` (`CVE_AVION`),
  CONSTRAINT `FK_VUELO_AVION` FOREIGN KEY (`CVE_AVION`) REFERENCES `avion` (`CVE_AVION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla agencias_de_viajes.vuelo: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` (`CVE_VUELO`, `CVE_AVION`, `NO_DE_ACIENTOS_DISPONIBLES`, `HORA_DE_SALIDA`, `DISPONIBLE`) VALUES
	(1, 1, 60, '2017-12-08 12:58:06', b'1');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
