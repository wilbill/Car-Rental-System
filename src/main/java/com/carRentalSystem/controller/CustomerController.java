package com.carRentalSystem.controller;

import com.carRentalSystem.dto.request.CreateBookingRequest;
import com.carRentalSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/customer")
@PreAuthorize("hasRole('CUSTOMER')")
public class CustomerController {

    @Autowired
    private BookingService bookingService;

    // Customer-specific endpoint
    // Customer-specific endpoint to retrieve information about the authenticated customer
    @GetMapping
    public ResponseEntity<String> getCustomer(Principal principal) {
        // Logic to retrieve and return information about the authenticated customer
        // You might use the Principal to get the username or ID of the authenticated user
        String username = principal.getName();
        // Fetch customer information based on the username

        return ResponseEntity.ok("GET:: customer information for " + username);
    }

    // Customer-specific action, e.g., make a booking
    @PostMapping("/bookings")
    public ResponseEntity<String> makeBooking(@RequestBody CreateBookingRequest bookingRequest) {
        // Implement logic to create a booking for the customer
        return ResponseEntity.ok("Booking created successfully.");
    }

    // Customer-specific action, e.g., view booking history
    @GetMapping("/bookings/history")
    public ResponseEntity<String> viewBookingHistory() {
        // Implement logic to retrieve and return booking history for the customer
        return ResponseEntity.ok("GET:: booking history");
    }

    // Customer-specific action, e.g., cancel a booking
    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        // Implement logic to cancel the booking for the customer
        // Assume there is a BookingService with a method like cancelBooking
        // This is just a placeholder and may need modification based on your actual implementation.
        boolean cancellationSuccessful = bookingService.cancelBooking(bookingId);

        if (cancellationSuccessful) {
            return ResponseEntity.ok("Booking canceled successfully.");
        } else {
            return ResponseEntity.status(400).body("Unable to cancel the booking. Check the booking ID.");
        }
    }
}

