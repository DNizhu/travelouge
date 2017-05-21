/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.7.18-log : Database - traveldesk
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`traveldesk` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `traveldesk`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `Employees_Id` int(11) NOT NULL,
  `Employee_name` varchar(200) DEFAULT NULL,
  `group_name` varchar(200) DEFAULT NULL,
  `designation` varchar(200) DEFAULT NULL,
  `Reporting_Manager_Name` varchar(200) DEFAULT NULL,
  `EMail_ID` varchar(200) DEFAULT NULL,
  `doj` date DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `Employee_Type` varchar(20) DEFAULT NULL,
  `leftorg` int(11) DEFAULT NULL,
  `manager` int(11) DEFAULT NULL,
  `Experience` varchar(15) DEFAULT NULL,
  `Domain` varchar(30) DEFAULT NULL,
  `highestQualification` varchar(250) DEFAULT NULL,
  `Picture` mediumblob,
  `PictureName` varchar(30) DEFAULT NULL,
  `IsWorkFromHome` tinyint(4) DEFAULT NULL,
  `OnSite` tinyint(4) DEFAULT NULL,
  `LWD` date DEFAULT NULL,
  `is_probationer` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`Employees_Id`,`Employee_name`,`group_name`,`designation`,`Reporting_Manager_Name`,`EMail_ID`,`doj`,`sex`,`Employee_Type`,`leftorg`,`manager`,`Experience`,`Domain`,`highestQualification`,`Picture`,`PictureName`,`IsWorkFromHome`,`OnSite`,`LWD`,`is_probationer`) values (1,'Nishant','Engineering LMP','Software Engineer','Sonal Upadhyay','nishant.bhatia@thepsi.com','2017-06-12','M','FT',0,0,'something',NULL,'PHD',NULL,'image',1,0,'2017-08-14',1),(2,'Sonal Kumar','Engineering LMP','Software Engineer','Sonal Upadhyay','sonal.kumar@thepsi.com','2017-06-10','F','PT',0,NULL,'2','some2thing','BTECH',NULL,'image',0,0,'2017-08-14',1),(3,'Sonal Upadhya','HR','AVP-HR','Manoj Shrimali','sonal.upadhya@thepsi.com','2017-06-10','F','PT',0,NULL,'2','some2thing','BTECH',NULL,'image',0,0,'2017-08-14',0);

/*Table structure for table `probation_data` */

DROP TABLE IF EXISTS `probation_data`;

CREATE TABLE `probation_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_code` bigint(20) DEFAULT NULL,
  `form` varchar(500) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `probation_data` */

insert  into `probation_data`(`id`,`emp_code`,`form`,`rating`,`status`) values (1,1,'GENERAL_COMMENTS_FORM',0,'SELF_COMPLETED'),(2,1,'MID_TERM_FORM',1,'GH_COMPLETED'),(3,1,'PROBATION_EVALUATION_FORM',0,'HR_COMPLETED');

/*Table structure for table `probation_delegation_data` */

DROP TABLE IF EXISTS `probation_delegation_data`;

CREATE TABLE `probation_delegation_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `emp_code` bigint(20) DEFAULT NULL,
  `delegated_by` bigint(20) DEFAULT NULL,
  `delegated_to` bigint(20) DEFAULT NULL,
  `form` varchar(500) DEFAULT NULL,
  `last_updated_by` varchar(200) DEFAULT NULL,
  `last_updated_on` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `probation_delegation_data` */

/*Table structure for table `role_master` */

DROP TABLE IF EXISTS `role_master`;

CREATE TABLE `role_master` (
  `RoleID` int(11) NOT NULL,
  `Role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_master` */

insert  into `role_master`(`RoleID`,`Role`) values (1,'ADMIN'),(2,'HR'),(3,'MGMT'),(4,'GH'),(5,'AVP');

/*Table structure for table `telpp_impact_status` */

DROP TABLE IF EXISTS `telpp_impact_status`;

CREATE TABLE `telpp_impact_status` (
  `ID` int(11) NOT NULL,
  `EMP_ID` int(11) NOT NULL,
  `TELPP` int(11) DEFAULT NULL,
  `IMPACT` int(11) DEFAULT NULL,
  `IMPACT2` int(11) NOT NULL,
  `BAND_ACHIEVED` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `telpp_impact_status` */

insert  into `telpp_impact_status`(`ID`,`EMP_ID`,`TELPP`,`IMPACT`,`IMPACT2`,`BAND_ACHIEVED`) values (1,1,1,1,1,1),(2,2,1,1,1,1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `ID` int(11) NOT NULL,
  `EmpID` int(11) NOT NULL,
  `RoleID` int(11) NOT NULL,
  `Group_name` varchar(50) DEFAULT NULL,
  `Group` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`ID`,`EmpID`,`RoleID`,`Group_name`,`Group`) values (1,3,2,'HR',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
