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

-- Volcando datos para la tabla agencias_de_viajes.avion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `avion` DISABLE KEYS */;
INSERT INTO `avion` (`CVE_AVION`, `CVE_PILOTO`, `DESCRIPCION`) VALUES
	(1, 1, 'es bueno');
/*!40000 ALTER TABLE `avion` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.ciudad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`CVE_CIUDAD`, `NOMBRE`, `CVE_PAIS`) VALUES
	(1, 'wdawdawdwa', 1);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.continente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `continente` DISABLE KEYS */;
INSERT INTO `continente` (`CVE_CONTINENTE`, `NOMBRE`) VALUES
	(1, 'ASIA');
/*!40000 ALTER TABLE `continente` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.pais: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`CVE_PAIS`, `NOMBRE`, `CVE_CONTINENTE`) VALUES
	(1, 'awdwa', 1);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.paquete: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` (`cve_paquete`, `NOMBRE1`, `DESCRIPCION`) VALUES
	(1, 'TURISTA', 'ESTE PAQUETE INCLUYE DE REGRESO'),
	(2, 'PREMIUM', 'AMAWLKMA'),
	(4, 'expres', 'este paquete es mas rapido y mas simple');
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.paquete_destino: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `paquete_destino` DISABLE KEYS */;
INSERT INTO `paquete_destino` (`cve_paquete_destino`, `cve_paquete`, `cve_ciudad`, `costo`) VALUES
	(1, 2, 1, 10000),
	(2, 1, 1, 5000);
/*!40000 ALTER TABLE `paquete_destino` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.personas: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` (`CVE_PERSONA`, `NOMBRE`, `PATERNO`, `MATERNO`, `TELEFONO`, `E-mail`) VALUES
	(1, 'Pepe', 'Lopez', 'MENDEZ', '9392093', ''),
	(2, 'luz', 'awdwlH', 'aldawl', '9320939', ''),
	(3, 'awdaw', 'awdawd', 'awdwa', 'qe', ''),
	(6, 'rafael', 'hernandez', 'alvarez', '93224455', 'sdads@hotmail.com'),
	(8, 'antonio ', 'sanchez', 'garibay', '99323456', 'asd@hotmail.com');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.tipo_usuario: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`CVE_TIPO_EMPLEADO`, `DESCRIPCION`) VALUES
	(1, 'ADMINISTRADOR'),
	(2, 'CAJERO'),
	(3, 'CLIENTE'),
	(4, 'PILOTO');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.usuario: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`CVE_USUARIO`, `CVE_TIPO_USUARIO`, `USUARIO`, `PASSWORD`) VALUES
	(1, 1, 'pepe', 'jose'),
	(2, 3, 'lus', 'awjdwalkd'),
	(3, 4, 'c', 'dwad');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` (`CVE_VENTA`, `CVE_VUELO`, `CVE_PAQUETE_DESTINO`, `CVE_CLIENTE`, `SUBTOTAL`, `NO_BOLETOS`, `EFECTIVO`, `TOTAL`) VALUES
	(1, 1, 2, 1, 500, 3, 600, 5000);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

-- Volcando datos para la tabla agencias_de_viajes.vuelo: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `vuelo` DISABLE KEYS */;
INSERT INTO `vuelo` (`CVE_VUELO`, `CVE_AVION`, `NO_DE_ACIENTOS_DISPONIBLES`, `HORA_DE_SALIDA`, `DISPONIBLE`) VALUES
	(1, 1, 60, '2017-12-08 12:58:06', b'1');
/*!40000 ALTER TABLE `vuelo` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
