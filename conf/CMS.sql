-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2014-09-19 09:19:45
-- 服务器版本: 5.6.12
-- PHP 版本: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `CMS`
--

-- --------------------------------------------------------

--
-- 表的结构 `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `type` varchar(255) NOT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `agency`
--

CREATE TABLE IF NOT EXISTS `agency` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `agency`
--

INSERT INTO `agency` (`id`, `password`, `name`, `phone`, `email`) VALUES
(1, '11', 'SCDF', '111', '1111@1.com'),
(2, '22', 'MHA', '222', '2222@2.com'),
(3, '33', 'MOE', '333', '3333@3.com');

-- --------------------------------------------------------

--
-- 表的结构 `call_operator`
--

CREATE TABLE IF NOT EXISTS `call_operator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- 转存表中的数据 `call_operator`
--

INSERT INTO `call_operator` (`id`, `name`, `password`, `phone`) VALUES
(4, 'RPC', '44', '444'),
(5, 'GWC', '55', '555'),
(6, 'LYC', '66', '666');

-- --------------------------------------------------------

--
-- 表的结构 `dispatch`
--

CREATE TABLE IF NOT EXISTS `dispatch` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eventID` bigint(20) DEFAULT NULL,
  `agencyID` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `dispatch_time` datetime DEFAULT NULL,
  `read_time` datetime DEFAULT NULL,
  `solve_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_dispatch_event_1` (`eventID`),
  KEY `ix_dispatch_agency_2` (`agencyID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `dispatch`
--

INSERT INTO `dispatch` (`id`, `eventID`, `agencyID`, `status`, `dispatch_time`, `read_time`, `solve_time`) VALUES
(1, 11, 1, 'Sent', '2014-09-19 12:05:00', NULL, NULL),
(2, 11, 2, 'Read', '2014-09-19 13:05:00', '2014-09-19 13:10:00', NULL),
(3, 22, 3, 'Solved', '2014-09-19 14:05:00', '2014-09-19 14:10:00', '2014-09-19 14:15:00');

-- --------------------------------------------------------

--
-- 表的结构 `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `event_type` varchar(255) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `calling_time` datetime DEFAULT NULL,
  `postal_code` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `caller_phone` varchar(255) DEFAULT NULL,
  `description` longtext,
  `callOperator_id` bigint(20) DEFAULT NULL,
  `serviceOperator_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_event_callOperator_3` (`callOperator_id`),
  KEY `ix_event_serviceOperator_4` (`serviceOperator_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=34 ;

--
-- 转存表中的数据 `event`
--

