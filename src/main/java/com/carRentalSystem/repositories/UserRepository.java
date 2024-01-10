package com.carRentalSystem.repositories;

import com.carRentalSystem.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //though not compulsory coz spring already knows it exists
public interface UserRepository extends JpaRepository<User, Integer> {
    //method to retrieve user by email
    Optional<User> findUsersByEmail(String email);
}
