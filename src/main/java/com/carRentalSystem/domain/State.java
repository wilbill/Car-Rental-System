package com.carRentalSystem.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="zipcode")
    private String code;

    @Column(name="state_name", nullable=false)
    private String name;

    @ManyToOne
    @JoinColumn(name="state_country")
    private Country country;
}
