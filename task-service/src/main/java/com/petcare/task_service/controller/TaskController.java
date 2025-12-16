package com.petcare.task_service.controller;

import com.petcare.task_service.dto.TaskRequestDto;
import com.petcare.task_service.dto.TaskResponseDto;
import com.petcare.task_service.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDto createTask(@Valid @RequestBody TaskRequestDto dto) {
        return taskService.createTask(dto);
    }

    @GetMapping("/pet/{petId}")
    public List<TaskResponseDto> getTasks(@PathVariable Long petId) {
        return taskService.getTasksForPet(petId);
    }

    @PutMapping("/{id}/complete")
    public TaskResponseDto completeTask(@PathVariable Long id) {
        return taskService.markCompleted(id);
    }
}
