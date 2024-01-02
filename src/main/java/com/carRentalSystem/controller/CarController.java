package com.carRentalSystem.controller;

import com.carRentalSystem.dto.response.CarResponse;
import com.carRentalSystem.repositories.CarRepository;
import com.carRentalSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //its a controller..subtype restController(combination of responsebody + controller )
@RequestMapping("/cars") //defines base url, stackoverflow: maps request url (/cars) to this controller method(s)
public class CarController {

    @Autowired
    private CarService carService; // We use a service interface in the controller //

    //
    @GetMapping
    public ResponseEntity<?> getAllCars(){
        List<CarResponse> carResponseList = carService.findAll();
        return new ResponseEntity<>(carResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id){
        CarResponse carResponse = carService.findById(id);
        return new ResponseEntity<>(carResponse, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchCars(@RequestParam String keyword){
        List<CarResponse> carSearchList = carService.searchedCars(keyword);
        return new ResponseEntity<>(carSearchList, HttpStatus.OK);
    }



}
