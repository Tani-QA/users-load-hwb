# Cкрипт обработки API-запросов
# author Stepanova, date 2024-03-15

### Описание

Скрипт обрабатывает 2 метода GET, POST

GET http://localhost:8080/v1/users
response body:
{"login":"Petr","password":"qwerty123","createdDate":"2024-03-01"}

POST http://localhost:8080/v1/users
request body:
{
"login": "user1",
"password": "pass1"
}

response body:
{
"login": "user1",
"password": "pass1",
"createdDate": "2024-03-06"
}


### Результат


