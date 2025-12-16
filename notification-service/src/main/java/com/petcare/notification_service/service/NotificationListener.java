package com.petcare.notification_service.service;

import com.petcare.notification_service.config.RabbitConfig;
import com.petcare.notification_service.model.Notification;
import com.petcare.notification_service.dto.TaskEventDto;
import com.petcare.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final NotificationRepository notificationRepository;

    @RabbitListener(
            queues = RabbitConfig.QUEUE,
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void receiveMessage(TaskEventDto event) {

        Notification notification = Notification.builder()
                .petId(event.getPetId())
                .message(event.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
    }
}
