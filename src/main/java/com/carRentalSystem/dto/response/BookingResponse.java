//Order Response DTO
package com.carRentalSystem.dto.response;

import com.carRentalSystem.domain.Item;
import com.carRentalSystem.domain.Booking;
import com.carRentalSystem.domain.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data // getters, setters, equals(), hashCode(), and toString()
public class BookingResponse {
    private Long id;
    private User user;
    private List<Item> items = new ArrayList<>();

    public static BookingResponse from(Booking booking){
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.id = booking.getId();
        bookingResponse.user = booking.getUser();
        bookingResponse.items = booking.getItems();
        //orderResponse.setItems();
        return bookingResponse;
    }
}
