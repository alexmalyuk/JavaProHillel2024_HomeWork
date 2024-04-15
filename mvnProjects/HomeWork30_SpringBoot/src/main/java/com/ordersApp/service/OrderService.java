package com.ordersApp.service;

import com.ordersApp.dto.ProductDto;
import com.ordersApp.entity.Order;
import com.ordersApp.entity.Product;
import com.ordersApp.exception.OrderNotFoundException;
import com.ordersApp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    private void calculateOrderCost(Order order) {
        log.info(String.format("calculateOrderCost id: ", order.getId()));
        Double cost = order.getProducts().stream()
                .mapToDouble(Product::getCost)
                .sum();
        order.setCost(cost);
    }

    public List<Order> getAllOrders() {
        log.info(String.format("getAllOrders"));
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        log.info(String.format("getOrderById : ", id));
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.valueOf(id)));
    }

    public Order addOrder(List<ProductDto> products) {
        log.info(String.format("addOrder"));
        var list = products.stream()
                .map(pDto -> new Product()
                        .setName(pDto.getName())
                        .setCost(pDto.getCost()))
                .toList();

        Order order = new Order()
                .setDate(LocalDateTime.now())
                .setProducts(list);
        calculateOrderCost(order);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        log.info(String.format("deleteOrder"));
        orderRepository.delete(getOrderById(id));
    }
}
