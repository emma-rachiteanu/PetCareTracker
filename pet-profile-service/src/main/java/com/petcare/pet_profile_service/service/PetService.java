package com.petcare.pet_profile_service.service;

import com.petcare.pet_profile_service.dto.PetRequestDto;
import com.petcare.pet_profile_service.dto.PetResponseDto;
import com.petcare.pet_profile_service.exception.ResourceNotFoundException;
import com.petcare.pet_profile_service.model.Pet;
import com.petcare.pet_profile_service.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {

    private final PetRepository petRepository;

    public PetResponseDto createPet(PetRequestDto dto) {
        Pet pet = Pet.builder()
                .name(dto.getName())
                .species(dto.getSpecies())
                .breed(dto.getBreed())
                .age(dto.getAge())
                .feedingSchedule(dto.getFeedingSchedule())
                .medicalNotes(dto.getMedicalNotes())
                .build();

        Pet saved = petRepository.save(pet);
        return toResponse(saved);
    }

    public List<PetResponseDto> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PetResponseDto getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet with id " + id + " not found"));
        return toResponse(pet);
    }

    public PetResponseDto updatePet(Long id, PetRequestDto dto) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet with id " + id + " not found"));

        pet.setName(dto.getName());
        pet.setSpecies(dto.getSpecies());
        pet.setBreed(dto.getBreed());
        pet.setAge(dto.getAge());
        pet.setFeedingSchedule(dto.getFeedingSchedule());
        pet.setMedicalNotes(dto.getMedicalNotes());

        Pet updated = petRepository.save(pet);
        return toResponse(updated);
    }

    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pet with id " + id + " not found");
        }
        petRepository.deleteById(id);
    }

    private PetResponseDto toResponse(Pet pet) {
        return PetResponseDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .age(pet.getAge())
                .feedingSchedule(pet.getFeedingSchedule())
                .medicalNotes(pet.getMedicalNotes())
                .build();
    }
}
