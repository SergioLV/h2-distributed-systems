package com.gremio.salesconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.salesconsumer.model.Fugitive;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
@Configuration
public class FugitiveListener {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(FugitiveListener.class);

    @KafkaListener(topics = "fugitive", groupId = "hello!")
    void listener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Fugitive fugitive = objectMapper.readValue(JsonSale, Fugitive.class);

        LOGGER.info("Vamos equipo! ");
    }
}
