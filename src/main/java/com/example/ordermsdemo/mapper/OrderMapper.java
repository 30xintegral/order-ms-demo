package com.example.ordermsdemo.mapper;

import com.example.ordermsdemo.dto.response.OrderResponse;
import com.example.ordermsdemo.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class OrderMapper {
    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public abstract OrderResponse mapEntityToDto(Order order);
}
