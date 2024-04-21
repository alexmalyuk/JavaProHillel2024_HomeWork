package com.ordersApp.service;

import com.ordersApp.dto.OrderDto;
import com.ordersApp.dto.OrderUpdateDto;
import com.ordersApp.entity.Order;
import com.ordersApp.entity.Product;
import com.ordersApp.exception.OrderNotFoundException;
import com.ordersApp.mapper.OrderMapper;
import com.ordersApp.repository.OrderRepository;
import com.ordersApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    private double calculateOrderCost(List<Product> products) {
        log.info("call calculateOrderCost");
        return products.stream()
                .mapToDouble(Product::getCost)
                .sum();
    }

    public List<Order> getAllOrders() {
        log.info(String.format("call getAllOrders"));
        return orderRepository.findAll();
    }

    public Page<Order> getAllOrders(PageRequest of) {
        log.info(String.format("call getAllOrders page of" + of));
        return orderRepository.findAll(of);
    }

    public Order getOrderById(Long id) {
        log.info(String.format("call getOrderById : ", id));
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(String.valueOf(id)));
    }

    public Order addOrder(OrderUpdateDto orderUpdateDto) {
        log.info(String.format("call addOrder"));
        Order order = new Order()
                .setDate(LocalDateTime.now())
                .setName(orderUpdateDto.getName())
                .setProducts(productRepository.findAllByIdIn(orderUpdateDto.getProductIds()));
        order.setCost(calculateOrderCost(order.getProducts()));
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        log.info(String.format("call deleteOrder : %s", id));
        orderRepository.delete(getOrderById(id));
    }

    public Order updateOrder(Long id, OrderUpdateDto orderUpdateDto) {
        log.info(String.format("call updateOrder : s", id));
        Order order = getOrderById(id);
        if (orderUpdateDto.getName() != null) {
            order.setName(orderUpdateDto.getName());
        }
        order.getProducts().addAll(productRepository.findAllByIdIn(orderUpdateDto.getProductIds()));
        order.setCost(calculateOrderCost(order.getProducts()));
        return orderRepository.save(order);
    }

    public Order deleteOrderProductById(Long orderId, Long productId) {
        log.info(String.format("call deleteOrderProductById Order %s Product %s", orderId, productId));
        Order order = getOrderById(orderId);
        order.getProducts().removeIf(product -> product.getId().equals(productId));
        order.setCost(calculateOrderCost(order.getProducts()));
        return orderRepository.save(order);
    }

    public List<OrderDto> findOrdersByUserName(String name) {
        log.info(String.format("call findOrdersByUserName %s", name));
        return orderRepository.findAllByNameContainsIgnoreCase(name).stream()
                .map(OrderMapper::toOrderDto)
                .toList();
    }

}
