CREATE TABLE IF NOT EXISTS `client` (
    `client_account_id` INT NOT NULL AUTO_INCREMENT,
    `baozou_id` VARCHAR(32) NOT NULL,
    `number_of_standard_coin` INT NOT NULL DEFAULT 0,
    `number_of_wangnima_coin` INT NOT NULL DEFAULT 0,
    `number_of_zhijin_coin` INT NOT NULL DEFAULT 0,
    `number_of_muzi_coin` INT NOT NULL DEFAULT 0,
    `number_of_pino_coin` INT NOT NULL DEFAULT 0,
    `number_of_zhangquandan_coin` INT NOT NULL DEFAULT 0,
    `number_of_daduizhang_coin` INT NOT NULL DEFAULT 0,
    `number_of_zhaotiezhu_coin` INT NOT NULL DEFAULT 0,
    `number_of_luofugui_coin` INT NOT NULL DEFAULT 0,
    PRIMARY KEY (`client_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `coin` (
    `coin_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `description` VARCHAR(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `generated_coin` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `coin_uuid` VARCHAR(32) NOT NULL,
    `current_event_id` INT NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event` (
    `event_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `description` VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `coin_history` (
    `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `coin_uuid` VARCHAR(32) NOT NULL,
    `event_id` INT NOT NULL,
    `time` DATETIME
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

