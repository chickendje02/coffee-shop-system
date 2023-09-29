package com.trungnguyen.coffeeshop.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trungnguyen.coffeeshop.model.OrderCanceledMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class CoffeeShopConsumer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "order-cancel-topic")
    public void listen(String message) throws JsonProcessingException {
        System.out.println("Received Message: " + objectMapper.readValue(message, OrderCanceledMessage.class).toString());
    }

}
