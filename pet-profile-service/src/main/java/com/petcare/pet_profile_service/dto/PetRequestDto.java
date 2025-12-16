package com.petcare.pet_profile_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String species;

    private String breed;

    @NotNull
    private Integer age;

    private String feedingSchedule;

    private String medicalNotes;
}
