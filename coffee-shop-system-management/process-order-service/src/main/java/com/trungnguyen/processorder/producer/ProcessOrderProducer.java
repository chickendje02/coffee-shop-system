package com.trungnguyen.processorder.producer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProcessOrderProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Async
    public <T> void sendMessage(T message, String topic){
        try{
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, objectMapper.writeValueAsString(message));
            kafkaTemplate.send(producerRecord);
        } catch (JsonProcessingException e){
            log.debug("Failed to convert object to json string");
        } catch (Exception e){
            log.debug("Failed to send message");
        }
    }
}
