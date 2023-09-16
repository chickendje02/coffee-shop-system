package com.trungnguyen.coffeeshopservice.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class CoffeeShopProducer {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String test){
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test-topic", "key-" + test, "message-" + test);
        kafkaTemplate.send(producerRecord);
    }
}
