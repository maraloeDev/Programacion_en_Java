-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ejemplo`
--
CREATE DATABASE IF NOT EXISTS `ejemplo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ejemplo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tabla1`
--

CREATE TABLE `tabla1` (
  `clave` int(11) NOT NULL,
  `columna1` varchar(50) NOT NULL,
  `columna2` varchar(50) NOT NULL,
  `columna3` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tabla1`
--

INSERT INTO `tabla1` (`clave`, `columna1`, `columna2`, `columna3`) VALUES
(1, 'dato de ejemplo', 'otro dato', 99);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tabla1`
--
ALTER TABLE `tabla1`
  ADD PRIMARY KEY (`clave`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tabla1`
--
ALTER TABLE `tabla1`
  MODIFY `clave` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
