package com.example.demo.spring.config;

import com.example.demo.spring.BraveKnight;
import com.example.demo.spring.IKnight;
import com.example.demo.spring.IQuest;
import com.example.demo.spring.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {

    @Bean
    public IKnight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public IQuest quest() {
        return new SlayDragonQuest(System.out);
    }
}
