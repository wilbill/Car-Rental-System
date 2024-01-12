package com.carRentalSystem.controller;

import com.carRentalSystem.dto.response.BookingResponse;
import com.carRentalSystem.service.BookingService;
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
public class BookingController {
    @Autowired //we use service in a controller
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<?>getOrders(){
        List<BookingResponse> ordersList = bookingService.findAll(); //this is the mtd implemented
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getOrderById(@PathVariable Long id){
        BookingResponse order = bookingService.findById(id); //this is the mtd implemented
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
