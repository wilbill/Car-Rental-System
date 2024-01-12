package com.carRentalSystem.service.impl;

import com.carRentalSystem.Exceptions.BookingNotFoundException;
import com.carRentalSystem.domain.Booking;
import com.carRentalSystem.dto.request.CreateBookingRequest;
import com.carRentalSystem.dto.response.BookingResponse;
import com.carRentalSystem.repositories.BookingRepository;
import com.carRentalSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<BookingResponse> findAll() {
        return bookingRepository.findAll()
                .stream()//convert o/p to stream to apply stream operations
                .map(BookingResponse::from)//converts order obj to orderResponse obj
                .collect(Collectors.toList());
        //map transforms object to a different form, or modifies some property of the object
        //by applying a method to tht object
        //filter is normally for checking  and its normally boolean, map is for transforming by applying methods to the given data
    }

    @Override
    public BookingResponse findById(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(
                ()-> new BookingNotFoundException(String.format("Order with id %s Not Found", bookingId))
        );
        return BookingResponse.from(booking);
    }

    @Override
    public boolean cancelBooking(Long bookingId) {
        return false;
    }

    //For the POST METHOD ===I.E CREATING AN OBJECT
    @Override
    public BookingResponse create(CreateBookingRequest bookingRequest) {
        Booking booking = new Booking();
       //I shouldnt set the id or get the id
        booking.setUser(bookingRequest.getUser());
        booking.setItems(bookingRequest.getItems());
        booking = bookingRepository.save(booking);
        return BookingResponse.from(booking);
    }

    //This is my update method making use of the @PutController
    @Override
    public BookingResponse updateBooking(Long bookingId, CreateBookingRequest bookingRequest) {
        return null;
    }
}
