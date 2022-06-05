package com.example.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("resources/configurations/knights.xml");
        IKnight knight = context.getBean(IKnight.class);
        knight.embarkOnQuest();
        context.close();
    }
}
