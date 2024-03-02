package com.example.ordermsdemo.controller;

import com.example.ordermsdemo.dto.request.OrderRequest;
import com.example.ordermsdemo.dto.response.OrderResponse;
import com.example.ordermsdemo.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/makeOrder")
    public OrderResponse makeOrder(@RequestBody OrderRequest orderRequest){
        return orderService.create(orderRequest);
    }
}
