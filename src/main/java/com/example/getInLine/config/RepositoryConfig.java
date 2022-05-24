package com.example.getInLine.config;

import com.example.getInLine.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public EventRepository eventRepository() {
        return new EventRepository() {
        };
    }
}
