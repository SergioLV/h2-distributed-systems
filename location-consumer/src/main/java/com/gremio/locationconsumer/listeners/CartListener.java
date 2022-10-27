package com.gremio.locationconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.locationconsumer.business.Constants;
import com.gremio.locationconsumer.model.CartLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

@Configuration
public class CartListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CartListener.class);

    @KafkaListener(groupId = Constants.COUNSUMER_GROUP_ID,  topicPartitions = @TopicPartition(topic = Constants.KAFKA_LOCATION_TOPIC, partitions = {"0"}))
    void firstListener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CartLocation cartLocation = objectMapper.readValue(JsonSale, CartLocation.class);
        LOGGER.info("Location of cartId " + cartLocation.getCartId() + " updated. " + cartLocation.getLatitude() + " " + cartLocation.getLongitude());
    }

    @KafkaListener(groupId = Constants.COUNSUMER_GROUP_ID,  topicPartitions = @TopicPartition(topic = Constants.KAFKA_LOCATION_TOPIC, partitions = {"1"}))
    void secondListener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CartLocation cartLocation = objectMapper.readValue(JsonSale, CartLocation.class);
        LOGGER.info("Cart id " + cartLocation.getCartId() + " is fugitive!");
    }
}
