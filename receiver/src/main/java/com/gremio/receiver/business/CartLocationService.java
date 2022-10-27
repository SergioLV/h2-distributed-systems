package com.gremio.receiver.business;

import com.gremio.receiver.model.CartLocation;
import com.gremio.receiver.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartLocationService {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MembersService.class);
    @Autowired
    private KafkaTemplate<String, CartLocation> cartLocationKafkaTemplate;

    @Transactional
    public void send(CartLocation cartLocation) {
        sendToTopic(cartLocation);
    }

    private void sendToTopic(CartLocation cartLocation) {
        try{
            cartLocationKafkaTemplate.send(Constants.KAFKA_LOCATION_TOPIC, 0, "standard", cartLocation);
            LOGGER.info("New Standard cart location updated! " + cartLocation.getCartId() + " " + cartLocation.getLatitude() + " " + cartLocation.getLongitude());
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_LOCATION_TOPIC, e);
        }
    }
}
