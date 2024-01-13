package com.carRentalSystem.controller;

import com.carRentalSystem.dto.request.CreateBookingRequest;
import com.carRentalSystem.dto.response.BookingResponse;
import com.carRentalSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@PreAuthorize("hasRole('CUSTOMER')")
public class CustomerController {

    @Autowired
    private BookingService bookingService;

    // ... other customer-specific endpoints

    @PostMapping("/make-booking")
    public ResponseEntity<String> makeBooking(@RequestBody CreateBookingRequest bookingRequest) {
        BookingResponse bookingResponse = bookingService.create(bookingRequest);
        return ResponseEntity.ok("Booking created successfully. Booking ID: " + bookingResponse.getId());
    }

    @GetMapping("/booking-history")
    public ResponseEntity<List<BookingResponse>> viewBookingHistory() {
        List<BookingResponse> bookingHistory = bookingService.findCustomerBookingHistory();
        return ResponseEntity.ok(bookingHistory);
    }

    @DeleteMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        try {
            bookingService.deleteById(bookingId);
            return ResponseEntity.ok("Booking with ID " + bookingId + " canceled successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking with ID " + bookingId + " not found");
        }
    }
}
