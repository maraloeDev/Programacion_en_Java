-- phpMyAdmin SQL Dump
-- version 5.1.3
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
-- Base de datos: `almacen`
--
CREATE DATABASE IF NOT EXISTS `almacen` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `almacen`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `tipo` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `descripcion`, `precio`, `cantidad`, `tipo`) VALUES
(1, 'producto1', '5.00', 25, 1),
(2, 'producto2', '0.50', 15, 1),
(3, 'producto3', '7.00', 5, 3),
(4, 'producto4', '35.00', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposproducto`
--

CREATE TABLE `tiposproducto` (
  `idTipo` int(11) NOT NULL,
  `tipo` char(1) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tiposproducto`
--

INSERT INTO `tiposproducto` (`idTipo`, `tipo`) VALUES
(1, 'A'),
(2, 'B'),
(3, 'C');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `tipo` (`tipo`);

--
-- Indices de la tabla `tiposproducto`
--
ALTER TABLE `tiposproducto`
  ADD PRIMARY KEY (`idTipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
