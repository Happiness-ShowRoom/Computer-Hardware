CREATE DATABASE IF NOT EXISTS computer_hardware
    COLLATE utf8_general_ci;

DROP TABLE IF EXISTS components;
CREATE TABLE components (
  id INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `necessary` BIT(1) NOT NULL DEFAULT b'0',
  `quantity` INT(8),
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Motherboard', 1, 2);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Sound card', 0, 1);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('CPU', 1, 4);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('RGB Lighting', 0, 0);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('HDD', 0, 5);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Case', 1, 10);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('RAM', 1, 7);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('SSD', 1, 4);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Graphics card', 0, 10);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Keyboard', 0, 0);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Display', 0, 0);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Printer', 0, 2);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Multimedia speakers', 0, 1);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Mouse', 0, 10);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Image scanner', 0, 1);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Webcam', 0, 5);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Optical disc', 0, 3);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Touchpad', 0, 1);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Microphone', 0, 6);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Headphones', 0, 3);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('USB flash drive', 0, 19);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Gamepad', 0, 4);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Fan', 0, 22);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Water Cooling Kit', 0, 2);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('Digital pen', 0, 3);
INSERT INTO components (`name`, `necessary`, `quantity`) VALUES ('MIDI keyboard', 0, 1);