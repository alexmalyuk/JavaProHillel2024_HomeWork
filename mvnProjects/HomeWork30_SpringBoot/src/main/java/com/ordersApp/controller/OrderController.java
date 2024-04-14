package com.ordersApp.controller;

import com.ordersApp.dto.ProductDto;
import com.ordersApp.entity.Order;
import com.ordersApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private static final String CALL_ENDPOINT = "call endpoint : %s ";
    private final OrderService orderService;

    @GetMapping()
    public List<Order> gerAllOrders() {
        log.info(String.format(CALL_ENDPOINT, "GET orders"));
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order gerOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "GET order/" + id));
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    public Order AddOrder(@RequestBody List<ProductDto> products) {
        log.info(String.format(CALL_ENDPOINT, "POST order"));
        return orderService.addOrder(products);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "DELETE order/" + id));
        orderService.deleteOrder(id);
    }
}
