package com.example.ordermsdemo.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderResponse {
    private Long id;

    private Long customerId;

    private Long productId;

    private int count;

    private double price;

    private LocalDateTime orderedAt;
}
