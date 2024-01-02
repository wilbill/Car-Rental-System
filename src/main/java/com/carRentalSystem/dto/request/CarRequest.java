package com.carRentalSystem.dto.request;

import lombok.Data;

@Data //means i have getters, setters, constructors (AllArguments n noArguments constructors)
public class CarRequest {
    private Long id;
    private String make;
    private String model;
    private String description;
    private double dailyRentalRate;
    private int maximumOccupancy;

}
