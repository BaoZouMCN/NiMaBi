INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'WANGNIMA') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'WANGNIMA'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'ZHIJIN') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'ZHIJIN'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'MUZI') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'MUZI'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'PINO') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'PINO'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'ZHANGQUANDAN') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'ZHANGQUANDAN'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'DADUIZHANG') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'DADUIZHANG'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'ZHAOTIEZHU') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'ZHAOTIEZHU'
) LIMIT 1;

INSERT INTO coin_definition(description)
SELECT * FROM (SELECT 'LUOFUGUI') AS tmp
WHERE NOT EXISTS (
    SELECT description FROM coin_definition WHERE description = 'LUOFUGUI'
) LIMIT 1;
