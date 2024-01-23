package com.coffee.order;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    @DisplayName("createOrder - перевірка name")
    void createOrderCheckName() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        String name = "User name";
        Order order = Order.createOrder(orderBoard, name);
        assertEquals(name, order.getName());
    }

    @Test
    @DisplayName("createOrder - перевірка інкрементації number в різних бордах")
    void createOrderCheckNumber() {
        CoffeeOrderBoard board1 = new CoffeeOrderBoard();
        Order order11 = Order.createOrder(board1, "User1");
        Order order12 = Order.createOrder(board1, "User2");
        assertTrue(order12.getNumber() > order11.getNumber());

        CoffeeOrderBoard board2 = new CoffeeOrderBoard();
        Order order21 = Order.createOrder(board2, "User1");
        assertEquals(order11.getNumber(), order21.getNumber());
    }

    @Test
    @Disabled
    @DisplayName("createOrder - якщо name - null")
    void createOrderCheckNameIsNull() {
    }

    @Test
    @DisplayName("createOrder - якщо board - null")
    void createOrderCheckBoardIsNull() {
        assertThrows(NullPointerException.class, () -> Order.createOrder(null, "User name"));
    }
}