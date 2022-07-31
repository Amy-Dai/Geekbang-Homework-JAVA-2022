package com.example.mq.diy.core.protocol.controller;

import com.example.mq.diy.core.messagequeue.Broker;
import com.example.mq.diy.core.messagequeue.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基于Spring web（HTTP）的API接口
 */
@RestController
public class MQController {

    private final Broker broker;

    public MQController(Broker broker) {
        this.broker = broker;
    }

    @PostMapping("/send")
    public boolean send(@RequestBody Message message) {
        return broker.send(message.getTopic(), message.getContent());
    }

    @GetMapping("/poll")
    public List poll(@RequestParam(value = "topic")String topic,
                     @RequestParam(value = "rate")Integer rate,
                     @RequestParam(value = "group")String group) {
        return broker.poll(topic, group, rate);
    }
}
