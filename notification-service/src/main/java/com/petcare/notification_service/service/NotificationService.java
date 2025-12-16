package com.petcare.notification_service.service;

import com.petcare.notification_service.dto.NotificationRequestDto;
import com.petcare.notification_service.model.Notification;
import com.petcare.notification_service.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public Notification createNotification(NotificationRequestDto dto) {
        Notification notif = Notification.builder()
                .petId(dto.getPetId())
                .message(dto.getMessage())
                .timestamp(LocalDateTime.now())
                .build();

        return repository.save(notif);
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }
}
