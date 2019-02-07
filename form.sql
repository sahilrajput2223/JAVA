-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2019 at 02:15 PM
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
(3, 'test1', 'test1', 1, 1111111111, 'test1@gmail.com', '1111-11-11', 'male', 'Games,Coding,Music,Painting,', 'php,asp.net,python,java,android,'),
(4, 'Test2', 'Test2', 22, 2222222222, 'Test2@gmail.com', '2019-02-22', 'male', 'Games,Music,', 'php,python,android,'),
(6, 'Test3', 'Test3', 33, 3333333333, 'Test3@gmail.com', '2019-03-31', 'female', 'Games,Coding,Music,', 'php,asp.net,java,android,');

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
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
