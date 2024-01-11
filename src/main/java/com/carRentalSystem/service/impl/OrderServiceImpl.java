package com.carRentalSystem.service.impl;

import com.carRentalSystem.Exceptions.OrderNotFoundException;
import com.carRentalSystem.domain.Orders;
import com.carRentalSystem.dto.response.OrderResponse;
import com.carRentalSystem.repositories.OrderRepository;
import com.carRentalSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()//convert o/p to stream to apply stream operations
                .map(OrderResponse::from)//converts order obj to orderResponse obj
                .collect(Collectors.toList());
        //map transforms object to a different form, or modifies some property of the object
        //by applying a method to tht object
        //filter is normally for checking  and its normally boolean, map is for transforming by applying methods to the given data
    }

    @Override
    public OrderResponse findById(Long orderId) {
        Orders orders = orderRepository.findById(orderId).orElseThrow(
                ()-> new OrderNotFoundException(String.format("Order with id %s Not Found", orderId))
        );
        return OrderResponse.from(orders);
    }
}
