package com.gremio.salesconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gremio.salesconsumer.business.Constants;
import com.gremio.salesconsumer.business.SalesService;
import com.gremio.salesconsumer.business.StockService;
import com.gremio.salesconsumer.exceptions.DatabaseException;
import com.gremio.salesconsumer.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class SalesListener {
    @Autowired
    private SalesService salesService;


    @KafkaListener(topics = Constants.KAFKA_SALES_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
    void firstListener(String JsonSale) throws JsonProcessingException, DatabaseException {
        ObjectMapper objectMapper = new ObjectMapper();
        Sale sale = objectMapper.readValue(JsonSale, Sale.class);
        salesService.save(sale);
    }

//    @KafkaListener(topics = Constants.KAFKA_SALES_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
//    void secondListener(String JsonSale) throws JsonProcessingException, DatabaseException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Sale sale = objectMapper.readValue(JsonSale, Sale.class);
//        salesService.save(sale);
//    }
}
