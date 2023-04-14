package com.sapo.edu.demo.producer;


import com.sapo.edu.demo.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonKafkaProducer {

    InventoryRepository inventoryRepository;

    @Value("${spring.kafka.topic.name}")
    private String topicJsonName;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, List<?>> kafkaTemplate;

    public JsonKafkaProducer(InventoryRepository inventoryRepository, KafkaTemplate<String, List<?>> kafkaTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(){

        List<?> data = inventoryRepository.thongke();
        LOGGER.info(String.format("Message sent -> %s", data.toString()));

        Message<? extends List<?>> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                .build();

        kafkaTemplate.send(message);
    }
}
