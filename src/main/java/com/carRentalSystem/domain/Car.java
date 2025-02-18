package com.carRentalSystem.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String description;
    private double dailyRentalRate;
    private int maximumOccupancy;

    @Enumerated(EnumType.STRING)
    private CarType type;

    //my constructor lacks an id since id will be gotten somewhere else from the db automatically
    public Car(String make, String model, String description, double dailyRentalRate, int maximumOccupancy, CarType type) {
        this.make = make;
        this.model = model;
        this.description = description;
        this.dailyRentalRate = dailyRentalRate;
        this.maximumOccupancy = maximumOccupancy;
        this.type = type;
    }


}
