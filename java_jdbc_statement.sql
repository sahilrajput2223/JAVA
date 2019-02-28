-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 28, 2019 at 03:20 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_jdbc_statement`
--

-- --------------------------------------------------------

--
-- Table structure for table `form`
--

CREATE TABLE `form` (
  `id` int(3) NOT NULL,
  `Fname` varchar(20) NOT NULL,
  `Lname` varchar(20) NOT NULL,
  `Age` int(3) NOT NULL,
  `Phone` bigint(13) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Birthdate` varchar(10) NOT NULL,
  `Gender` varchar(7) NOT NULL,
  `Hobbie` varchar(100) NOT NULL,
  `Language` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `form`
--

INSERT INTO `form` (`id`, `Fname`, `Lname`, `Age`, `Phone`, `Email`, `Birthdate`, `Gender`, `Hobbie`, `Language`) VALUES
(1, 'temp0', 'temp0', 10, 1111100000, 'temp0@gmail.com', '1010-10-10', 'male', 'Games,Coding,Music,Painting', 'php,asp.net,python,java,android'),
(2, 'temp1', 'temp1', 11, 1111111111, 'temp1@gmail.com', '1111-11-11', 'male', 'Games,Music', 'php,python,android'),
(3, 'temp2', 'temp2', 22, 2222222222, 'temp2@gmail.com', '2222-02-22', 'male', 'Coding,Painting', 'asp.net,java'),
(4, 'temp3', 'temp3', 33, 3333333333, 'temp3@gmail.com', '2017-02-13', 'male', 'Coding,Music,Painting', 'asp.net,python,java'),
(5, 'temp4', 'temp4', 44, 4444444444, 'temp4@gmail.com', '2015-04-14', 'female', 'Games,Coding,Music', 'php,asp.net,java'),
(7, 'temp5', 'temp5', 22, 5555555555, 'test5@gmail.com', '2017-12-26', 'male', 'Coding,Music', 'php,asp.net,java');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `form`
--
ALTER TABLE `form`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `form`
--
ALTER TABLE `form`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
