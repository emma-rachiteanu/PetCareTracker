package com.petcare.task_service.service;

import com.petcare.task_service.config.RabbitConfig;
import com.petcare.task_service.dto.TaskEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendTaskEvent(Long petId, String message) {
        TaskEventDto event = new TaskEventDto(petId, message);

        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                event
        );
    }
}
