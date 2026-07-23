package com.cognizant.slowservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/slow-api")
public class SlowController {

    @GetMapping
    public ResponseEntity<String> processPayment() {
        try {
            // Introduce artificial delay of 3 seconds
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return ResponseEntity.ok("Payment processed successfully by third-party!");
    }
}
