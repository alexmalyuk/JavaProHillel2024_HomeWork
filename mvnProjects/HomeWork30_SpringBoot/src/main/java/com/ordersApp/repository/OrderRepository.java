package com.ordersApp.repository;

import com.ordersApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    Optional<Order> findById(Long id);
    Order save(Order entity);

    void delete(Order entity);
}
