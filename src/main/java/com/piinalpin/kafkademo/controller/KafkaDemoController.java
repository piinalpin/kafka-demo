package com.piinalpin.kafkademo.controller;

import com.piinalpin.kafkademo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class KafkaDemoController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping(value = "/")
    public Map<String, String> main() {
        return okMessage("ok");
    }

    @PostMapping(value = "/greeting")
    public Map<String, String> greeting(@RequestBody Map<String, String> request) {
        if (null != request.get("greeting")) {
            kafkaProducerService.send(request.get("greeting"));
        }
        return okMessage("Sending message...");
    }

    private Map<String, String> okMessage(String message) {
        Map<String, String> ret = new HashMap<>();
        ret.put("message", message);
        return ret;
    }

}
