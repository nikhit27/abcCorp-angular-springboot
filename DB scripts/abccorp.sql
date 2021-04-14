-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2020 at 11:36 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `abccorp`
--

-- --------------------------------------------------------

--
-- Table structure for table `accessories`
--

CREATE TABLE `accessories` (
  `accessory_id` int(11) NOT NULL,
  `accessory_name` varchar(20) NOT NULL,
  `accessory_price` int(11) NOT NULL,
  `model_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `accessories`
--

INSERT INTO `accessories` (`accessory_id`, `accessory_name`, `accessory_price`, `model_id`) VALUES
(401, 'Rims', 7000, 202),
(402, 'Leather seats', 12000, 204),
(403, 'Color Tint', 6000, 202),
(404, 'Rearview Camera', 20000, 201),
(405, 'LED lamps', 8000, 201),
(406, 'Fog Lamps', 10000, 203),
(407, 'Alloy wheels', 12000, 202);

-- --------------------------------------------------------

--
-- Table structure for table `car_model`
--

CREATE TABLE `car_model` (
  `model_id` int(11) NOT NULL,
  `model_name` varchar(20) NOT NULL,
  `model_price` int(11) NOT NULL,
  `series_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car_model`
--

INSERT INTO `car_model` (`model_id`, `model_name`, `model_price`, `series_id`) VALUES
(201, 'M30', 100000, 101),
(202, '320D', 50000, 102),
(203, 'M40', 120000, 101),
(204, 'M20', 80000, 101);

-- --------------------------------------------------------

--
-- Table structure for table `car_series`
--

CREATE TABLE `car_series` (
  `series_id` int(11) NOT NULL,
  `series_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `car_series`
--

INSERT INTO `car_series` (`series_id`, `series_name`) VALUES
(101, 'bmwM Series'),
(102, 'bmwD Series');

-- --------------------------------------------------------

--
-- Table structure for table `color`
--

CREATE TABLE `color` (
  `color_id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `color`
--

INSERT INTO `color` (`color_id`, `model_id`) VALUES
(301, 201),
(302, 201),
(303, 201),
(304, 203),
(304, 201),
(302, 202),
(301, 202),
(304, 202),
(303, 202),
(301, 203),
(303, 203),
(302, 203),
(301, 204),
(302, 204),
(303, 204),
(304, 204);

-- --------------------------------------------------------

--
-- Table structure for table `color_details`
--

CREATE TABLE `color_details` (
  `color_id` int(11) NOT NULL,
  `color_name` varchar(20) NOT NULL,
  `color_price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `color_details`
--

INSERT INTO `color_details` (`color_id`, `color_name`, `color_price`) VALUES
(301, 'Blue', 1000),
(302, 'Red', 1200),
(303, 'White', 1400),
(304, 'Black', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `order_amount` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `model_id`, `order_amount`, `user_id`) VALUES
(501, 201, 130000, 1),
(504, 203, 274000, 1),
(505, 201, 387600, 101),
(506, 204, 283800, 101),
(507, 202, 114000, 101),
(508, 201, 121200, 101),
(509, 202, 195000, 101),
(510, 202, 102400, 101),
(511, 202, 264800, 101),
(512, 204, 107400, 102),
(513, 202, 324600, 102);

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `order_details_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `color_id` int(11) NOT NULL,
  `accessory_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`order_details_id`, `order_id`, `color_id`, `accessory_id`, `quantity`, `amount`) VALUES
(601, 501, 301, 404, 1, 21000),
(602, 501, 301, 405, 1, 9000),
(607, 504, 304, 401, 2, 18000),
(608, 504, 304, 403, 2, 16000),
(609, 505, 302, 404, 3, 63600),
(610, 505, 302, 405, 3, 27600),
(611, 506, 302, 402, 3, 39600),
(612, 506, 303, 402, 3, 40200),
(613, 507, 301, 403, 2, 14000),
(614, 508, 302, 404, 1, 21200),
(615, 509, 301, 403, 3, 21000),
(616, 509, 304, 403, 3, 24000),
(617, 510, 301, 401, 1, 8000),
(618, 510, 301, 403, 1, 6000),
(619, 510, 301, 407, 1, 12000),
(620, 510, 303, 401, 1, 8400),
(621, 510, 303, 403, 1, 6000),
(622, 510, 303, 407, 1, 12000),
(623, 511, 302, 401, 2, 16400),
(624, 511, 302, 407, 2, 24000),
(625, 511, 304, 401, 2, 18000),
(626, 511, 304, 407, 2, 24000),
(627, 512, 303, 402, 1, 13400),
(628, 512, 304, 402, 1, 14000),
(629, 513, 303, 403, 3, 22200),
(630, 513, 303, 407, 3, 36000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accessories`
--
ALTER TABLE `accessories`
  ADD PRIMARY KEY (`accessory_id`),
  ADD KEY `accessory_id` (`accessory_id`),
  ADD KEY `model_id` (`model_id`),
  ADD KEY `accessory_id_2` (`accessory_id`),
  ADD KEY `model_id_2` (`model_id`);

--
-- Indexes for table `car_model`
--
ALTER TABLE `car_model`
  ADD PRIMARY KEY (`model_id`),
  ADD KEY `model_id` (`model_id`),
  ADD KEY `series_id` (`series_id`);

--
-- Indexes for table `car_series`
--
ALTER TABLE `car_series`
  ADD PRIMARY KEY (`series_id`),
  ADD KEY `series_id` (`series_id`);

--
-- Indexes for table `color`
--
ALTER TABLE `color`
  ADD KEY `color_id` (`color_id`),
  ADD KEY `model_id` (`model_id`);

--
-- Indexes for table `color_details`
--
ALTER TABLE `color_details`
  ADD PRIMARY KEY (`color_id`),
  ADD KEY `color_id` (`color_id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `model_id` (`model_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_details_id`),
  ADD KEY `order_id` (`order_id`),
  ADD KEY `color_id` (`color_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accessories`
--
ALTER TABLE `accessories`
  MODIFY `accessory_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=408;

--
-- AUTO_INCREMENT for table `car_model`
--
ALTER TABLE `car_model`
  MODIFY `model_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=205;

--
-- AUTO_INCREMENT for table `car_series`
--
ALTER TABLE `car_series`
  MODIFY `series_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=514;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `order_details_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=631;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `accessories`
--
ALTER TABLE `accessories`
  ADD CONSTRAINT `accessories_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `car_model` (`model_id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `car_model`
--
ALTER TABLE `car_model`
  ADD CONSTRAINT `car_model_ibfk_1` FOREIGN KEY (`series_id`) REFERENCES `car_series` (`series_id`) ON DELETE CASCADE;

--
-- Constraints for table `color`
--
ALTER TABLE `color`
  ADD CONSTRAINT `color_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `car_model` (`model_id`) ON DELETE CASCADE;

--
-- Constraints for table `color_details`
--
ALTER TABLE `color_details`
  ADD CONSTRAINT `color_details_ibfk_1` FOREIGN KEY (`color_id`) REFERENCES `color` (`color_id`) ON DELETE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `car_model` (`model_id`) ON DELETE NO ACTION;

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
