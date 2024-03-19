package org.example;

import lombok.Getter;
import lombok.ToString;

import static org.example.Run.logger;

@ToString
@Getter
public class Order {

    private int number;
    private String name;

    private Order() {
    }

    public static Order createOrder(CoffeeOrderBoard board, String name) {
        Order order = new Order();
        order.number = board.getNextOrderNumber();
        order.name = name;
        logger.info("Order created: " + order);
        return order;
    }

}
