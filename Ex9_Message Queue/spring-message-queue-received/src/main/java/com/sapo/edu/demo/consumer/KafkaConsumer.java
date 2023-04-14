package com.sapo.edu.demo.consumer;

import com.sapo.edu.demo.entities.Thongke;
import com.sapo.edu.demo.repository.ThongKeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    ThongKeRepository thongKeRepository;

    public KafkaConsumer(ThongKeRepository thongKeRepository) {
        this.thongKeRepository = thongKeRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void consume(List<?> mess){
        LOGGER.info(String.format("Message received -> %s", mess.toString()));
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
