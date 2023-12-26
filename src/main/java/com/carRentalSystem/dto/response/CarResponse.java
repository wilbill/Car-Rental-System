package com.carRentalSystem.dto.response;
//Exact mirror of the car Domain, but has a static mtd

import com.carRentalSystem.Exceptions.ProductNotFoundException;
import com.carRentalSystem.domain.Car;
import lombok.Data;

@Data
public class CarResponse { //the DTO will be used to make operations, not our domain or output from db directly.
    private Long id;
    private String make;
    private String model;
    private String description;
    private double dailyRentalRate;
    private int maximumOccupancy;

    //static method of return type carResponse to create a dto response-obj from Car class parameter
    public static CarResponse from(Car car){
        if(car ==null){
            throw new ProductNotFoundException("Car Not found Exception"); //custom exception
        }
        CarResponse response = new CarResponse(); //an obj of type CarResponse, we set its values here from getters
        response.id  = response.getId();
        response.make = response.getMake();
        response.model = response.getMake();
        response.dailyRentalRate = response.getDailyRentalRate();
        response.description = response.getDescription();
        response.maximumOccupancy = response.getMaximumOccupancy();
        return response;
    }
}
