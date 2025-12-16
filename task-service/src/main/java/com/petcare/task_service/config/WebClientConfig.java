package com.petcare.task_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${pet.service.url}")
    private String petServiceUrl;

    @Bean
    public WebClient petWebClient() {
        return WebClient.builder()
                .baseUrl(petServiceUrl)
                .build();
    }
}
