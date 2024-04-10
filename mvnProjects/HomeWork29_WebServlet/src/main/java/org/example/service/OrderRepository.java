package org.example.service;

import org.example.dto.Order;
import org.example.dto.Product;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    List<Order> getOrders();

    Order getOrder(UUID id);

    Order createOrder(List<Product> products);

    boolean deleteOrder(UUID id);
}
