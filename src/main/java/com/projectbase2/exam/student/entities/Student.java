package com.projectbase2.exam.student.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(name="email_address", unique = true, nullable = false)
    private String email;

    @Column
    private String gender;

    private LocalDate birthDate;

}
