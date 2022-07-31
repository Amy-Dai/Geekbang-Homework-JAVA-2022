package com.example.mq.diy.core.messagequeue;

import lombok.Data;

@Data
public class Message {

    private String topic;

    private String content;

    public Message(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }
}
