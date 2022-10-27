package gremio.membersconsumer.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import gremio.membersconsumer.business.Constants;
import gremio.membersconsumer.model.Member;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class MemberListener {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MemberListener.class);

    @KafkaListener(topics = Constants.KAFKA_NEW_MEMBERS_TOPIC, groupId = Constants.COUNSUMER_GROUP_ID)
    void listener(String JsonSale) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Member member = objectMapper.readValue(JsonSale, Member.class);
        LOGGER.info("Nuevo miembro! " + member.getMemberName() + " " + member.getMemberLastName());
    }
}
