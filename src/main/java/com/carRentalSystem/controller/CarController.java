package com.carRentalSystem.controller;

import com.carRentalSystem.dto.response.CarResponse;
import com.carRentalSystem.repositories.CarRepository;
import com.carRentalSystem.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //its a controller..subtype restController(combination of response body+ controller)
@RequestMapping("/cars") //defines base url, maps requests to controller methods
public class CarController {


    GetMapping
    public ResponseEntity<?> getAllCars(){
        List<CarResponse> carResponseList = CarService.findAll();
        return new ResponseEntity(HttpStatus.OK);
    }


}
