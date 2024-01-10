package com.carRentalSystem.service;

import com.carRentalSystem.dto.request.CreateCarRequest;
import com.carRentalSystem.dto.response.CarResponse;

import java.util.List;

public interface CarService {
    CarResponse create(CreateCarRequest request); //to be used by controller, but implemented in service, abstract mtd in service interface
    List<CarResponse> findAll(); //get a list of all cars in the controller
    CarResponse findById(Long carId); //get a single car method in controller
    List<CarResponse>searchedCars(String keyword);
    CarResponse update(Long id, CreateCarRequest request);
    void deleteById(Long carId);
}
