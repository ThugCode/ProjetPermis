/*==============================================================*/
/* Base de données : runwaylicence                              */
/*==============================================================*/
CREATE DATABASE IF NOT EXISTS `runwaylicence`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE `runwaylicence`;

/*==============================================================*/
/* Table : student                                              */
/*==============================================================*/

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(100) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `mail` varchar(100) NOT NULL UNIQUE,
  `password` char(64) NOT NULL,
  `is_enabled` boolean NOT NULL,
  `is_admin` boolean NOT NULL,
  PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : message                                              */
/*==============================================================*/

DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(100) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `id_student` int(11) NOT NULL,
  `read` boolean,
  `dateReception` date,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_student`) REFERENCES student(id)
);

/*==============================================================*/
/* Table : log_logins                                              */
/*==============================================================*/

DROP TABLE IF EXISTS `log_logins`;
CREATE TABLE IF NOT EXISTS `log_logins` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_student` int(11) NOT NULL,
  `date_login` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_student`) REFERENCES student(id)
);

/*==============================================================*/
/* Table : game                                                 */
/*==============================================================*/

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : action                                               */
/*==============================================================*/

DROP TABLE IF EXISTS `action`;
CREATE TABLE IF NOT EXISTS `action` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : mission                                              */
/*==============================================================*/

DROP TABLE IF EXISTS `mission`;
CREATE TABLE IF NOT EXISTS `mission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : goal                                                 */
/*==============================================================*/

DROP TABLE IF EXISTS `goal`;
CREATE TABLE IF NOT EXISTS `goal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : rule                                                 */
/*==============================================================*/
DROP TABLE IF EXISTS `rule`;
CREATE TABLE IF NOT EXISTS `rule` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) DEFAULT NULL,
	`minimum_score` int(11) DEFAULT NULL,
	PRIMARY KEY (`id`)
);

/*==============================================================*/
/* Table : configuration                                        */
/*==============================================================*/
DROP TABLE IF EXISTS `configuration`;
CREATE TABLE IF NOT EXISTS `configuration` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) UNIQUE,
	`value` varchar(100) DEFAULT NULL,
	PRIMARY KEY (`id`)
);
  
/*==============================================================*/
/* Table : action_action                                        */
/*==============================================================*/

DROP TABLE IF EXISTS `action_action`;
CREATE TABLE IF NOT EXISTS `action_action` (
  `id_parent` int(11) NOT NULL,
  `id_child` int(11) NOT NULL,
  PRIMARY KEY (`id_parent`,`id_child`),
  FOREIGN KEY (`id_parent`) REFERENCES action(id),
  FOREIGN KEY (`id_child`) REFERENCES action(id)
);

/*==============================================================*/
/* Table : game_action                                          */
/*==============================================================*/

DROP TABLE IF EXISTS `game_action`;
CREATE TABLE IF NOT EXISTS `game_action` (
  `id_game` int(11) NOT NULL,
  `id_action` int(11) NOT NULL,
  PRIMARY KEY (`id_game`,`id_action`),
  FOREIGN KEY (`id_game`) REFERENCES game(id),
  FOREIGN KEY (`id_action`) REFERENCES action(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table : action_goal                                          */
/*==============================================================*/

DROP TABLE IF EXISTS `action_goal`;
CREATE TABLE IF NOT EXISTS `action_goal` (
  `id_action` int(11) NOT NULL,
  `id_goal` int(11) NOT NULL,
  PRIMARY KEY (`id_action`,`id_goal`),
  FOREIGN KEY (`id_action`) REFERENCES action(id),
  FOREIGN KEY (`id_goal`) REFERENCES goal(id)
);

/*==============================================================*/
/* Table : mission_goal                                         */
/*==============================================================*/

DROP TABLE IF EXISTS `mission_goal`;
CREATE TABLE IF NOT EXISTS `mission_goal` (
  `id_mission` int(11) NOT NULL,
  `id_goal` int(11) NOT NULL,
  PRIMARY KEY (`id_mission`,`id_goal`),
  FOREIGN KEY (`id_mission`) REFERENCES mission(id),
  FOREIGN KEY (`id_goal`) REFERENCES goal(id)
);

/*==============================================================*/
/* Table : flag                                                 */
/*==============================================================*/

DROP TABLE IF EXISTS `flag`;
CREATE TABLE IF NOT EXISTS `flag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_action` int(11) NOT NULL,
  `description` varchar(100),
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_action`) REFERENCES action(id)
);

/*==============================================================*/
/* Table : student_game                                         */
/*==============================================================*/

DROP TABLE IF EXISTS `student_game`;
CREATE TABLE IF NOT EXISTS `student_game` (
  `id_student` int(11) NOT NULL,
  `id_game` int(11) NOT NULL,
  PRIMARY KEY (`id_student`, `id_game`),
  FOREIGN KEY (`id_student`) REFERENCES student(id),
  FOREIGN KEY (`id_game`) REFERENCES game(id)
);

/*==============================================================*/
/* Table : game_mission                                         */
/*==============================================================*/

DROP TABLE IF EXISTS `game_mission`;
CREATE TABLE IF NOT EXISTS `game_mission` (
   `id_game` int(11) NOT NULL,
   `id_mission` int(11) NOT NULL,
   PRIMARY KEY (`id_game`, `id_mission`),
   FOREIGN KEY (`id_game`) REFERENCES game(id),
   FOREIGN KEY (`id_mission`) REFERENCES mission(id)
);

/*==============================================================*/
/* Table : student_action                                       */
/*==============================================================*/

DROP TABLE IF EXISTS `student_action`;
CREATE TABLE IF NOT EXISTS `student_action` (
  `id_student` int(11) NOT NULL,
  `id_action` int(11) NOT NULL,
  `date` date NOT NULL,
  `value` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id_student`, `id_action`, `date`),
  FOREIGN KEY (`id_student`) REFERENCES student(id),
  FOREIGN KEY (`id_action`) REFERENCES action(id)
);

/*==============================================================*/
/* Table : action_rule                                          */
/*==============================================================*/
DROP TABLE IF EXISTS `action_rule`;
CREATE TABLE IF NOT EXISTS `action_rule` (
	`id_action` int(11) NOT NULL,
	`id_rule` int(11) NOT NULL,
	PRIMARY KEY (`id_action`, `id_rule`),
	FOREIGN KEY (`id_action`) REFERENCES action(id),
	FOREIGN KEY (`id_rule`) REFERENCES rule(id)
);