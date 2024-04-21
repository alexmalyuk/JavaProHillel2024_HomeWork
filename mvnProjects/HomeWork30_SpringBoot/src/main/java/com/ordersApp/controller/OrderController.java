package com.ordersApp.controller;

import com.ordersApp.dto.OrderDto;
import com.ordersApp.dto.OrderUpdateDto;
import com.ordersApp.dto.PageResponseDto;
import com.ordersApp.entity.Order;
import com.ordersApp.mapper.PageResponseMapper;
import com.ordersApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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
    public List<Order> getAllOrders() {
        log.info(String.format(CALL_ENDPOINT, "GET orders"));
        return orderService.getAllOrders();
    }

    @GetMapping("/page")
    public PageResponseDto<Order> getAllOrdersPage(@RequestParam int page, @RequestParam int size) {
        log.info(String.format(CALL_ENDPOINT, "DELETE orders/page " + page + "-" + size));
        return new PageResponseMapper<Order>().shrink(orderService.getAllOrders(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "GET order/" + id));
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    public Order addOrder(@RequestBody OrderUpdateDto orderUpdateDto) {
        log.info(String.format(CALL_ENDPOINT, "POST order"));
        return orderService.addOrder(orderUpdateDto);
    }

    @PatchMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody OrderUpdateDto orderUpdateDto) {
        log.info(String.format(CALL_ENDPOINT, "PATCH order/" + id));
        return orderService.updateOrder(id, orderUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "DELETE order/" + id));
        orderService.deleteOrder(id);
    }

    @DeleteMapping("/{order_id}/product/{product_id}")
    public Order deleteOrderProductById(@PathVariable Long order_id, @PathVariable Long product_id) {
        log.info(String.format(CALL_ENDPOINT, "DELETE order/" + order_id + "/product/" + product_id));
        return orderService.deleteOrderProductById(order_id, product_id);
    }

    @GetMapping("/user")
    public List<OrderDto> findOrdersByUserName(@RequestParam String name) {
        log.info(String.format(CALL_ENDPOINT, "GET orders/user : " + name));
        return orderService.findOrdersByUserName(name);
    }

}
