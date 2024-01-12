package com.carRentalSystem.repositories;

import com.carRentalSystem.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
