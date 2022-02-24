INSERT INTO client(first_name, second_name, last_name)
VALUES ('Иван', 'Иванов', 'Иванович'),
       ('Петр', 'Петров', 'Петрович'),
       ('Сидор', 'Сидоров', 'Сидорович');

INSERT INTO card(card_number, pin, expire_date, amount, currency, client_id)
VALUES (123, 123, '2023-01-01', 200.2, 'RUB', 1),
       (456, 456, '2024-02-02', 500.5, 'USD', 2),
       (789, 789, '2025-03-03', 800.8, 'EUR', 3);

INSERT INTO card(card_number, pin, expire_date, is_blocked, currency, client_id)
VALUES (111, 111, '2021-01-01', false, 'RUB', 3),
       (222, 222, '2022-12-01', true, 'RUB', 2);