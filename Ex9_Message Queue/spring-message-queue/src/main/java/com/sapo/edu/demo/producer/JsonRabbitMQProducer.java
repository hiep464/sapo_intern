package com.sapo.edu.demo.producer;

import com.sapo.edu.demo.entities.User;
import com.sapo.edu.demo.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JsonRabbitMQProducer {

    InventoryRepository inventoryRepository;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.json_routing.key}")
    private String jsonRoutingKey;

    private  static  final Logger LOGGER = LoggerFactory.getLogger(JsonRabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;

//    public JsonRabbitMQProducer(RabbitTemplate rabbitTemplate){
//        this.rabbitTemplate = rabbitTemplate;
//    }

    public JsonRabbitMQProducer(InventoryRepository inventoryRepository, RabbitTemplate rabbitTemplate) {
        this.inventoryRepository = inventoryRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("Message sent -> %s %s %s",user, exchange, jsonRoutingKey));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, user);
    }

    public List<Object> sendMessage(){
        LOGGER.info(String.format("Message sent -> %s %s %s",inventoryRepository.thongke(), exchange, jsonRoutingKey));
        rabbitTemplate.convertAndSend(exchange, jsonRoutingKey, inventoryRepository.thongke());
        return inventoryRepository.thongke();
    }

}
