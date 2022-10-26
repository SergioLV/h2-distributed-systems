package com.gremio.locationconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.locationconsumer.business.Constants;
import com.gremio.locationconsumer.model.CartLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class CartListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CartListener.class);

    @KafkaListener(topics = Constants.KAFKA_LOCATION_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
    void firstListener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CartLocation cartLocation = objectMapper.readValue(JsonSale, CartLocation.class);
        LOGGER.info("New " + cartLocation.getIsFugitive() +" cart! Cart " + cartLocation.getCartId() + " is missing. "+ cartLocation.getLatitude() + " " + cartLocation.getLongitude() );
    }

    @KafkaListener(topics = Constants.KAFKA_LOCATION_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
    void secondListener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CartLocation cartLocation = objectMapper.readValue(JsonSale, CartLocation.class);
        LOGGER.info("New " + cartLocation.getIsFugitive() +" cart! Cart " + cartLocation.getCartId() + " is missing. "+ cartLocation.getLatitude() + " " + cartLocation.getLongitude() );
    }
}
