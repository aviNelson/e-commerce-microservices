package com.example.orderservice.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void sendMessage(OrderPlacedEvent orderPlacedEvent) {
        log.info(String.format("Message sent -> %s", orderPlacedEvent.toString()));

        Message<OrderPlacedEvent> message = MessageBuilder.withPayload(orderPlacedEvent).setHeader(KafkaHeaders.TOPIC, "notificationTopic").build();

        kafkaTemplate.send(message);
    }
}
