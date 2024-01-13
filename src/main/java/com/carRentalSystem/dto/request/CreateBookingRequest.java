package com.carRentalSystem.dto.request;

import com.carRentalSystem.domain.Item;
import com.carRentalSystem.domain.user.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CreateBookingRequest {
    private Long id;
    private User user; //get user from principal, not here
    private List<ItemDTO> items = new ArrayList<>();
}
