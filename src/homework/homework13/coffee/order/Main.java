package homework.homework13.coffee.order;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        orderBoard.add("Joe Biden");
        orderBoard.add("Donald Trump");
        orderBoard.add("Barack Obama");
        orderBoard.add("George W. Bush");
        orderBoard.add("Bill Clinton");
        orderBoard.add("George H.W. Bush");
        orderBoard.add("Ronald Reagan");
        orderBoard.add("Jimmy Carter");
        orderBoard.add("Gerald Ford");
        Order order = orderBoard.add("Richard Nixon");
        System.out.println(order);

        System.out.println(orderBoard.deliver() + " - delivered");
        System.out.println(orderBoard.deliver() + " - delivered");
        System.out.println(orderBoard.deliver(10) + " - delivered");

        orderBoard.add("Lyndon B. Johnson");
        orderBoard.add("John F. Kennedy");

        orderBoard.draw();

    }
}
