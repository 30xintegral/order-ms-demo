package com.example.ordermsdemo.service;

import com.example.ordermsdemo.dto.request.OrderRequest;
import com.example.ordermsdemo.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse create(OrderRequest orderRequest);

    OrderResponse getById(Long id);

    List<OrderResponse> getAll();

}
