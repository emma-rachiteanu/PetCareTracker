package com.petcare.task_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
public class PetClient {

    private final WebClient petWebClient;

    public boolean petExists(Long petId) {
        try {
            petWebClient.get()
                    .uri("/pets/" + petId)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
