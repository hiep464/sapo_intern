package com.sapo.edu.demo.consumer;

import com.sapo.edu.demo.entities.Thongke;
import com.sapo.edu.demo.repository.ThongKeRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonRabbitMQConsumer {

    ThongKeRepository thongKeRepository;

    public JsonRabbitMQConsumer(ThongKeRepository thongKeRepository) {
        this.thongKeRepository = thongKeRepository;
    }

    @RabbitListener(queues = {"${rabbitmq.json_queue.name}"})
    public void Consumer(List<Object> mess){
        for(int i = 0; i < mess.size(); i++){
            ArrayList arrayList = (ArrayList) mess.get(i);
            Thongke thongke = new Thongke();
            thongke.setId((Integer) arrayList.get(0));
            thongke.setInventoryCode((String) arrayList.get(1));
            thongke.setNumberOfProducts((Integer) arrayList.get(2));
            thongke.setCreatedAt(LocalDateTime.now());
            thongKeRepository.save(thongke);
        }
    }
}
