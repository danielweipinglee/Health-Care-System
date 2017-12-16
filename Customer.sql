-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 09, 2017 at 04:33 AM
-- Server version: 5.6.35
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Customer`
--

-- --------------------------------------------------------

--
-- Table structure for table `Appointment`
--

CREATE TABLE `Appointment` (
  `ID` varchar(20) NOT NULL,
  `DoctorID` varchar(20) NOT NULL,
  `PatientID` varchar(20) NOT NULL,
  `NurseID` varchar(20) NOT NULL,
  `Date` date NOT NULL,
  `Time` varchar(20) NOT NULL,
  `Weight` varchar(20) NOT NULL,
  `Height` varchar(20) NOT NULL,
  `BloodPressure` varchar(20) NOT NULL,
  `TreatmentRecord` varchar(100) NOT NULL,
  `Prescription` varchar(100) NOT NULL,
  `Reason` varchar(20) NOT NULL,
  `TotalAmount` int(20) NOT NULL,
  `PaymentStatus` varchar(20) NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `CEO`
--

CREATE TABLE `CEO` (
  `ID` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `PIN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `CEO`
--

INSERT INTO `CEO` (`ID`, `FirstName`, `LastName`, `Phone`, `Email`, `PIN`) VALUES
('3', 'Daniel', 'Lee', '1239128129', 'lee@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `DailyReport`
--

CREATE TABLE `DailyReport` (
  `ID` int(11) NOT NULL,
  `DoctorID` varchar(20) NOT NULL,
  `NumberOfPatient` int(11) NOT NULL,
  `TotalIncome` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `DailyReport`
--

INSERT INTO `DailyReport` (`ID`, `DoctorID`, `NumberOfPatient`, `TotalIncome`, `Date`) VALUES
(1, '1', 10, 200, '2017-09-22'),
(2, '1', 26, 5600, '2017-09-26');

-- --------------------------------------------------------

--
-- Table structure for table `Doctor`
--

CREATE TABLE `Doctor` (
  `ID` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `PIN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Doctor`
--

INSERT INTO `Doctor` (`ID`, `FirstName`, `LastName`, `Phone`, `Email`, `PIN`) VALUES
('082222222', 'teresalee0822', 'teresalee0822', 'kfjgdiga', '28hd;kncp', '1234'),
('1', 'Joe', 'Swanson', '2742947363', 'joe@gmail.com', '123'),
('2', 'Ron', 'Burgundy', '8473638509', 'ron@gmail.com', '123'),
('3', 'Big', 'Bird', '8457349271', 'big@gmail.com', '123'),
('4', 'Ronald', 'McDonald', '8579487345', 'ronald@gmail.com', '123'),
('5', 'Queen', 'Latifa', '9286570000', 'queen@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `MonthlyReport`
--

CREATE TABLE `MonthlyReport` (
  `ID` int(11) NOT NULL,
  `DoctorID` varchar(20) NOT NULL,
  `NumberOfPatient` int(11) NOT NULL,
  `TotalIncome` int(11) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `MonthlyReport`
--

INSERT INTO `MonthlyReport` (`ID`, `DoctorID`, `NumberOfPatient`, `TotalIncome`, `Date`) VALUES
(1, '1', 36, 5800, '2017-10-01');

-- --------------------------------------------------------

--
-- Table structure for table `Nurse`
--

CREATE TABLE `Nurse` (
  `ID` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `PIN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Nurse`
--

INSERT INTO `Nurse` (`ID`, `FirstName`, `LastName`, `Phone`, `Email`, `PIN`) VALUES
('1', 'Jimothy', 'Doctor1', '8888888888', 'doctor1@gmail.com', '123'),
('2', 'Guldaniel', 'Doctor2', '3333333333', 'doctor2@gmail.com', '123'),
('3', 'Roberto', 'Doctor3', '9999999999', 'doctor3@gmail.com', '123'),
('4', 'Eunice', 'Doctor4', '4444444444', 'doctor4@gmail.com', '123'),
('5', 'Slothelina', 'Doctor5', '7777777777', 'doctor5@gmail.com', '123'),
('6', 'Jennifer', 'Doctor6', '8911232496', 'doctor6@gmail.com', '123'),
('7', 'Kitty', 'doctor7', '9583928456', 'kitty@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `Patient`
--

CREATE TABLE `Patient` (
  `ID` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `PIN` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Patient`
--

INSERT INTO `Patient` (`ID`, `FirstName`, `LastName`, `Phone`, `Email`, `PIN`) VALUES
('1', 'daniel', 'lee', '123123123', 'daniel@gmail.com', '123'),
('12', '', '', '', '', ''),
('3', 'kevin', 'john', '1928281', 'john@gmail.com', ''),
('4', 'john', 'john', '1238123', 'john@gmail.com', ''),
('5', 'John', 'Jackson', '9128271231', 'jackson@gmail.com', ''),
('6', 'Queen', 'Check', '8072829823', 'check@gmail.com', '');

-- --------------------------------------------------------

--
-- Table structure for table `Person`
--

CREATE TABLE `Person` (
  `ID` varchar(20) NOT NULL,
  `FirstName` varchar(20) NOT NULL,
  `LastName` varchar(20) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PIN` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Person`
--

INSERT INTO `Person` (`ID`, `FirstName`, `LastName`, `Phone`, `Email`, `PIN`) VALUES
('1', 'burrow', 'mike', '8091921827', 'mburrows1@gmail.com', '1231');

-- --------------------------------------------------------

--
-- Table structure for table `ReferenceNumber`
--

CREATE TABLE `ReferenceNumber` (
  `ref` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Appointment`
--
ALTER TABLE `Appointment`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `DoctorID` (`DoctorID`),
  ADD KEY `PatientID` (`PatientID`),
  ADD KEY `NurseID` (`NurseID`);

--
-- Indexes for table `CEO`
--
ALTER TABLE `CEO`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `DailyReport`
--
ALTER TABLE `DailyReport`
  ADD KEY `DoctorID` (`DoctorID`);

--
-- Indexes for table `Doctor`
--
ALTER TABLE `Doctor`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `MonthlyReport`
--
ALTER TABLE `MonthlyReport`
  ADD KEY `DoctorID` (`DoctorID`);

--
-- Indexes for table `Nurse`
--
ALTER TABLE `Nurse`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Patient`
--
ALTER TABLE `Patient`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Person`
--
ALTER TABLE `Person`
  ADD PRIMARY KEY (`ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Appointment`
--
ALTER TABLE `Appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`ID`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`PatientID`) REFERENCES `Patient` (`ID`),
  ADD CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`NurseID`) REFERENCES `Nurse` (`ID`);

--
-- Constraints for table `DailyReport`
--
ALTER TABLE `DailyReport`
  ADD CONSTRAINT `dailyreport_ibfk_1` FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`ID`);

--
-- Constraints for table `MonthlyReport`
--
ALTER TABLE `MonthlyReport`
  ADD CONSTRAINT `monthlyreport_ibfk_1` FOREIGN KEY (`DoctorID`) REFERENCES `Doctor` (`ID`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `clear_appointment` ON SCHEDULE EVERY 1 DAY STARTS '2017-04-24 20:00:00' ON COMPLETION NOT PRESERVE ENABLE DO DELETE from customer.appointment where Status = ' '$$

CREATE DEFINER=`root`@`localhost` EVENT `clearAppointment` ON SCHEDULE EVERY 1 DAY STARTS '2017-04-24 20:00:00' ON COMPLETION NOT PRESERVE ENABLE DO DELETE from appointment where status = ''$$

CREATE DEFINER=`root`@`localhost` EVENT `NoShowAppointment` ON SCHEDULE EVERY 1 DAY STARTS '2017-05-03 21:00:00' ENDS '2017-09-09 21:00:00' ON COMPLETION NOT PRESERVE ENABLE DO Delete from Appointment where status = ''$$

CREATE DEFINER=`root`@`localhost` EVENT `GenerateReport` ON SCHEDULE EVERY 1 DAY STARTS '2017-05-12 21:00:00' ENDS '2018-03-17 21:00:00' ON COMPLETION NOT PRESERVE ENABLE DO insert into dailyreport select FLOOR(RAND() * 99999), doctorid, count(*), sum(totalamount), date from appointment where doctorid = 1 and date = curdate()$$

CREATE DEFINER=`root`@`localhost` EVENT `MonthlyReport` ON SCHEDULE EVERY 1 MONTH STARTS '2017-05-05 08:00:00' ENDS '2018-06-15 08:00:00' ON COMPLETION NOT PRESERVE ENABLE DO insert into monthlyreport select FLOOR(RAND() * 99999), doctorid, sum(numofpatients), sum(totalamount), curdate() from dailyreport where doctorid = 1 and month(date) = month(curdate())$$

CREATE DEFINER=`root`@`localhost` EVENT `NoShowClear` ON SCHEDULE EVERY 1 DAY STARTS '2017-05-05 20:00:00' ENDS '2018-06-02 20:00:00' ON COMPLETION NOT PRESERVE ENABLE DO delete from appointment where status = ''$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
