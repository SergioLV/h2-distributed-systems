package com.gremio.receiver.business;

import com.gremio.receiver.model.CartLocation;
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
    private KafkaTemplate<String, CartLocation> cartLocationKafkaTemplate;


    @Transactional
    public void send(Sale sale)  {
        sendToSalesTopic(sale);
        sendToLocationTopic(sale);
    }

    private void sendToSalesTopic(Sale sale){
        try{
            salesKafkaTemplate.send(Constants.KAFKA_SALES_TOPIC, sale.getSaleType(), sale);
            LOGGER.info("New " + sale.getSaleType() + " sale added!. " + sale.getClientName());
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_SALES_TOPIC, e);
        }
    }

    private void sendToLocationTopic(Sale sale){
        try{
            CartLocation cartLocation = new CartLocation(sale.getCartId(), sale.getLatitude(), sale.getLongitude(), "standard");
            cartLocationKafkaTemplate.send(Constants.KAFKA_LOCATION_TOPIC, cartLocation.getIsFugitive(), cartLocation);
            LOGGER.info("New " + cartLocation.getIsFugitive() + "cart!");
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_SALES_TOPIC, e);
        }
    }
}
