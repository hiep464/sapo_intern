package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.model.User;
import com.sapo.edu.demo.producer.JsonRabbitMQProducer;
import com.sapo.edu.demo.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;

    private JsonRabbitMQProducer jsonRabbitMQProducer;

    public MessageController(RabbitMQProducer producer, JsonRabbitMQProducer jsonRabbitMQProducer){
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

    @PostMapping("thongke")
    public ResponseEntity<?> sendJsonMessage(){
        return ResponseEntity.ok(jsonRabbitMQProducer.sendMessage());
    }
}
