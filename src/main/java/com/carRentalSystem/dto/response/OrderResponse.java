//Order Response DTO
package com.carRentalSystem.dto.response;

import com.carRentalSystem.domain.Item;
import com.carRentalSystem.domain.Orders;
import com.carRentalSystem.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data // getters, setters, equals(), hashCode(), and toString()
public class OrderResponse {
    private Long id;
    private User user;
    private List<Item> items = new ArrayList<>();

    public static OrderResponse from(Orders orders){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.id = orders.getId();
        orderResponse.user = orders.getUser();
        orderResponse.items = orders.getItems();
        //orderResponse.setItems();
        return orderResponse;
    }
}
