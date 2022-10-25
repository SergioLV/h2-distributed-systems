package com.gremio.receiver.business;

import com.gremio.receiver.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembersService {

    @Autowired
    private KafkaTemplate<String, Member>  memberKafkaTemplate;

    @Transactional
    public void send(Member member) {
        sendToTopic(member);
    }

    private void sendToTopic(Member member) {
        try{
            memberKafkaTemplate.send(Constants.KAFKA_NEW_MEMBERS_TOPIC, member);
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_NEW_MEMBERS_TOPIC, e);
        }
    }
}
