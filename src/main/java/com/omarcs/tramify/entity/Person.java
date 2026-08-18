package com.omarcs.tramify.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String curp;

    @Column(unique = true, nullable = true)
    private String rfc;

    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "person")
    private List<PersonalDocument> personalDocuments;

    @OneToMany(mappedBy = "person")
    private List<Vehicle> vehicles;
}
