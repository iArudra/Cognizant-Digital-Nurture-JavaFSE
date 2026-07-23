package com.cognizant.paymentservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/process")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public ResponseEntity<String> processPayment() {
        String response = restTemplate.getForObject("http://localhost:8089/slow-api", String.class);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<String> paymentFallback(Throwable t) {
        System.err.println("Circuit Breaker Fallback triggered! Reason: " + t.getMessage());
        return ResponseEntity.status(503).body("Payment service is temporarily unavailable. (Fallback triggered: " + t.getMessage() + ")");
    }
}
