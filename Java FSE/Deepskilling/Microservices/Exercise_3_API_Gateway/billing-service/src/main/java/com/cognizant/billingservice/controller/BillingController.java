package com.cognizant.billingservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/billing")
public class BillingController {

    @GetMapping("/{customerId}")
    public ResponseEntity<Map<String, Object>> getBillingByCustomerId(@PathVariable Long customerId) {
        Map<String, Object> billing = new HashMap<>();
        billing.put("customerId", customerId);
        billing.put("outstandingAmount", 150.50);
        billing.put("dueDate", "2026-08-15");
        billing.put("status", "UNPAID");
        return ResponseEntity.ok(billing);
    }
}
