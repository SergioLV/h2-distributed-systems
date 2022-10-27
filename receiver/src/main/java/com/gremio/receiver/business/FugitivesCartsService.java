package com.gremio.receiver.business;

import com.gremio.receiver.model.FugitiveCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FugitivesCartsService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(FugitivesCartsService.class);

    @Autowired
    private KafkaTemplate<String, FugitiveCart> fugitiveCartKafkaTemplate;

    @Transactional
    public void send(FugitiveCart fugitiveCart) {
        sendToTopic(fugitiveCart);
    }

    private void sendToTopic(FugitiveCart fugitiveCart){
        try{
            fugitiveCartKafkaTemplate.send(Constants.KAFKA_LOCATION_TOPIC, 1, "fugitive", fugitiveCart);
            LOGGER.info("New fugitive cart!. " + fugitiveCart.getCartId());
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_LOCATION_TOPIC, e);
        }
    }


}
