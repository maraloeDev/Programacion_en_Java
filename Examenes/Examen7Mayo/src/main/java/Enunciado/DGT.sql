-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-05-2025 a las 17:47:16
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carnetdb`
--
CREATE DATABASE IF NOT EXISTS `carnetdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `carnetdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carnet`
--

CREATE TABLE `carnet` (
  `codigo` int(11) NOT NULL,
  `titular` varchar(10) DEFAULT NULL,
  `puntos` int(11) NOT NULL CHECK (`puntos` between 0 and 15)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- Volcado de datos para la tabla `carnet`
INSERT INTO `carnet` (`codigo`, `titular`, `puntos`) VALUES
(1001, 'Juan', 12),
(1002, 'María', 15),
(1003, 'Carlos', 8),
(1004, 'Lucía', 10),
(1005, 'Javier', 7),
(1006, 'Ana', 14),
(1007, 'Miguel', 6),
(1008, 'Laura', 13),
(1009, 'Sergio', 9),
(1010, 'Elena', 5),
(1011, 'Pablo', 11);
