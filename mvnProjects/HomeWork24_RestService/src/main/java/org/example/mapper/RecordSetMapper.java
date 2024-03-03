package org.example.mapper;

import org.example.dto.Order;
import org.example.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecordSetMapper {
    public static Collection<String> allOrdersRsToDto(ResultSet resultSet) throws SQLException {
        List<String> orders = new ArrayList<>();
        while (resultSet.next()) {
            orders.add(resultSet.getString("id"));
        }
        return orders;
    }

    public static Order orderRsToDto(ResultSet orderRecordSet) throws SQLException {
        if (orderRecordSet.next()) {
            Order order = new Order();
            order.setId(orderRecordSet.getString("id"));
            order.setDate(DateMapper.convertDateFromString(orderRecordSet.getString("date")));
            order.setCost(Double.parseDouble(orderRecordSet.getString("cost")));
            return order;
        } else {
            return null;
        }
    }

    public static List<Product> productsRsToDto(ResultSet resultSet) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            products.add(new Product()
                    .setId(resultSet.getString("id"))
                    .setName(resultSet.getString("name"))
                    .setCost(Double.parseDouble(resultSet.getString("cost")))
            );
        }
        return products;
    }
}
