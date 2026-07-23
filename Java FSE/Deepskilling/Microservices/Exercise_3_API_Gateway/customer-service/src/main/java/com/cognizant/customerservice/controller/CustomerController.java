package com.cognizant.customerservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomerById(@PathVariable Long id) {
        Map<String, Object> customer = new HashMap<>();
        customer.put("id", id);
        customer.put("name", "John Doe");
        customer.put("email", "john.doe@example.com");
        customer.put("tier", "Gold");
        return ResponseEntity.ok(customer);
    }
}
