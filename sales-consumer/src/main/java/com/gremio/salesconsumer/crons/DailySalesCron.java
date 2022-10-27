package com.gremio.salesconsumer.crons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gremio.salesconsumer.dao.SaleDAO;
import com.gremio.salesconsumer.dao.SaleJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DailySalesCron {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DailySalesCron.class);
    @Autowired
    private SaleJpaRepository saleJpaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Scheduled(cron = "*/10 * * * * *")
    public void getDailySales() throws JsonProcessingException {
        List<Object> dailySales = saleJpaRepository.getDailySales();
        LOGGER.info("=======================");
        LOGGER.info("      DAILY SALES");
        LOGGER.info("=======================");
        for(Object o : dailySales){
            ObjectMapper od = new ObjectMapper();
            String json = od.writeValueAsString(o);
            LOGGER.info("cartId, sales = " + json);
        }
        List<Object> dailyCustomers = saleJpaRepository.getDailyCustomers();
        LOGGER.info("=======================");
        LOGGER.info("      DAILY CUSTOMERS");
        LOGGER.info("=======================");
        for(Object o : dailyCustomers){
            ObjectMapper od = new ObjectMapper();
            String json = od.writeValueAsString(o);
            LOGGER.info("cartId, customers = " + json);
        }
        List<Object> avgAmount = saleJpaRepository.getAvgAmount();
        LOGGER.info("=======================");
        LOGGER.info("    DAILY AVG SALES");
        LOGGER.info("=======================");
        for(Object o : avgAmount){
            ObjectMapper od = new ObjectMapper();
            String json = od.writeValueAsString(o);
            LOGGER.info("cartId, avg = " + json);
        }
    }
}
