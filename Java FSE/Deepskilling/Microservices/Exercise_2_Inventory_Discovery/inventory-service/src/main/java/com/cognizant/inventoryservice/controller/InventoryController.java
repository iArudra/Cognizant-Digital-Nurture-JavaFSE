package com.cognizant.inventoryservice.controller;

import com.cognizant.inventoryservice.entity.Inventory;
import com.cognizant.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Value("${custom.message:Default Message}")
    private String customMessage;

    @GetMapping("/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(customMessage);
    }

    @PostMapping
    public ResponseEntity<Inventory> createOrUpdateInventory(@RequestBody Inventory inventory) {
        Inventory existing = inventoryRepository.findByProductId(inventory.getProductId()).orElse(null);
        if (existing != null) {
            existing.setStockLevel(inventory.getStockLevel());
            return ResponseEntity.ok(inventoryRepository.save(existing));
        }
        return ResponseEntity.ok(inventoryRepository.save(inventory));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventoryByProductId(@PathVariable Long productId) {
        return inventoryRepository.findByProductId(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        return ResponseEntity.ok(inventoryRepository.findAll());
    }
}
