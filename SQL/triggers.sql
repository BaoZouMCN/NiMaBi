DELIMITER $$
CREATE TRIGGER `coin_history_datetime` BEFORE INSERT ON `coin_history`FOR EACH ROW
    BEGIN IF new.`time` IS NULL THEN SET new.`time` = now();
        END IF;
    END$$
DELIMITER ;

