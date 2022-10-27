package com.gremio.receiver.business;

import com.gremio.receiver.model.CartLocation;
import com.gremio.receiver.model.CartStock;
import com.gremio.receiver.model.FugitiveCart;
import com.gremio.receiver.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SalesService.class);
    @Autowired
    private KafkaTemplate<String, Sale> salesKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, CartStock> cartStockKafkaTemplate;


    @Transactional
    public void send(Sale sale)  {
        sendToSalesTopic(sale);
        sendToStockTopic(sale);
    }

    private void sendToSalesTopic(Sale sale){
        try{
            int partition = sale.getSaleType().equals("credit") ? 0 : 1;
            salesKafkaTemplate.send(Constants.KAFKA_SALES_TOPIC, partition, sale.getSaleType(), sale);
            LOGGER.info("New " + sale.getSaleType() + " sale added!. " + sale.getClientName());
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_SALES_TOPIC, e);
        }
    }

    private void sendToStockTopic(Sale sale){
        try{
            CartStock cartStock = new CartStock(sale.getCartId(), sale.getRemainingStock());
            cartStockKafkaTemplate.send(Constants.KAFKA_STOCKS_TOPIC, cartStock);
            LOGGER.info("Stock of cart " + String.valueOf(cartStock.getCartId()) + " updated. Remaining: " + String.valueOf(cartStock.getRemainingStock()) );
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_SALES_TOPIC, e);
        }
    }
}
