package com.gremio.receiver.business;

import com.gremio.receiver.dao.SaleDAO;
import com.gremio.receiver.exceptions.DatabaseException;
import com.gremio.receiver.model.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SalesService {

    @Autowired
    private KafkaTemplate<String, Sale> salesKafkaTemplate;

    @Transactional
    public void send(Sale sale) throws DatabaseException{
        sendToTopic(sale);
    }

    private void sendToTopic(Sale sale){
        try{
            salesKafkaTemplate.send(Constants.KAFKA_SALES_TOPIC, sale);
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_SALES_TOPIC, e);
        }
    }
}
