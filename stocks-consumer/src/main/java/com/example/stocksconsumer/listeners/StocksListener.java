package com.example.stocksconsumer.listeners;

import com.example.stocksconsumer.business.Constants;
import com.example.stocksconsumer.model.CartStock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StocksListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StocksListener.class);
    private static List<CartStock> cartStockList = new ArrayList<>();

    @KafkaListener(topics = Constants.KAFKA_STOCKS_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
    void listener(String JsonStock) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CartStock cartStock = objectMapper.readValue(JsonStock, CartStock.class);
        if(cartStockList.size() == 5){
            for(CartStock cartStock1: cartStockList){
                LOGGER.info("cartId " + String.valueOf(cartStock1.getCartId()) + " with " + String.valueOf(cartStock1.getRemainingStock()) + " sopaipillas left");
            }
            cartStockList.clear();
        }
        cartStockList.add(cartStock);
    }
}
