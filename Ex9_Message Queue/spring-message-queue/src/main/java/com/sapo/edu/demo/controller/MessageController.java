package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.entities.User;
import com.sapo.edu.demo.producer.JsonKafkaProducer;
import com.sapo.edu.demo.producer.JsonRabbitMQProducer;
import com.sapo.edu.demo.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    private RabbitMQProducer producer;

    private JsonRabbitMQProducer jsonRabbitMQProducer;

    public MessageController(JsonKafkaProducer jsonKafkaProducer, RabbitMQProducer producer, JsonRabbitMQProducer jsonRabbitMQProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
        this.producer = producer;
        this.jsonRabbitMQProducer = jsonRabbitMQProducer;
    }

    @GetMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Sent to rabbitmq ...");
    }

//    @PostMapping("json")
//    public ResponseEntity<?> sendJsonMessage(@RequestBody User user){
//        jsonRabbitMQProducer.sendMessage(user);
//        return ResponseEntity.ok(user);
//    }

    @PostMapping("thongke/rabitmq")
    public ResponseEntity<?> sendJsonMessageRabitmq(){
        return ResponseEntity.ok(jsonRabbitMQProducer.sendMessage());
    }

    @PostMapping("thongke/kafka")
    public ResponseEntity<?> sendJsonMessageKafka(){
        jsonKafkaProducer.sendMessage();
        return ResponseEntity.ok("ok");
    }
}
