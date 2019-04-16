CREATE DATABASE IF NOT EXISTS `datagen` DEFAULT CHARACTER SET utf8 ;
USE `datagen` ;

-- -----------------------------------------------------
-- Table `transporter`.`dataGenTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `datagen`.`dataGenTable` (
  `id` VARCHAR(50) NOT NULL,
  `created_at` BIGINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;