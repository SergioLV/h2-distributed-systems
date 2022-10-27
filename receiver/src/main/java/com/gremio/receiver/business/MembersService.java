package com.gremio.receiver.business;

import com.gremio.receiver.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MembersService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MembersService.class);
    @Autowired
    private KafkaTemplate<String, Member>  memberKafkaTemplate;

    @Transactional
    public void send(Member member) {
        sendToTopic(member);
    }

    private void sendToTopic(Member member) {
        try{
            int partition = member.getMemberType().equals("premium") ? 0 : 1;
            memberKafkaTemplate.send(Constants.KAFKA_NEW_MEMBERS_TOPIC, partition, member.getMemberType(), member);
            LOGGER.info("New " + member.getMemberType()  + " member added!. " + member.getEmail());
        } catch(Exception e){
            throw new KafkaException(Constants.PROBLEM_NEW_MEMBERS_TOPIC, e);
        }
    }
}
