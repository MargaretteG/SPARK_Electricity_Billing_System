-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2024 at 04:46 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sparkdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admintbl`
--

CREATE TABLE `admintbl` (
  `admin_id` int(10) NOT NULL,
  `admin_un` varchar(250) NOT NULL,
  `admin_pw` varchar(250) NOT NULL,
  `admin_name` varchar(250) NOT NULL,
  `ad_address` varchar(250) NOT NULL,
  `ad_email` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admintbl`
--

INSERT INTO `admintbl` (`admin_id`, `admin_un`, `admin_pw`, `admin_name`, `ad_address`, `ad_email`) VALUES
(1, 'admin', 'adminpass', '', '', ''),
(2, 'admin2', '123', 'Admin Admin', 'Lipa City, Batngas', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `billtbl`
--

CREATE TABLE `billtbl` (
  `bill_id` int(11) NOT NULL,
  `Customer_Name` varchar(250) NOT NULL,
  `Meter_Number` int(250) NOT NULL,
  `Total_Kwh` int(250) NOT NULL,
  `Total_Cost` int(250) NOT NULL,
  `Status` varchar(250) NOT NULL,
  `Month` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `billtbl`
--

INSERT INTO `billtbl` (`bill_id`, `Customer_Name`, `Meter_Number`, `Total_Kwh`, `Total_Cost`, `Status`, `Month`) VALUES
(1, 'user', 76543, 95, 1125, 'not paid', 'November'),


--
-- Triggers `billtbl`
--
DELIMITER $$
CREATE TRIGGER `before_insert_billtbl` BEFORE INSERT ON `billtbl` FOR EACH ROW BEGIN
    SET NEW.bill_id = CONCAT('EBI', LPAD(NEW.bill_id, 4, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `usertbl`
--

CREATE TABLE `usertbl` (
  `user_id` int(10) NOT NULL,
  `user_un` varchar(250) NOT NULL,
  `user_pw` varchar(250) NOT NULL,
  `Customer_Name` varchar(250) NOT NULL,
  `Meter_Number` int(20) NOT NULL,
  `Address` varchar(500) NOT NULL,
  `Email` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usertbl`
--

INSERT INTO `usertbl` (`user_id`, `user_un`, `user_pw`, `Customer_Name`, `Meter_Number`, `Address`, `Email`) VALUES
(1, 'user', 'user', 'user', 12345, 'Tanauan City, Batangas', 'user@gmail.com'),


--
-- Indexes for dumped tables
--

--
-- Indexes for table `admintbl`
--
ALTER TABLE `admintbl`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `billtbl`
--
ALTER TABLE `billtbl`
  ADD PRIMARY KEY (`bill_id`);

--
-- Indexes for table `usertbl`
--
ALTER TABLE `usertbl`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admintbl`
--
ALTER TABLE `admintbl`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `billtbl`
--
ALTER TABLE `billtbl`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `usertbl`
--
ALTER TABLE `usertbl`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
