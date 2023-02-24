Небольшое e-commerce приложение для оформления заказов.

Мотивация проекта: понять как между собой взаимодействуют микросервисы и реализовать это. 

Стек: Java 11, Spring Boot, Spring MVC, Spring Data JPA, Spring Cloud, Apache Kafka, Docker compose, SQL(Postgresql), Liquibase, Swagger, Gradle.

Реализованы : order-service, inventory-service, product-service.
Пользователь может оформлять заказы через order-service. 

Так же реализован discovery-server с помощью eureka-client.
Взаимодействие микросервисов между собой происходит с помощью feign-client.
Настроена удалённая конфигурация микросервисов с помощью Spring cloud config, реализован config-server. 
Взаимодействие клиента с сервисами происхдит через api-gateway.


В docker compose файле уже прописаны нужные docker image ,ничего дополнительно билдить не нужно, так как микросервисы уже собраны в docker image через jib.
Для запуска проекта требуется из корневой папки проекта запустить команду docker compose -up, из docker hub будут загружены docker image.
