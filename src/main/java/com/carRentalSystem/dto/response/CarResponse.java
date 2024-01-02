package com.carRentalSystem.dto.response;
//Exact mirror of the car Domain, but has a static mtd

import com.carRentalSystem.Exceptions.CarNotFoundException;
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

    //static factory method from of return type carResponse to create a dto response-obj from Car class parameter
    public static CarResponse from(Car car){
        if(car == null){
            throw new CarNotFoundException("Car Not found Exception"); //custom exception
        }
        //We have an obj of type CarResponse, we set its values here from getters of the car
        CarResponse response = new CarResponse();
        response.id  = car.getId();
        response.make = car.getMake();
        response.model = car.getMake();
        response.dailyRentalRate = car.getDailyRentalRate();
        response.description = car.getDescription();
        response.maximumOccupancy = car.getMaximumOccupancy();
        return response;
    }
}
