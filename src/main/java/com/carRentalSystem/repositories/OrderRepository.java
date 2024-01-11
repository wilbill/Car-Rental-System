package com.carRentalSystem.repositories;

import com.carRentalSystem.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {
}
