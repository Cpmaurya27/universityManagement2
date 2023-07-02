package com.example.universityManagment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    @NotBlank

    private String firstName;

    @NotBlank

    private String lastName;


    private int age;

//    @Enumerated(EnumType.STRING)
    private Department department;

}
