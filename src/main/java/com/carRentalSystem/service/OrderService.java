package com.carRentalSystem.service;

import com.carRentalSystem.domain.Orders;
import com.carRentalSystem.dto.response.OrderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService  {
    List<OrderResponse> findAll();

    OrderResponse findById(Long orderId);
}
