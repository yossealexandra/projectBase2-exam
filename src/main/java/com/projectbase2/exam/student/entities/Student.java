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

    @Column
    private Long passport;

    @Column(name="email_address", unique = true, nullable = false)
    private String email;

    @Column
    private String gender;

    private LocalDate birthDate;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String nationality;

    @Column(name="marital_status")
    private String maritalStatus;


}
