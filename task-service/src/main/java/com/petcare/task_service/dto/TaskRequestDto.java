package com.petcare.task_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskRequestDto {
    @NotNull
    private Long petId;

    @NotBlank
    private String title;

    @NotBlank
    private String type;

    @NotNull
    private LocalDateTime dueAt;
}
