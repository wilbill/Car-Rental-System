package com.carRentalSystem.service;

import com.carRentalSystem.dto.request.CreateBookingRequest;
import com.carRentalSystem.dto.response.BookingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<BookingResponse> findAll();
    BookingResponse findById(Long bookingId);
    boolean cancelBooking(Long bookingId);
    BookingResponse create(CreateBookingRequest bookingRequest);
    BookingResponse updateBooking(Long bookingId, CreateBookingRequest bookingRequest);
}
