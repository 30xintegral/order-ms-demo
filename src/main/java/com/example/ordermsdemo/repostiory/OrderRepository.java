package com.example.ordermsdemo.repostiory;

import com.example.ordermsdemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long id);

    @Override
    List<Order> findAll();
}
