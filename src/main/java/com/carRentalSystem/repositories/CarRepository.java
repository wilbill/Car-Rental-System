package com.carRentalSystem.repositories;

import com.carRentalSystem.domain.Car;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //its optional, spring understands this too
public interface CarRepository extends JpaRepository<Car, Long> {
}
