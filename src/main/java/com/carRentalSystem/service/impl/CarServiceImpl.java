package com.carRentalSystem.service.impl;

import com.carRentalSystem.Exceptions.CarNotFoundException;
import com.carRentalSystem.domain.Car;
import com.carRentalSystem.dto.request.CreateCarRequest;
import com.carRentalSystem.dto.response.CarResponse;
import com.carRentalSystem.repositories.CarRepository;
import com.carRentalSystem.service.CarService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;
    @Override
    public CarResponse create(CreateCarRequest request){
        Car car = new Car();
        //id isnt supposed to be set
        car.setMake(request.getMake());
        car.setModel(request.getModel());
        car.setDescription(request.getDescription());
        car.setMaximumOccupancy(request.getMaximumOccupancy());
        car.setDailyRentalRate(request.getDailyRentalRate());
        car = carRepository.save(car); //gow is this true

//I can use this instead of above but code would be
//        CarResponse response = new CarResponse();
//        response.setId(car.getId());
//        response.setMake(car.getMake());
//        response.setModel(car.getMake());
//        response.setDailyRentalRate( car.getDailyRentalRate());
//        response.setDescription(car.getDescription());
//        response.setMaximumOccupancy( car.getMaximumOccupancy());
//        return response;


      return CarResponse.from(car);

    }
    @Override
    public List<CarResponse> findAll(){
        return carRepository.findAll()
                .stream()
                .map(CarResponse::from)
                .toList();
    }
//    fIND CAR BY ID
//    the return type is always CarResponse

    @Override
    public CarResponse findById(Long carId){
        Car car = carRepository.findById(carId).orElseThrow(
                ()-> new CarNotFoundException(String.format("Car with id %s not found", carId)));
        //return carRepository.findById(carId);
        return CarResponse.from(car);

    }
    @Override
    public List<CarResponse>searchedCars(String make){ //this can be a keyword
        List<Car>carList = carRepository.searchCars(make); //this is the keyword
        return carList.stream()
                .map(CarResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public CarResponse update(Long carId, CreateCarRequest request){
        Optional<Car> optionalCar = carRepository.findById(carId);
        if(optionalCar.isPresent()){
            Car car = optionalCar.get();

            //update the product properties
            car.setMake(request.getMake());
            car.setModel(request.getModel());
            car.setDescription(request.getDescription());
            car.setMaximumOccupancy(request.getMaximumOccupancy());
            car.setDailyRentalRate(request.getDailyRentalRate());
            carRepository.save(car); //gow is this true
            return CarResponse.from(car);
        }
        else{
            //throw new EntityNotFoundException("Car not found");  //in-built exception
            throw new CarNotFoundException(String.format("Car id %s not found", carId)); //custom error
        }
    }

    @Override
    public void deleteById(Long carId){
        Car car = carRepository.findById(carId).orElseThrow(
                ()-> new CarNotFoundException(String.format("Cant delete, car with id %s not found", carId))
        );
        carRepository.delete(car);
    }
}
