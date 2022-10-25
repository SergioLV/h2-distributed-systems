package com.gremio.salesconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.salesconsumer.model.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class MemberListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MemberListener.class);

    @KafkaListener(topics = "member", groupId = "hello!")
    void listener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Member member = objectMapper.readValue(JsonSale, Member.class);

        LOGGER.info("Vamos equipo!  nuevo miembro " );
    }
}
