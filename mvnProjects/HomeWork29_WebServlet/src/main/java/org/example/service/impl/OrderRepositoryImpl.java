package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.Order;
import org.example.dto.Product;
import org.example.service.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class implements simple in-memory repository of orders
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderList = new ArrayList<>();

    /**
     * Calculates sum of cost of products
     *
     * @param products
     * @return
     */
    private double calculateCost(List<Product> products) {
        log.info("calculateCost of products");
        return products.stream()
                .mapToDouble(Product::getCost)
                .sum();
    }

    /**
     * Returns list of all orders
     *
     * @return list of orders
     */
    @Override
    public List<Order> getOrders() {
        log.info("getOrders");
        return orderList;
    }

    /**
     * Returns order by id
     *
     * @param id
     * @return found order or throws {@link java.util.NoSuchElementException}
     */
    @Override
    public Order getOrder(UUID id) {
        log.info("getOrder by id " + id.toString());
        return orderList.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst().orElseThrow();
    }

    /**
     * Creates an order and stores them
     *
     * @param products list of products
     * @return created order
     */
    @Override
    public Order createOrder(List<Product> products) {
        List<Product> products1 = products.stream()
                .filter(product -> product.getId() == null)
                .peek(product -> product.setId(UUID.randomUUID()))
                .toList();

        Order order = new Order()
                .setId(UUID.randomUUID())
                .setDate(LocalDateTime.now())
                .setProducts(products)
                .setCost(calculateCost(products1));

        orderList.add(order);

        log.info("createOrder " + order.getId().toString());
        return order;
    }

    /**
     * Removes an order by id
     *
     * @param id
     * @return true if successfully delete or false on other case
     */
    @Override
    public boolean deleteOrder(UUID id) {
        log.info("deleteOrder by id " + id.toString());
        return orderList.removeIf(order -> order.getId().equals(id));
    }
}
