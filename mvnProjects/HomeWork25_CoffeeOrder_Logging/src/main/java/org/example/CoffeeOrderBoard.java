package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.example.Run.logger;

public class CoffeeOrderBoard {
    private final List<Order> orderList = new ArrayList<>();
    private int maxOrderNumber = 1;

    public int getNextOrderNumber() {
        logger.info(String.format("Get next order number %d", maxOrderNumber));
        return maxOrderNumber++;
    }

    public Order add(String name) {
        Order newOrder = Order.createOrder(this, name);
        orderList.add(newOrder);
        logger.info("Order added to the Board: " + newOrder);
        return newOrder;
    }

    public Optional<Order> deliver() {
        Optional<Order> found_order = orderList.stream()
                .min(Comparator.comparing(Order::getNumber));
        found_order.ifPresent(orderList::remove);
        logger.info("Deliver - first order: " + found_order);
        return found_order;
    }

    public Optional<Order> deliver(int number) {
        Optional<Order> found_order = orderList.stream()
                .filter(o -> o.getNumber() == number)
                .findFirst();
        found_order.ifPresent(orderList::remove);
        logger.info("Deliver - order by number " + number + ": " + found_order);
        return found_order;
    }

    public void draw() {
        logger.info("Print list of orders");
        orderList.forEach(o -> System.out.println(o.getNumber() + " | " + o.getName()));
    }
}
