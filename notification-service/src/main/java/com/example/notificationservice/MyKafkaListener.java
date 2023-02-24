package com.example.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MyKafkaListener {

    @KafkaListener(topics = "notificationTopic",groupId = "notificationId")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent){
        log.info("+++Received notification for order - {}",orderPlacedEvent.toString());
    }
}
