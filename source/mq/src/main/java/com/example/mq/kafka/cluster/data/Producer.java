package com.example.mq.kafka.cluster.data;

import com.example.mq.kafka.cluster.Order;

public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}
