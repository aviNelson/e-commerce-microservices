Небольшое приложение для оформления заказов.

Мотивация проекта: понять как между собой взаимодействуют микросервисы и реализовать это. 

Реализованы : order-service, inventory-service, product-service.
Пользователь может оформлять заказы через order-service. Взаимодействует пользователь с order-service через api-gateway. 

Взаимодействияе микросервисов между собой происходит с помощью eureka-server и feign-client.

Стек: Java 11, Spring Boot, Spring Security, 
Spring MVC, Spring Data JPA, Spring Cloud, Apache Kafka, Docker compose, SQL(Postgresql), Liquibase, Swagger, Gradle.

В docker compose файле уже прописаны нужные docker image ,ничего дополнительно билдить не нужно, так как приложение собрано в docker image через Dockerfile. Для запуска проекта требуется из корневой папки проекта запустить команду docker compose -up, будут загружены docker image из docker hub.
