-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2019 at 01:16 PM
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
-- Database: `java_jdbc_prepared_statement`
--

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `id` int(3) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `phone` bigint(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `birthdate` date NOT NULL,
  `gender` varchar(6) NOT NULL,
  `hobbies` varchar(100) NOT NULL,
  `languages` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`id`, `fname`, `lname`, `age`, `phone`, `email`, `birthdate`, `gender`, `hobbies`, `languages`) VALUES
(1, 'temp1', 'temp1', 11, 1111111111, 'temp1@gmail.com', '1111-11-11', 'male', 'Coding,Painting', 'python,java,android'),
(2, 'temp2', 'temp2', 22, 2222222222, 'temp2@gmail.com', '2222-02-22', 'male', 'Games,Coding,Music', 'asp.net,python,android'),
(3, 'temp3', 'temp3', 33, 3333333333, 'temp3@gmail.com', '2019-03-31', 'female', 'Games,Music', 'asp.net,android'),
(4, 'temp4', 'temp4', 20, 4444444444, 'temp4@gmail.com', '2019-04-14', 'male', 'Games,Coding,Painting', 'asp.net,python,java'),
(8, 'test5', 'temp5', 25, 5555555555, 'temp5@gmail.com', '2015-11-18', 'female', 'Coding,Painting', 'php,python');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
