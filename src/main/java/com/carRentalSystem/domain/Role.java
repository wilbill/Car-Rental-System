package com.carRentalSystem.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy = "roles")     //this also means the owning side of the relationship is User entity, and this owning field is roles
    private List<User> userList;


}
