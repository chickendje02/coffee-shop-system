package com.trungnguyen.coffeeshop.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class CoffeeShopProducer {


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

}
