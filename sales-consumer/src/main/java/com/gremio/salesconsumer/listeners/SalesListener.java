package com.gremio.salesconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.salesconsumer.business.Constants;
import com.gremio.salesconsumer.business.SalesService;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

@Configuration
public class SalesListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesListener.class);
    @Autowired
    private SalesService salesService;

    @KafkaListener(groupId = Constants.COUNSUMER_GROUP_ID,  topicPartitions = @TopicPartition(topic = Constants.KAFKA_SALES_TOPIC, partitions = {"1"}))
    void firstListener(String JsonSale) throws JsonProcessingException, DatabaseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sale sale = objectMapper.readValue(JsonSale, Sale.class);
        LOGGER.info("Partition 1, " + sale.getSaleType());
        salesService.save(sale);
    }

    @KafkaListener(groupId = Constants.COUNSUMER_GROUP_ID,  topicPartitions = @TopicPartition(topic = Constants.KAFKA_SALES_TOPIC, partitions = {"0"}))
    void secondListener(String JsonSale) throws JsonProcessingException, DatabaseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sale sale = objectMapper.readValue(JsonSale, Sale.class);
        LOGGER.info("Partition 0, " + sale.getSaleType());
        salesService.save(sale);
    }
}
