package com.example.mq.kafka.single;


import com.example.mq.kafka.single.data.ConsumerImpl;

public class KafkaConsumerDemo {

    public static void main(String[] args) {
        testConsumer();
    }

    private static void testConsumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        consumer.consumeOrder();

    }
}
