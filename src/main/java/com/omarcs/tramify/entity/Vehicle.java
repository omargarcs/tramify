package com.omarcs.tramify.entity;

import com.omarcs.tramify.entity.enums.CarMake;
import com.omarcs.tramify.entity.enums.VehicleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vin;

    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private CarMake carMake;

    private String model;
    private String subModel;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

}
