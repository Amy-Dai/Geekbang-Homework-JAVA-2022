package com.example.mq.diy.core.protocol.websocket;

import com.example.mq.diy.core.common.Constants;
import com.example.mq.diy.core.messagequeue.Broker;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.springframework.web.socket.*;

import java.util.Map;

public class ProducerHandler implements WebSocketHandler {

    private final Broker broker;
    private Gson gson = new Gson();

    ProducerHandler(Broker broker) {
        this.broker = broker;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
    }

    @SneakyThrows
    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) {
        String topic = Constants.TOPIC;
        String message = Constants.MESSAGE;

        Map map = gson.fromJson(webSocketMessage.getPayload().toString(), Map.class);
        if (broker.send(map.get(topic).toString(), map.get(message).toString())) {
            webSocketSession.sendMessage(new TextMessage(map.get(Constants.SEND_ID).toString()));
        } else {
            webSocketSession.sendMessage(new TextMessage("null"));
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) {
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
