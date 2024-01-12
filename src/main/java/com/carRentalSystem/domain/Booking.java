package com.carRentalSystem.domain;

import com.carRentalSystem.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="booking") //order is a keyword, so wont save to db
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne//by default eager, join-table, but I want a join column, so
    @JoinColumn(name="Booking_User")
    private User user;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Item>items = new ArrayList<>();
    
}
