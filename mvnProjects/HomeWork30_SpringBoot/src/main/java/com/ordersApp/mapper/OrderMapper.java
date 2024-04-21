package com.ordersApp.mapper;

import com.ordersApp.dto.OrderDto;
import com.ordersApp.entity.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderMapper {

    public static OrderDto toOrderDto(Order order) {
        log.info("call toOrderDto");
        return new OrderDto()
                .setName(order.getName())
                .setDate(order.getDate())
                .setCost(order.getCost())
                .setProducts(order.getProducts().stream().map(ProductMapper::toProductDto).toList());
    }

}
