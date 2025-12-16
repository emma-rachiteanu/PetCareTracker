package com.petcare.pet_profile_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String species; // dog, cat, etc.

    private String breed;

    @NotNull
    private Integer age; // in years

    private String feedingSchedule; // e.g. "Twice a day"
    private String medicalNotes;    // general health info
}
