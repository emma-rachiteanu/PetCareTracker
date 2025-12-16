package com.petcare.task_service.repository;

import com.petcare.task_service.model.CareTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<CareTask, Long> {
    List<CareTask> findByPetId(Long petId);
}
