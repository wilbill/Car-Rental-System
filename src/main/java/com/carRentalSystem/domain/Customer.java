package com.carRentalSystem.domain;

import com.carRentalSystem.domain.user.User;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Customer extends User {
    private String firstName;
    private String lastName;
    private String email;

}
