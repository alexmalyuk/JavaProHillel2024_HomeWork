package com.coffee.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    @DisplayName("наступний номер замовлення")
    void getNextOrderNumber() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        assertEquals(-1, board.getNextOrderNumber() - board.getNextOrderNumber());
    }

    @Test
    @DisplayName("додавання в чергу")
    void add() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        String name = "User name";
        Order order = board.add(name);
        assertEquals(name, order.getName());
        assertEquals(order, board.deliver());
    }

    @Test
    @DisplayName("deliver якщо черга пуста")
    void deliverIfEmptyBoard() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        assertNull(board.deliver());
    }

    @Test
    @DisplayName("deliver якщо черга не пуста")
    void deliverIfNotEmptyBoard() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Order order1 = board.add("User name1");
        Order order2 = board.add("User name2");
        Order order3 = board.add("User name3");
        assertEquals(order1, board.deliver());
    }

    @Test
    @DisplayName("deliver перевірка видалення з черги")
    void deliverCheckDeletion() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User name");         // +1
        board.deliver();                // -1
        assertNull(board.deliver());    // null
    }

    @Test
    @DisplayName("deliver за номером якщо черга пуста")
    void deliverByNumberIfEmptyBoard() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        assertNull(board.deliver(1));
    }

    @Test
    @DisplayName("deliver за номером якщо черга не пуста")
    void deliverByNumberIfNotEmptyBoard() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Order order = board.add("User name");
        assertEquals(order, board.deliver(order.getNumber()));
    }

    @Test
    @DisplayName("deliver за неіснуючим номером")
    void deliverByNumberNotExists() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("User name");
        assertNull(board.deliver(123456));
    }

    @Test
    @DisplayName("deliver за номером перевірка видалення з черги")
    void deliverByNumberCheckDeletion() {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        Order order = board.add("User name");
        assertEquals(order, board.deliver(order.getNumber()));
        assertNull(board.deliver(order.getNumber()));
    }
}