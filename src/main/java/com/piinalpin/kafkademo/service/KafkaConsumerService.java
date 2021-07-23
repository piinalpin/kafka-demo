package com.piinalpin.kafkademo.service;

import com.piinalpin.kafkademo.constant.KafkaTopicConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final static Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = KafkaTopicConstant.HELLO_WORLD)
    public void greeting(String payload) {
        log.info(String.format("Received payload: %s", payload));
    }

}
