package com.carRentalSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller to test our code
@RestController
@RequestMapping("/api/v1/test-controller")
public class TestController {
    @GetMapping
    public ResponseEntity<String> sayHi(){

        return ResponseEntity.ok("Hello from secured end point");
    }

}
