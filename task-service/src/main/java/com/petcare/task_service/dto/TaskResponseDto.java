package com.petcare.task_service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponseDto {

    private Long id;
    private Long petId;
    private String title;
    private String type;
    private LocalDateTime dueAt;
    private boolean completed;
}
