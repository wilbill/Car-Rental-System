package com.carRentalSystem.controller;

import com.carRentalSystem.dto.request.CreateBookingRequest;
import com.carRentalSystem.dto.response.BookingResponse;
import com.carRentalSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired //we use service in a controller
    private BookingService bookingService;
    @GetMapping
    public ResponseEntity<?>getBookings(){
        List<BookingResponse> bookingList = bookingService.findAll(); //this is the mtd implemented
        return new ResponseEntity<>(bookingList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getBookingById(@PathVariable Long id){
        BookingResponse booking = bookingService.findById(id); //this is the mtd implemented
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>CreateBooking(@RequestBody CreateBookingRequest bookingRequest){
        BookingResponse bookingResponse = bookingService.create(bookingRequest);
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }
    @PutMapping("/{bookingId}")
    public ResponseEntity<?>updateBooking(@PathVariable Long bookingId, @RequestBody CreateBookingRequest bookingRequest){
        BookingResponse bookingResponse = bookingService.updateBooking(bookingId, bookingRequest);
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<?>cancelBooking(@PathVariable Long bookingId){
        try {
            bookingService.deleteById(bookingId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>("Booking with ID " + bookingId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
