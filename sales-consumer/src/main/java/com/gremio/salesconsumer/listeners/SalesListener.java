package com.gremio.salesconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.salesconsumer.model.Sale;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class SalesListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SalesListener.class);

    @KafkaListener(topics = "sales", groupId = "hello!")
    void listener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sale sale = objectMapper.readValue(JsonSale, Sale.class);

        LOGGER.info("Vamos equipo! " + sale.getClient());
    }
}
