package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Order;
import org.example.dto.Product;
import org.example.service.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;

    private static final String CALL_ENDPOINT = "call endpoint : %s ";

    @GetMapping("/orders")
    public List<Order> getOrders() {
        log.info(String.format(CALL_ENDPOINT, "GET orders"));
        return orderRepository.getOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrder(@PathVariable UUID id) {
        log.info(String.format(CALL_ENDPOINT, "GET orders/{" + id.toString() + "}"));
        return orderRepository.getOrder(id);
    }

    @DeleteMapping("/orders/{id}")
    public boolean deleteOrder(@PathVariable UUID id) {
        log.info(String.format(CALL_ENDPOINT, "DELETE orders/{" + id.toString() + "}"));
        return orderRepository.deleteOrder(id);
    }

    @PostMapping("/orders/{id}")
    public Order addOrder(@RequestBody List<Product> products) {
        log.info(String.format(CALL_ENDPOINT, "POST orders"));
        return orderRepository.createOrder(products);
    }
}
