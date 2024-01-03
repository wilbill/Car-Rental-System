package com.carRentalSystem.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
@Data //Means all setters, getters and constructors(noargs, allargs) will be entered
@Entity
public class Address {
    @Id //Makes it a pri key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremented, and mysql
    private Long id;
    @NotNull //means mandatory
    private String line1;
    private String line2;
    private String city;
    private String postalCode;
}
