package com.onelab.task.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "onelab",
            groupId = "groupId"
    )
    public void listener(String data) {
        logger.info("Consumer received: " + data + " :)");
    }
}
