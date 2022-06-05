package com.example.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knights.xml");
        IKnight knight = context.getBean(IKnight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
