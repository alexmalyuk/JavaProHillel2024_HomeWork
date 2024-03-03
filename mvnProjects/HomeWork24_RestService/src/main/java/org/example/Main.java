package org.example;

import org.example.dto.Order;
import org.example.dto.Product;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceMySql;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {

        Product pr1 = new Product();
        pr1.setId(UUID.randomUUID().toString());
        pr1.setName("Сало");
        pr1.setCost(10D);
        Product pr2 = new Product();
        pr2.setId(UUID.randomUUID().toString());
        pr2.setName("Хліб");
        pr2.setCost(12D);
        Product pr3 = new Product();
        pr3.setId(UUID.randomUUID().toString());
        pr3.setName("Цибуля");
        pr3.setCost(3D);

        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setDate(LocalDate.now());
        order.setCost(25);
        order.setProducts(List.of(pr1, pr2, pr3));

//        JsonElement json1 = JsonMapper.objectToJson(order);
//        System.out.println(json1);
//
//        Order order2 = JsonMapper.orderFromJson(json1.toString());
//        System.out.println(order2);

        OrderService orderService = new OrderServiceMySql();

        try {
            orderService.addOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Order order2 = orderService.getOrderById("dfdsfsdfsdf");
//        Collection<String> orders = orderService.getOrders();
//        System.out.println(orders);
    }
}
