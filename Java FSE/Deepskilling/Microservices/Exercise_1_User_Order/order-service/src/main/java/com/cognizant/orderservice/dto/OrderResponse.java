package com.cognizant.orderservice.dto;

import com.cognizant.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Order order;
    private UserDTO user;
}
