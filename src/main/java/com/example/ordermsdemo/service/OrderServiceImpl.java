package com.example.ordermsdemo.service;

import com.example.ordermsdemo.dto.request.OrderRequest;
import com.example.ordermsdemo.dto.response.CustomerResponse;
import com.example.ordermsdemo.dto.response.OrderResponse;
import com.example.ordermsdemo.dto.response.ProductResponse;
import com.example.ordermsdemo.entity.Order;
import com.example.ordermsdemo.feign.CustomerClient;
import com.example.ordermsdemo.feign.ProductClient;
import com.example.ordermsdemo.mapper.OrderMapper;
import com.example.ordermsdemo.repostiory.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    @Override
    public OrderResponse create(OrderRequest orderRequest) {
        CustomerResponse customerResponse = customerClient.getCustomer(orderRequest.getCustomerId()).getBody();
        ProductResponse productResponse = productClient.getProductById(orderRequest.getProductId());

        if (orderRequest.getCount()>productResponse.getCount()){
            throw new RuntimeException("Not enough stock");
        }
        if (productResponse.getPrice()*orderRequest.getCount()> customerResponse.getBalance()){
            throw new RuntimeException("Insufficient balance");
        }
        customerClient.decreaseBalanceBy(orderRequest.getCustomerId(), productResponse.getPrice()*orderRequest.getCount());
        productClient.decreaseCountBy(orderRequest.getProductId(), orderRequest.getCount());

        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setProductId(orderRequest.getProductId());
        order.setCount(orderRequest.getCount());
        order.setPrice(productResponse.getPrice()*orderRequest.getCount());
        order.setOrderedAt(LocalDateTime.now());
        return OrderMapper.INSTANCE.mapEntityToDto(order);
    }

    @Override
    public OrderResponse getById(Long id) {
        return null;
    }

    @Override
    public List<OrderResponse> getAll() {
        return null;
    }
}
