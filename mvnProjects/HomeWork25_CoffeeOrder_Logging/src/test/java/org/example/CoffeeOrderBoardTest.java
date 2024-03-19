package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    void deliverFirst() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order added_order = orderBoard.add("Name");

        Optional<Order> delivered_order = orderBoard.deliver();
        Assertions.assertTrue(delivered_order.isPresent());
        Assertions.assertEquals(added_order, delivered_order.get());
    }
    @Test
    void deliverFirstEmptyList() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Optional<Order> delivered_order = orderBoard.deliver();
        Assertions.assertTrue(delivered_order.isEmpty());
    }

    @Test
    void deliveryByNumber() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order added_order1 = orderBoard.add("Name1");
        Order added_order2 = orderBoard.add("Name2");
        Order added_order3 = orderBoard.add("Name3");

        Optional<Order> delivered_order = orderBoard.deliver(added_order2.getNumber());
        Assertions.assertTrue(delivered_order.isPresent());
        Assertions.assertEquals(added_order2, delivered_order.get());
    }
    @Test
    void deliveryByNumberWrongNumber() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.add("Name1");

        Optional<Order> delivered_order = orderBoard.deliver(12345);
        Assertions.assertTrue(delivered_order.isEmpty());
    }
}