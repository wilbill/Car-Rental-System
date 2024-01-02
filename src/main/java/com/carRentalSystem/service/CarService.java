package com.carRentalSystem.service;

import com.carRentalSystem.dto.request.CarRequest;
import com.carRentalSystem.dto.response.CarResponse;

import java.util.List;

public interface CarService {
    CarResponse create(CarRequest request);
    List<CarResponse> findAll(); //

    CarResponse findById(Long carId); //finding a car by id

    List<CarResponse>searchedCars(String keyword);
}
