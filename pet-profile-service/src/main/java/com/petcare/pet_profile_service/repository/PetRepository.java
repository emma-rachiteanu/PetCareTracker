package com.petcare.pet_profile_service.repository;

import com.petcare.pet_profile_service.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
