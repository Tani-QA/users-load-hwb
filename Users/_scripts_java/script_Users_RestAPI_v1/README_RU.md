# Cкрипт обработки API-запросов
# author Stepanova, date 2024-03-06

### Описание

Скрипт обрабатывает 2 метода GET, POST

GET http://localhost:8090/v1/users
response body:
[
{
"id": 1,
"login": "user1",
"password": "pass1",
"createdDate": "2024-03-06"
}
]

GET http://localhost:8090/v1/users/id
response body:
{
"id": 1,
"login": "user1",
"password": "pass1",
"createdDate": "2024-03-06"
}

POST http://localhost:8090/v1/users
request body:
{
"login": "user1",
"password": "pass1"
}

response body:
{
"id": 1,
"login": "user1",
"password": "pass1",
"createdDate": "2024-03-06"
}


### Результат
