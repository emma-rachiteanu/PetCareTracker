package com.petcare.notification_service.controller;

import com.petcare.notification_service.dto.NotificationRequestDto;
import com.petcare.notification_service.model.Notification;
import com.petcare.notification_service.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notification sendNotification(@Valid @RequestBody NotificationRequestDto dto) {
        return notificationService.createNotification(dto);
    }

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAllNotifications();
    }
}
