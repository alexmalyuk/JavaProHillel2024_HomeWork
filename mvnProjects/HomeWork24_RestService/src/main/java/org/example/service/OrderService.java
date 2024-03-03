package org.example.service;

import org.example.dto.Order;

import java.sql.SQLException;
import java.util.Collection;

public interface OrderService {
    Collection<String> getOrders() throws SQLException;

    Order getOrderById(String id) throws SQLException;

    void addOrder(Order order) throws SQLException;

    void deleteProduct(Order order, String idProduct) throws SQLException;

    void deleteOrder(Order order) throws SQLException;
}
