package homework.homework13.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final List<Order> orderList = new ArrayList<>();
    private int nextOrderNumber = 1;

    public int getNextOrderNumber() {
        return nextOrderNumber++;
    }

    public Order add(String name) {
        Order newOrder = Order.createOrder(this, name);
        orderList.add(newOrder);
        return newOrder;
    }

    public Order deliver() {
        if (!orderList.isEmpty()) {
            Order first = orderList.get(0);
            orderList.remove(first);
            return first;
        } else
            return null;
    }

    public Order deliver(int number) {
        for (Order order : orderList)
            if (order.getNumber() == number) {
                orderList.remove(order);
                return order;
            }
        return null;
    }

    public void draw() {
        for (Order order : orderList)
            System.out.println(order.getNumber() + " | " + order.getName());
    }

}
