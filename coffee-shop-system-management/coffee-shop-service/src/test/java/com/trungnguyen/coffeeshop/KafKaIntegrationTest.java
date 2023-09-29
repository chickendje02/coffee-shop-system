package com.trungnguyen.coffeeshop;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trungnguyen.coffeeshop.configuration.DatabaseTestConfiguration;
import com.trungnguyen.coffeeshop.model.OrderCanceledMessage;
import com.trungnguyen.coffeeshop.producer.CoffeeShopProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest
@Testcontainers
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
        "spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}",
        "spring.liquibase.enabled=false"})
@ContextConfiguration(classes = {DatabaseTestConfiguration.class})
public class KafKaIntegrationTest {

    @Autowired
    private CoffeeShopProducer producer;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testExample() throws Exception {
        OrderCanceledMessage messageOrder = new OrderCanceledMessage();
        messageOrder.setCoffeeShopId(1);
        messageOrder.setCustomerId(1);
        producer.send("order-cancel-topic", objectMapper.writeValueAsString(messageOrder));
        Thread.sleep(10000);
        System.out.println("Ok");
//        // Create a consumer
//        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testGroup", "true", embeddedKafka);
//        DefaultKafkaConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<>(consumerProps);
//        Consumer<String, String> consumer = cf.createConsumer();
//        consumer.subscribe(Collections.singleton(topic));

//        ConsumerRecord<String, String> received = KafkaTestUtils.getSingleRecord(consumer, topic);
//        assertThat(received).isNotNull();
//        assertThat(received.value()).isEqualTo(message);
    }
}
