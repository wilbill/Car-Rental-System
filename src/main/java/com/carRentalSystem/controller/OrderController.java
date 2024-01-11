package com.carRentalSystem.controller;

import com.carRentalSystem.domain.Orders;
import com.carRentalSystem.dto.response.OrderResponse;
import com.carRentalSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired //we use service in a controller
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?>getOrders(){
        List<OrderResponse> ordersList = orderService.findAll(); //this is the mtd implemented
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getOrderById(@PathVariable Long id){
        OrderResponse order = orderService.findById(id); //this is the mtd implemented
        return new ResponseEntity<>(order, HttpStatus.OK);

    }
}
