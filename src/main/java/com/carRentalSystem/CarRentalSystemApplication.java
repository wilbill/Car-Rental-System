package com.carRentalSystem;

import com.carRentalSystem.domain.Car;
import com.carRentalSystem.domain.CarType;
import com.carRentalSystem.domain.Orders;
import com.carRentalSystem.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CarRentalSystemApplication implements CommandLineRunner {

	@Autowired
	private CarRepository carRepository;
	public static void main(String[] args) {
		SpringApplication.run(CarRentalSystemApplication.class, args);
	}
	public void run(String... args) throws Exception{
		//this is a cars thing ie product
		List<Car> cars = Arrays.asList(
				new Car("Toyota", "Camry", "A comfortable and reliable sedan", 50.0, 5, CarType.SEDAN ) ,
				new Car("Honda", "CR-V", "A versatile SUV for family trips", 65.0, 7, CarType.SUV),
				new Car("Ford", "Mustang", "A stylish convertible for a thrilling ride", 80.0, 2, CarType.CONVERTIBLE)
		);
	carRepository.saveAll(cars);

		//this is for orders
		List<Orders>orders = Arrays.asList(
				new Orders(),
				new Orders(),
				new Orders()
		);


	}

}
