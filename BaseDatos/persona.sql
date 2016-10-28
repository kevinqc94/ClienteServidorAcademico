-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2016 a las 12:00:51
-- Versión del servidor: 10.1.16-MariaDB
-- Versión de PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd-academico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `codigo` int(10) NOT NULL,
  `nombre` varchar(35) DEFAULT NULL,
  `apellido` varchar(35) DEFAULT NULL,
  `direccion` varchar(40) DEFAULT NULL,
  `email` varchar(35) DEFAULT NULL,
  `edad` int(2) DEFAULT NULL,
  `grado` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`codigo`, `nombre`, `apellido`, `direccion`, `email`, `edad`, `grado`) VALUES
(181201203, 'Jorge', 'Soto', 'Lima', 'lima@mail.com', 20, 'Superior'),
(1812012036, 'Dani', 'Silva Benites', 'La Selva', 'dani@mail.com', 24, 'Superior'),
(1812012039, 'Kevin', 'Quino Cortez', 'Lima', 'email@mail.com', 21, 'Superior');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
