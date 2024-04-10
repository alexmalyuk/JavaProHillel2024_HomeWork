package org.example.service.impl;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.service.OrderRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class OrderRepositoryImplTest {

    @Test
    public void getAllOrders() {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        Assertions.assertTrue(orderRepository.getOrders().isEmpty());

        orderRepository.createOrder(List.of(new Product().setName("some product").setCost(10)));
        Assertions.assertFalse(orderRepository.getOrders().isEmpty());
    }

    @Test
    public void getOneOrder() {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        Assertions.assertThrows(NoSuchElementException.class, () -> orderRepository.getOrder(UUID.randomUUID()));

        Order order = orderRepository.createOrder(List.of(new Product().setName("some product").setCost(10)));
        Assertions.assertEquals(order, orderRepository.getOrder(order.getId()));
    }

    @Test
    public void createOrder() {
        OrderRepository orderRepository = new OrderRepositoryImpl();

        Order order = orderRepository.createOrder(List.of(new Product().setName("some product").setCost(10)));
        Assertions.assertInstanceOf(Order.class, order);
        Assertions.assertEquals(10, order.getCost());
    }

    @Test
    public void deleteOrder() {
        OrderRepository orderRepository = new OrderRepositoryImpl();

        Order order = orderRepository.createOrder(List.of(new Product().setName("some product").setCost(10)));
        Assertions.assertTrue(orderRepository.deleteOrder(order.getId()));
        Assertions.assertFalse(orderRepository.deleteOrder(UUID.randomUUID()));
    }
}