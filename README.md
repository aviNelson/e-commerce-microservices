Небольшое приложение для оформления заказов.

Реализованы : order-service, inventory-service, product-service.
Пользователь может оформлять заказы через order-service. Взаимодействует пользователь с order-service через api-gateway. 

Взаимодействияе микросервисов между собой происходит с помощью eureka-server и feign-client.

Стек: Java 11, Spring Boot, Spring Security, 
Spring MVC, Spring Data JPA, Spring Cloud, Apache Kafka, Docker compose, SQL(Postgresql), Liquibase, Swagger, Gradle.
