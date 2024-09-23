package com.sushant.userservice.kafka;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProducerMessage {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson;
    public ProducerMessage() {
        gson = new Gson();
    }

    public boolean sendMessage(String topicName, String key, Object message) {
        CompletableFuture<SendResult<String, String>> publishResp = kafkaTemplate.send(topicName, key, gson.toJson(message));
        try{
            SendResult<String, String> result = publishResp.get();
            System.out.println("Message published on topic " + topicName + " with key " + key + " with result " + result.toString());
            return true;
        } catch (Exception ex) {
            System.out.println("Got exception while publishing message " + ex.getMessage());
            return false;
        }
    }
}
