package org.example.service.impl;

import org.example.config.DBConnectivity;
import org.example.dto.Order;
import org.example.dto.Product;
import org.example.mapper.RecordSetMapper;
import org.example.service.OrderService;

import java.sql.*;
import java.util.Collection;
import java.util.List;

public class OrderServiceMySql implements OrderService {
    private static final String GET_ALL_ORDERS = "select id from orders";
    private static final String GET_ORDER_BY_ID = """
            select * from orders
            where id = ?
            """;
    private static final String GET_PRODUCTS_BY_ORDER_ID = """
            select p.id, p.name, p.cost
            from products p
            where p.order_id = ?
            """;
    private static final String INSERT_INTO_ORDERS = """
            INSERT INTO orders (id, date, cost)
            VALUES (?, ?, ?)
            """;
    private static final String INSERT_INTO_PRODUCTS = """
            insert into products(id, name, cost, order_id)
            VALUES (?, ?, ?, ?);
            """;
    private static final String DELETE_FROM_PRODUCTS = """
            delete FROM products 
            WHERE order_id = ? AND id = ?
            """;
    private static final String DELETE_FROM_ORDERS = """
            delete FROM orders
            WHERE id = ?
            """;

    @Override
    public Collection<String> getOrders() throws SQLException {
        Connection connection = DBConnectivity.getConnection();
        Statement statement = connection.createStatement();

        ResultSet ordersRecordSet = statement.executeQuery(GET_ALL_ORDERS);
        Collection<String> orders = RecordSetMapper.allOrdersRsToDto(ordersRecordSet);

        DBConnectivity.closeConnection();
        return orders;
    }

    @Override
    public Order getOrderById(String id) throws SQLException {
        Connection connection = DBConnectivity.getConnection();

        PreparedStatement statement = connection.prepareStatement(GET_ORDER_BY_ID);
        statement.setString(1, id);
        ResultSet orderRecordSet = statement.executeQuery();
        Order order = RecordSetMapper.orderRsToDto(orderRecordSet);

        if (order != null) {
            statement = connection.prepareStatement(GET_PRODUCTS_BY_ORDER_ID);
            statement.setString(1, id);
            ResultSet productsRecordSet = statement.executeQuery();
            List<Product> products = RecordSetMapper.productsRsToDto(productsRecordSet);
            order.setProducts(products);
        }

        DBConnectivity.closeConnection();
        return order;
    }

    @Override
    public void addOrder(Order order) throws SQLException {
        Connection connection = DBConnectivity.getConnection();

        PreparedStatement statement = connection.prepareStatement(INSERT_INTO_ORDERS);
        statement.setString(1, order.getId());
        statement.setDate(2, Date.valueOf(order.getDate()));
        statement.setDouble(3, order.getCost());
        statement.execute();

        statement = connection.prepareStatement(INSERT_INTO_PRODUCTS);
        for (Product product : order.getProducts()) {
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getCost());
            statement.setString(4, order.getId());
            statement.execute();
        }
        DBConnectivity.closeConnection();
    }

    @Override
    public void deleteProduct(Order order, String idProduct) throws SQLException {
        if (order != null) {
            Connection connection = DBConnectivity.getConnection();

            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_PRODUCTS);
            statement.setString(1, order.getId());
            statement.setString(2, idProduct);
            statement.execute();

            DBConnectivity.closeConnection();
        }
    }

    @Override
    public void deleteOrder(Order order) throws SQLException {
        if (order != null) {
            Connection connection = DBConnectivity.getConnection();

            PreparedStatement statement = connection.prepareStatement(DELETE_FROM_ORDERS);
            statement.setString(1, order.getId());
            statement.execute();

            DBConnectivity.closeConnection();
        }
    }
}
