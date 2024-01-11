package homework.homework13.coffee.order;

public class Order {
    private int number;
    private String name;

    private Order() {
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public static Order createOrder(CoffeeOrderBoard board, String name) {
        Order order = new Order();
        order.number = board.getNextOrderNumber();
        order.name = name;
        return order;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
