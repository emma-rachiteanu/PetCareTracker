package com.petcare.notification_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationRequestDto {

    @NotNull
    private Long petId;

    @NotBlank
    private String message;
}
