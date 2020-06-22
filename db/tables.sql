
CREATE DATABASE  "challenge" ;
USE "challenge";
CREATE TABLE
IF NOT EXISTS challenge.transactions
(
  `transaction_id` INT
(11) NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NOT NULL,
  `description` VARCHAR
(100) NOT NULL,
  `date` DATE NOT NULL,
  `user_id` INT
(11) NOT NULL,
  PRIMARY KEY
(`transaction_id`),
  UNIQUE INDEX `transaction_id_UNIQUE`
(`transaction_id` ASC) VISIBLE)
ENGINE = InnoDB;
CREATE TABLE `challenge`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `sum` DOUBLE NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE);

