package com.carRentalSystem.controller;

import com.carRentalSystem.dto.request.CreateCarRequest; //used when creating the car controller in post requests
import com.carRentalSystem.dto.response.CarResponse;
import com.carRentalSystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //its a controller..subtype restController(combination of responsebody + controller )
@RequestMapping("/api/v1/cars") //defines base url, stackoverflow: maps request url (/cars) to this controller method(s)
public class CarController {

    @Autowired
    private CarService carService; // We use a service interface in the controller //

    @GetMapping //works fine
    public ResponseEntity<?> getAllCars(){
        List<CarResponse> carResponseList = carService.findAll();
        return new ResponseEntity<>(carResponseList, HttpStatus.OK);
    }
    @GetMapping("/{id}") // needs a pathvariable, id
    public ResponseEntity<?> getCarById(@PathVariable Long id){
        CarResponse carResponse = carService.findById(id);
        return new ResponseEntity<>(carResponse, HttpStatus.OK);
    }
    @GetMapping("/search") //needs requestParam, string keyword..
    public ResponseEntity<?> searchCars(@RequestParam String keyword){
        List<CarResponse> carSearchList = carService.searchedCars(keyword);
        return new ResponseEntity<>(carSearchList, HttpStatus.OK);
    }
    @PostMapping //Creating a new car, u need a requestbody, request-dto-param, create mtd in service
    public ResponseEntity<?>CreateCar(@RequestBody CreateCarRequest carRequest){
        CarResponse carResponse = carService.create(carRequest);
        return new ResponseEntity<>(carResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{carId}") //update a car, we need its id && pathVariable, requestBody..
    //in other words, it's a combination of a post request and a get request where we get a single CarBy id
    public ResponseEntity<?>updateCar(@PathVariable Long carId, @RequestBody CreateCarRequest carRequest){
        CarResponse carResponse = carService.update(carId, carRequest); //mtd needs to be defined in the service interface n implemented in service
        return new ResponseEntity<>(carResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<?>deleteCar(@PathVariable Long carId){
        carService.deleteById(carId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
