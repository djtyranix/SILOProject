-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2021 at 03:18 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `silo`
--

-- --------------------------------------------------------

--
-- Table structure for table `deliverynote`
--

CREATE TABLE `deliverynote` (
  `id` bigint(20) NOT NULL,
  `invoice_id` varchar(20) NOT NULL,
  `custName` varchar(255) NOT NULL,
  `custEmail` varchar(255) NOT NULL,
  `orderDate` varchar(11) NOT NULL,
  `deliveryDate` varchar(11) NOT NULL,
  `items` varchar(512) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `deliverynote`
--

INSERT INTO `deliverynote` (`id`, `invoice_id`, `custName`, `custEmail`, `orderDate`, `deliveryDate`, `items`, `status`) VALUES
(1, '123456', 'Restu', 'restu@gmail.com', '17-01-2021', '18-01-2021', '1-2', 3),
(2, '654321', 'Rama', 'rama@gmail.com', '18-01-2021', '19-01-2021', '2-10,3-10', 2);

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` bigint(20) NOT NULL,
  `poNumber` varchar(20) NOT NULL,
  `supplierName` varchar(255) NOT NULL,
  `orderDate` varchar(11) NOT NULL,
  `deliveryDate` varchar(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`id`, `poNumber`, `supplierName`, `orderDate`, `deliveryDate`, `status`) VALUES
(1, '123', 'PT Citra Jaya', '13-01-2021', '16-01-2021', 1),
(2, '124', 'PT Sinar Jaya', '13-01-2021', '14-01-2021', 3);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `barcode` int(16) NOT NULL,
  `title` varchar(256) NOT NULL,
  `description` varchar(512) NOT NULL,
  `manufacturer` varchar(256) NOT NULL,
  `url` varchar(512) NOT NULL,
  `numberOfStocks` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `barcode`, `title`, `description`, `manufacturer`, `url`, `numberOfStocks`) VALUES
(1, 12345678, 'Thermogun Device', 'A device to measure human body temperature', 'its', 'store.its.ac.id/product/thermogun-device', 3),
(2, 87654321, 'Masker 3 Ply Sensi', 'Masker merek sensi dengan desain yang bagus', 'sensi', 'store.its.ac.id/product/sensi-mask', 200),
(3, 80156912, 'Face Shield Mask', 'Face shield berguna sebagai proteksi tambahan', 'its', 'store.its.ac.id/product/face-mask', 250);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `deliverynote`
--
ALTER TABLE `deliverynote`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deliverynote`
--
ALTER TABLE `deliverynote`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