INSERT INTO `event` (`id`, `event_type`, `priority`, `calling_time`, `postal_code`, `location`, `caller_phone`, `description`, `callOperator_id`, `serviceOperator_id`) VALUES
(11, 'dengue', 1, '2014-09-19 12:00:00', '11111', 'SouthWest', '111', 'Dengue here', 4, NULL),
(22, 'Gas Leak', 2, '2014-09-19 13:00:00', '222222', 'Central', '222', 'Gas Leak Here', 5, 7),
(33, 'None', NULL, '2014-09-19 14:00:00', '333333', 'NorthEast', '333', 'Riot Here', 6, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `eventID` bigint(20) DEFAULT NULL,
  `media_type` varchar(255) DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ix_notification_event_5` (`eventID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `notification`
--

INSERT INTO `notification` (`id`, `eventID`, `media_type`, `send_time`) VALUES
(1, 11, 'SMS', '2014-09-12 12:30:00'),
(2, 11, 'Facebook', '2014-09-19 12:35:00'),
(3, 22, 'Twitter', '2014-09-12 13:30:00');

-- --------------------------------------------------------

--
-- 表的结构 `play_evolutions`
--

CREATE TABLE IF NOT EXISTS `play_evolutions` (
  `id` int(11) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `applied_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `apply_script` text,
  `revert_script` text,
  `state` varchar(255) DEFAULT NULL,
  `last_problem` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 转存表中的数据 `play_evolutions`
--

INSERT INTO `play_evolutions` (`id`, `hash`, `applied_at`, `apply_script`, `revert_script`, `state`, `last_problem`) VALUES
(1, 'b8c9d4136a16e85ffd5876375d55bd7c10462025', '2014-09-18 15:06:53', 'create table account (\ntype                      varchar(255) not null,\naccount_name              varchar(255),\npassword                  varchar(255),\nconstraint pk_account primary key (type))\n;\n\ncreate table agency (\nid                        bigint auto_increment not null,\npassword                  varchar(255),\nname                      varchar(255),\nphone                     varchar(255),\nemail                     varchar(255),\nconstraint pk_agency primary key (id))\n;\n\ncreate table call_operator (\nid                        bigint auto_increment not null,\nname                      varchar(255),\npassword                  varchar(255),\nphone                     varchar(255),\nconstraint pk_call_operator primary key (id))\n;\n\ncreate table dispatch (\nid                        bigint auto_increment not null,\neventID                   bigint,\nagencyID                  bigint,\nstatus                    varchar(255),\ndispatch_time             datetime,\nread_time                 datetime,\nsolve_time                datetime,\nconstraint pk_dispatch primary key (id))\n;\n\ncreate table event (\nid                        bigint auto_increment not null,\nevent_type                varchar(255),\npriority                  integer,\ncalling_time              datetime,\npostal_code               varchar(255),\nlocation                  varchar(255),\ncaller_phone              varchar(255),\ndescription               longtext,\ncallOperator_id           bigint,\nserviceOperator_id        bigint,\nconstraint pk_event primary key (id))\n;\n\ncreate table notification (\nid                        bigint auto_increment not null,\neventID                   bigint,\nmedia_type                varchar(255),\nsend_time                 datetime,\nconstraint pk_notification primary key (id))\n;\n\ncreate table public (\nhand_phone                varchar(255) not null,\nlocation                  varchar(255),\nname                      varchar(255),\nconstraint pk_public primary key (hand_phone))\n;\n\ncreate table service_operator (\nid                        bigint auto_increment not null,\nname                      varchar(255),\npassword                  varchar(255),\nphone                     varchar(255),\nconstraint pk_service_operator primary key (id))\n;\n\nalter table dispatch add constraint fk_dispatch_event_1 foreign key (eventID) references event (id) on delete restrict on update restrict;\ncreate index ix_dispatch_event_1 on dispatch (eventID);\nalter table dispatch add constraint fk_dispatch_agency_2 foreign key (agencyID) references agency (id) on delete restrict on update restrict;\ncreate index ix_dispatch_agency_2 on dispatch (agencyID);\nalter table event add constraint fk_event_callOperator_3 foreign key (callOperator_id) references call_operator (id) on delete restrict on update restrict;\ncreate index ix_event_callOperator_3 on event (callOperator_id);\nalter table event add constraint fk_event_serviceOperator_4 foreign key (serviceOperator_id) references service_operator (id) on delete restrict on update restrict;\ncreate index ix_event_serviceOperator_4 on event (serviceOperator_id);\nalter table notification add constraint fk_notification_event_5 foreign key (eventID) references event (id) on delete restrict on update restrict;\ncreate index ix_notification_event_5 on notification (eventID);', 'SET FOREIGN_KEY_CHECKS=0;\n\ndrop table account;\n\ndrop table agency;\n\ndrop table call_operator;\n\ndrop table dispatch;\n\ndrop table event;\n\ndrop table notification;\n\ndrop table public;\n\ndrop table service_operator;\n\nSET FOREIGN_KEY_CHECKS=1;', 'applied', '');

-- --------------------------------------------------------

--
-- 表的结构 `public`
--

CREATE TABLE IF NOT EXISTS `public` (
  `hand_phone` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hand_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- 表的结构 `service_operator`
--

CREATE TABLE IF NOT EXISTS `service_operator` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `service_operator`
--

INSERT INTO `service_operator` (`id`, `name`, `password`, `phone`) VALUES
(7, 'LY', '77', '777'),
(8, 'MHQ', '8', '888'),
(9, 'SRI', '9', '999');

--
-- 限制导出的表
--

--
-- 限制表 `dispatch`
--
ALTER TABLE `dispatch`
  ADD CONSTRAINT `fk_dispatch_agency_2` FOREIGN KEY (`agencyID`) REFERENCES `agency` (`id`),
  ADD CONSTRAINT `fk_dispatch_event_1` FOREIGN KEY (`eventID`) REFERENCES `event` (`id`);

--
-- 限制表 `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `fk_event_callOperator_3` FOREIGN KEY (`callOperator_id`) REFERENCES `call_operator` (`id`),
  ADD CONSTRAINT `fk_event_serviceOperator_4` FOREIGN KEY (`serviceOperator_id`) REFERENCES `service_operator` (`id`);

--
-- 限制表 `notification`
--
ALTER TABLE `notification`
  ADD CONSTRAINT `fk_notification_event_5` FOREIGN KEY (`eventID`) REFERENCES `event` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
