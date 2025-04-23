-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-12-2023 a las 04:35:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jumbox`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id_categoria`, `nombre`) VALUES
(1, 'Cereal'),
(2, 'Liquidos grasos'),
(3, 'Lacteos'),
(4, 'Pasta'),
(5, 'Origen animal'),
(6, 'Fruta'),
(7, 'Harinas'),
(8, 'Liquido');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `dni` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`nombre`, `apellido`, `mail`, `telefono`, `direccion`, `dni`) VALUES
('hernan', 'locarnini', 'hernan@davinci', 2222222, 'corrientes 2000', 41127919);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operacion`
--

CREATE TABLE `operacion` (
  `id_operacion` int(11) NOT NULL,
  `precio_total` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `estado` varchar(30) NOT NULL DEFAULT 'Pendiente',
  `id_usuario` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `operacion`
--

INSERT INTO `operacion` (`id_operacion`, `precio_total`, `cantidad_producto`, `estado`, `id_usuario`) VALUES
(2, 2250, 1, 'Cancelado', '1'),
(3, 2250, 1, 'Entregado', '1'),
(4, 2250, 1, 'Cancelado', '1'),
(12, 32500, 2, 'Pendiente', '0'),
(23, 6450, 1, 'Pendiente', '0'),
(25, 3000, 1, 'Pendiente', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `precio` double NOT NULL,
  `descripcion` text NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `nombre`, `precio`, `descripcion`, `id_categoria`, `stock`) VALUES
(1, 'Paquete', 150, 'paquetes', 2, 30),
(2, 'Aceite de Oliva Extra Virgen', 300, 'Botella de 500 ml de aceite de oliva extra virgen', 2, 50),
(3, 'Leche Entera', 100, 'Botella de 1 litro de leche entera', 3, 80),
(4, 'Pasta Espagueti', 85, 'Paquete de 500 g de pasta tipo espagueti', 4, 120),
(5, 'Huevos de Granja', 100, 'Docena de huevos frescos de granja', 5, 60),
(6, 'Tomates en Lata', 50, 'Lata de 400 g de tomates pelados en trozos', 6, 40),
(7, 'Pan Integral', 100, 'Pan integral fresco, paquete de 500 g', 7, 30),
(8, 'Cereal de Avena con Miel', 175, 'Caja de 400 g de cereal de avena con miel', 1, 50),
(9, 'Yogur Natural', 90, 'Envase de 200 g de yogur natural sin azúcar', 3, 70),
(10, 'Agua Mineral', 120, 'Botella de 1.5 litros de agua mineral sin gas', 8, 90),
(11, 'Arroz Blanco Grano Largo', 200, 'Paquete de 1 kg de arroz blanco de grano largo', 1, 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `dni` varchar(11) NOT NULL,
  `contrasenia` varchar(10) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`nombre`, `apellido`, `mail`, `dni`, `contrasenia`, `id_rol`) VALUES
('cami', 'sarai', 'cami@sarai', '22', '123', 2),
('Bruno', 'Val', 'bruno@davinci', '33', '44', 3),
('hernan', 'locarnini', 'hernan.locarnini@davinci.edu.ar', '41127919', '1234', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `operacion`
--
ALTER TABLE `operacion`
  ADD PRIMARY KEY (`id_operacion`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id_categoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `operacion`
--
ALTER TABLE `operacion`
  MODIFY `id_operacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
