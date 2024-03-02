package com.example.ordermsdemo.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderRequest {
    private Long customerId;

    private Long productId;

    private int count;
    private LocalDateTime orderedAt;
}
