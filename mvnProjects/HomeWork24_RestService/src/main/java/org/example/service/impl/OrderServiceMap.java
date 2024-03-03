package org.example.service.impl;

import org.example.dto.Order;
import org.example.service.OrderService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceMap implements OrderService {
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public Collection<String> getOrders() {
        return orders.keySet();
    }

    @Override
    public Order getOrderById(String id) {
        return orders.getOrDefault(id, new Order());
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void deleteProduct(Order order, String idProduct) {
        if (order != null) {
            order.deleteProduct(idProduct);
        }
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order.getId());
    }
}
