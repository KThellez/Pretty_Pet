-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-03-2022 a las 19:09:31
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prettypetstore`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `Email_address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `company`
--

INSERT INTO `company` (`id`, `name`, `phone`, `address`, `Email_address`) VALUES
(20192578, 'PrettyPetStore', '3123326913', 'Address Pretty Pet Store', 'prettypetstore@prettypetstore.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `costumers`
--

CREATE TABLE `costumers` (
  `id_costumer` varchar(15) NOT NULL,
  `name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `code` varchar(10) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `costumers`
--

INSERT INTO `costumers` (`id_costumer`, `name`, `last_name`, `phone`, `address`, `email_address`, `code`, `fecha`) VALUES
('1000123123', 'Antonio', 'Martinez', '3123326910', ' Calle 43 No. 27A-55', 'AntonioM@hotmail.com', '3HVEJ8Y', '2022-03-25 14:53:22'),
('1000123456', 'Olivia', 'Saavedra', '6016436644', 'Transversal 39D No. 40A-60 sur', 'OliviaSa@gmail.com', 'LZ1NF70', '2022-03-25 15:03:18'),
('1000741852', 'Pedro', 'Pablo', '3185812522', 'Avenia 3 # 65', 'Pedrop@gmail.com', 'JFZ3BRY', '2022-03-30 07:58:13'),
('1000987654', 'Aroa', 'Zelaya', '301581252', 'Cr 52 No. 60-22', 'ZelayaPapaya@gmail.com', 'JAKOBAL', '2022-03-25 15:10:42'),
('1123456789', 'Javier', 'Aguilar', '3123659874', 'Cr 53 No. 46-16', 'AguilarJav@hotmail.com', 'KZWHTPF', '2022-03-25 15:04:54');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `details`
--

CREATE TABLE `details` (
  `id` int(11) NOT NULL,
  `code_product` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `id_sales` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `bar_code` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `description` varchar(256) NOT NULL,
  `amount` int(11) NOT NULL,
  `price` decimal(15,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `id_supplier` varchar(20) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`bar_code`, `name`, `description`, `amount`, `price`, `stock`, `id_supplier`, `fecha`) VALUES
(1, '2Kg Hills - Prescription Diet R/D Weight Reduction Cat', 'Hills - Prescription Diet R/D Weight Reduction Cat, ayuda a metabolizar la grasa y mantener el músculo magro. Ayuda a su gato a sentirse lleno y satisfecho. Apoya un sistema inmunológico sano', 50, '126300.00', 50, '900935804-2', '2022-03-25 22:46:46'),
(2, '1.5Kg Agility Gold Gatitos', 'Este alimento tiene una dieta completa y balanceada elaborada con carne real de Salmón y Pollo, es ideal porque garantiza un porcentaje mínimo de proteína de 42%, aporta probióticos y prebióticos para la salud gastrointestinal.', 50, '33750.00', 30, '901110407-4', '2022-03-25 22:56:20'),
(3, '1.5Kg Avet -Cat Renal', 'Ayuda a disminuir la progresión del fallo renal.', 15, '81500.00', 15, '900935804-2', '2022-03-25 22:58:01'),
(4, '1.5Kg Chunky Pollo Gatitos', 'Alimento especialmente diseñado para gatitos para contribuir en su desarrollo y crecimiento posterior a la lactancia materna. Con niveles apropiados de vitaminas, minerales, proteínas, fibra, ácidos grasos, entre otros.', 30, '21350.00', 28, '901110407-4', '2022-03-25 22:59:11'),
(5, '1.5Kg Equilibrio -F Gatos Adultos', 'Equilibrio Gatos Adultos está pensado para todas las razas de gatos a partir de los 12 meses de vida, contiene ingredientes especiales como, Omegas 3 y 6, que ayuda a un pelo suave y brillante, hexametafosfato de sodio,', 30, '53000.00', 27, '901110407-4', '2022-03-25 23:00:55'),
(6, '1Kg BR FOR CAT', 'Mantiene el sistema inmunológico saludable, piel y pelaje sano, % de ingredientes animales: >72%, % de proteína derivada de ingredientes animales: >84%.', 60, '34600.00', 60, '901110407-4', '2022-03-25 23:05:14'),
(7, '3Kg Max Cat Castrados', 'Su porcentaje de Taurina es bastante benéfico para tu gatito ya que ayuda a mantener el corazón y los ojos de tu mascota sanos. ', 25, '66500.00', 23, '901110407-4', '2022-03-25 23:07:39'),
(8, '1Kg Mirringo Gaticos', 'Suminístrale nuestro producto desde la tercera semana de edad, como suplemento a la leche materna y como único alimento a partir del destete.', 7, '9400.00', 7, '901110407-4', '2022-03-25 23:09:34'),
(9, 'Monello Cat Castrados', 'Alimento cuenta también con la adición de Taurina, que actúa en la salud de la visión y del corazón, y cuidados especiales para la prevención de cálculos urinarios.', 50, '23600.00', 50, '901110407-4', '2022-03-25 23:10:03'),
(10, '1.5Kg N&D Ancestral Feline Frango Castrado Frango', 'Alimento completo y balanceado para gatos adultos castrados. Tiene un un bajo índice glucémico, lo cual permite una liberación modulada de energía durante el día', 25, '93400.00', 15, '901110407-4', '2022-03-25 23:10:59'),
(11, '2.27 Kg NULO CAT FS GRAIN FREE SENIOR ALASKA POLLOCK, DUCK, & SWEET POTATO', 'Las fórmulas Nulo FreeStyle libres de granos, altas en proteína animal y bajas en carbohidratos, le dan a tu gato los nutrientes que necesita para sentirse de lo mejor', 40, '98000.00', 40, '901110407-4', '2022-03-25 23:12:29'),
(12, '8Kg Nutrecat Liberty Adulto', 'Diminuye el olor de las heces, aumenta las defensas, disminuye la formación debolas de pelo, embellece el pelo, mejora la salud de la piel, fomenta el funcionamiento óptimo del sistema digestivo y el tracto urinario.', 15, '85700.00', 15, '901110407-4', '2022-03-25 23:13:30'),
(13, '1.5Kg Oh Maigat! - Inquietos Y Aventureros', 'Oh maigat! - inquietos y aventureros, ha creado un alimento basado en los rasgos particulares de tu gato, que además de deleitar su paladar con su exquisita combinación de ingredientes', 15, '26000.00', 15, '901110407-4', '2022-03-25 23:14:19'),
(14, '1.6 Kg PROPLAN - Cat Live Clear', 'Alimento completo y balanceado para gatos adultos de 1 a 7 años. Reduce significativamente los alérgenos en el pelo y la caspa del gato elaborado con carne fresca de pollo.', 45, '116000.00', 45, '901110407-4', '2022-03-25 23:15:03'),
(15, '2Kg Hills Prescription Diet Gatos Urinary Care c/d Cálculos Urinarios', 'El concentrado para gatos Urinary Care c/d de la línea Prescription Diet de Hill\'s es un concentrado especialmente diseñado para tratar problemas de cálculos urinarios como de de estruvita y oxalato cálcico', 30, '125600.00', 30, '860069284-2', '2022-03-25 23:16:45'),
(16, '7Kg Taste of the wild rocky mountain para gatos', 'Taste of the Wild® en un alimento Súper Premium para perros y gatos, comida de alta calidad con proteínas e ingredientes naturales y muchos beneficios para tu mascota.', 25, '228650.00', 25, '860069284-2', '2022-03-25 23:18:28'),
(17, '3Kr Diamond Naturals Gatos Indoor Pollo y Arroz', 'Diamond Naturals Indoor Cat es un concentrado especialmente formulado para gatos de interior, que sean más caseros, con un nivel menor de actividad física o con un estilo de vida sedentario', 10, '81600.00', 10, '860069284-2', '2022-03-25 23:21:55'),
(18, '1Kg Monello cat filhotes', 'Este alimento tiene el equilibrio perfecto entre leche y Taurina, que mejoran y desarrollan su visión en su crecimiento. Fortalecen su pequeño corazón y construye su organismo.', 100, '21300.00', 100, '860069284-2', '2022-03-25 23:22:27'),
(19, '6Kg OdourLock Arena para gatos', 'OdourLock en presentación de 6 kg es la arena perfecta para un entorno en el que viven e interactúan varios gatos. Sólo debes retirar los desechos una vez al día para una higiene eficaz', 50, '54900.00', 50, '860069284-2', '2022-03-25 23:23:01'),
(20, '2.72Kg Choice Concentrado para Gatos Cuidado de la Piel', '1st Choice Adult Healthy Skin and Coat es un concentrado para gatos especialmente diseñado para cuidar y proteger la piel y el pelaje de los cambios de temperatura y demás fenomenos que puedan afectar la piel de nuestros felinos.', 50, '74000.00', 50, '860069284-2', '2022-03-25 23:24:14'),
(21, '2Kg Royal canin feline VDF hepatic para gatos', 'Tu minino necesita una alimentación completa y balanceada que permita que su vida, su organismo y su desarrollo sea fuerte y sano, previene las enfermedades hepáticas de tu mascota y/o permite tratarlas.', 50, '146500.00', 50, '860069284-2', '2022-03-25 23:24:43'),
(22, '1Kg Nutra Nuggets Mantenimiento Para Gato', 'Formulada como un producto completo y equilibrado, esta fórmula está diseñada para promover la salud a largo plazo de gatos con niveles de actividad normales a bajos.', 30, '21050.00', 30, '900935804-2', '2022-03-25 23:27:31'),
(23, '1Kg Naturalis Felino Adulto Castrado Frango Y Peru', 'Alimento para gato castrado 100% natural , sin colorantes , sin conservantes artificiales.', 30, '24150.00', 30, '900935804-2', '2022-03-25 23:28:03'),
(24, '1.5Kg Alimento Seco Para Gato Evolve Classic Pollo ', 'Nuestro Evolve Classic Deboned Chicken & Brown Rice Recipe Cat Food proporciona toda la nutrición necesaria para promover la salud y la vitalidad en los gatos.', 30, '36750.00', 30, '900935804-2', '2022-03-25 23:28:32'),
(25, '2Kg Alimento Para Gato Vet Life Renal ', 'Alimento seco para gatos, indicado para el soporte de la función renal en casos de enfermedad renal crónica o aguda, o en casos de insuficiencia cardiaca congestiva.', 20, '110000.00', 20, '900935804-2', '2022-03-25 23:29:23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sales`
--

CREATE TABLE `sales` (
  `id_sales` int(11) NOT NULL,
  `costumer` varchar(128) NOT NULL,
  `salesman` varchar(128) NOT NULL,
  `total` decimal(15,2) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supplier`
--

CREATE TABLE `supplier` (
  `id_supplier` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `code` varchar(10) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `name`, `last_name`, `phone`, `address`, `email_address`, `code`, `fecha`) VALUES
('860069284-2', 'Agro', 'Campo', '6013265999', 'Avenida Caracas Nº 73 - 39 Bogotá D.C', 'info@agrocampo.com.co', 'UVHQHWE', '2022-03-25 13:43:42'),
('900935804-2', 'Puppis', 'Tienda', '6012193099', 'Carrera 15A # 122-26 Loc 2', 'protecciondatos@puppis.com.co', 'JMOSX3Y', '2022-03-25 13:40:57'),
('901110407-4', 'Laika', 'Tienda', '3009108496', 'Cra 68G No. 74B - 56, Bogotá DC', 'servicioclientes@laika.com.co', 'B84XX4Z', '2022-03-25 13:39:10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `last_name`, `email_address`, `password`) VALUES
(1, 'Administrator', 'Administrator', 'Administrator@prettypetstore.com', 'AdminPrettyPetStore'),
(3, 'Administrator', 'Administrator', 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `costumers`
--
ALTER TABLE `costumers`
  ADD PRIMARY KEY (`id_costumer`);

--
-- Indices de la tabla `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`bar_code`),
  ADD KEY `id_supplier` (`id_supplier`);

--
-- Indices de la tabla `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id_sales`);

--
-- Indices de la tabla `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id_supplier`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20192579;

--
-- AUTO_INCREMENT de la tabla `details`
--
ALTER TABLE `details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT de la tabla `sales`
--
ALTER TABLE `sales`
  MODIFY `id_sales` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
