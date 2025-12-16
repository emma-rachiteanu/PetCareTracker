package com.petcare.task_service.service;

import com.petcare.task_service.dto.TaskRequestDto;
import com.petcare.task_service.dto.TaskResponseDto;
import com.petcare.task_service.exception.ResourceNotFoundException;
import com.petcare.task_service.model.CareTask;
import com.petcare.task_service.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final PetClient petClient;

    // 👇 NEW
    private final TaskEventPublisher taskEventPublisher;

    public TaskResponseDto createTask(TaskRequestDto dto) {

        if (!petClient.petExists(dto.getPetId())) {
            throw new ResourceNotFoundException("Pet not found for ID = " + dto.getPetId());
        }

        CareTask task = CareTask.builder()
                .petId(dto.getPetId())
                .title(dto.getTitle())
                .type(dto.getType())
                .dueAt(dto.getDueAt())
                .completed(false)
                .build();

        CareTask savedTask = taskRepository.save(task);

        // publish event
        taskEventPublisher.sendTaskEvent(
                savedTask.getPetId(),
                "Task created for pet " + savedTask.getPetId()
        );

        return toResponse(savedTask);
    }

    public List<TaskResponseDto> getTasksForPet(Long petId) {
        return taskRepository.findByPetId(petId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public TaskResponseDto markCompleted(Long id) {
        CareTask task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        task.setCompleted(true);
        CareTask updatedTask = taskRepository.save(task);

        // 👇 NEW — publish event
        taskEventPublisher.sendTaskEvent(
                updatedTask.getPetId(),
                "Task completed for pet " + updatedTask.getPetId()
        );

        return toResponse(updatedTask);
    }

    private TaskResponseDto toResponse(CareTask task) {
        return TaskResponseDto.builder()
                .id(task.getId())
                .petId(task.getPetId())
                .title(task.getTitle())
                .type(task.getType())
                .dueAt(task.getDueAt())
                .completed(task.isCompleted())
                .build();
    }
}
