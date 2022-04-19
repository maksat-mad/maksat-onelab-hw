package com.onelab.task4.kafka;

import com.onelab.task4.entities.UserRequestTime;
import com.onelab.task4.repository.UserRequestTimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class KafkaProducers {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducers.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final UserRequestTimeRepository userRequestTimeRepository;

    @Autowired
    public KafkaProducers(KafkaTemplate<String, String> kafkaTemplate,
                          UserRequestTimeRepository userRequestTimeRepository) {
        this.kafkaTemplate = kafkaTemplate;
        this.userRequestTimeRepository = userRequestTimeRepository;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send("onelab", msg);
        logger.info("Producer send: " + msg);
    }

    public void sendTime(LocalDateTime now) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        kafkaTemplate.send("onelab", dtf.format(now));
        logger.info("Producer send: " + dtf.format(now));
        try {
            UserRequestTime userRequestTime = new UserRequestTime();
            userRequestTime.setTime(Date.valueOf(now.toLocalDate()));
            userRequestTimeRepository.save(userRequestTime);
            logger.info("SUCCESSFULLY saved user request time");
        } catch (Exception ex) {
            logger.error("ERROR could not save user request time", ex);
        }
    }
}
