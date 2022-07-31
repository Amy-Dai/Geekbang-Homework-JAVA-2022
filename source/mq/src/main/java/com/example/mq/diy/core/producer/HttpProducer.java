package com.example.mq.diy.core.producer;

import com.example.mq.diy.core.common.Constants;
import com.example.mq.diy.core.messagequeue.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
public class HttpProducer implements Producer {

    private final RestTemplate restTemplate = new RestTemplate();

    private Map<String, Object> properties;

    public HttpProducer(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public boolean send(String topic, String message) {
        String url = properties.get(Constants.URL).toString();
        String brokerUrl = url + "/send";
        HttpEntity<Message> request = new HttpEntity<>(new Message(topic, message));
        ResponseEntity<Boolean> response = restTemplate.postForEntity(brokerUrl, request, Boolean.class);
        if (response.getBody() == null) {
            return false;
        }
        return response.getBody();
    }
}
