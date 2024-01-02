package com.carRentalSystem.repositories;

import com.carRentalSystem.domain.Car;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //its optional, spring understands this too
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.make= :make")
    List<Car> searchCars(String make);

}
