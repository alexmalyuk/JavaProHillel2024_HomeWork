package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Run {
    public static final Logger logger = LoggerFactory.getLogger("main_logger");

    public static void main(String[] args) {
        logger.info("Program start");

        try {
            CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

            orderBoard.add("Joe Biden");
            orderBoard.add("Barack Obama");
            orderBoard.add("George W. Bush");
            orderBoard.add("Bill Clinton");
            orderBoard.add("Ronald Reagan");
            orderBoard.add("Jimmy Carter");
            orderBoard.add("Gerald Ford");

            System.out.println("Deliver " + orderBoard.deliver(4));

            orderBoard.draw();

            Optional<Order> o;
            do {
                o = orderBoard.deliver();
                System.out.println("Deliver " + o.get());
            }
            while (o.isPresent());

        } catch (NoSuchElementException e) {
            logger.error("Program terminated on error", e);
        }

        logger.info("Program end.");
    }
}