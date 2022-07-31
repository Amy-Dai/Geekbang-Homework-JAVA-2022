package com.example.mq.kafka.single.data;

import com.example.mq.kafka.single.Order;

public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}
