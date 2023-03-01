<br/>
<p align="center">
  <h3 align="left">Microservices-project</h3>

  <p align="left">
    Небольшое e-commerce приложение для оформления заказов.
    <br/>
    <br/>
  </p>
</p>

![Contributors](https://img.shields.io/github/contributors/AviNelson/microservices-project?color=dark-green) ![Issues](https://img.shields.io/github/issues/AviNelson/microservices-project) 

## Оглавление

* [О проекте](#о-проекте)
* [Стек](#стек)
* [Установка](#установка)
* [Пример использования](#пример-использования)

## О проекте

Небольшое e-commerce приложение для оформления заказов.
Проект написан с использование микросервисного подхода.

Реализованы:
* order-service
* inventory-service
* product-service
* notification-service
* config-server
* discovery-server (netflix-eureka)
* api-gateway

## Стек

* Java 11
* Spring Boot
* Spring Cloud (Eureka, Feign-client, Config Server, API Gateway)
* Spring Data JPA
* Spring MVC
* PostgreSQL
* SQL
* Docker compose
* Jib
* Apache Kafka
* Gradle
* Liquibase
* Swagger

### Установка

1. Клонировать репозиторий

```sh
git clone https://github.com/aviNelson/microservices-project.git
```

2. В корневой папке проекта запустить

```sh
docker compose up
```

3. После этого будут скачаны docker-image's с docker-hub и приложение запустится

## Пример использования

Клиент отправляет запрос на оформление заказа в order-service через api-gateway, order-service проверяет количество товаров через inventory-service. 
Если заказ успешно оформлен, order-service отправляет сообщение в notification-service через Kafka.


