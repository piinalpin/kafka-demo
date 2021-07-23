package com.piinalpin.kafkademo.service;

import com.piinalpin.kafkademo.constant.KafkaTopicConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaPublisherService {

    public final static Logger log = LoggerFactory.getLogger(KafkaPublisherService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Sending message to Kafka...");
        log.info(String.format("Payload: %s, Topic: %s", KafkaTopicConstant.HELLO_WORLD, message));
        kafkaTemplate.send(KafkaTopicConstant.HELLO_WORLD, message);
    }

}
