# graduation_project
Приложение для получения клиентом баланса по карте через банкомат.

Клиентская часть приложения запускается на порту 9090.
После запуска клиентская часть доступна по ссылке:
http://localhost:9090/balance/card_number/ваш_номер_карты/pin/ваш_пин

вместо ваш_номер_карты и ваш_пин необходимо подставить искомые данные
(для тестирования разных вариантов ответа можно использовать данные:
123 123,
456 456,
789 789,
111 111,
222 222)

Сервер запускается на порту 8080.
После запуска сервер доступен по ссылке:
http://localhost:8080/server/getinfo

Логин admin, пароль 123