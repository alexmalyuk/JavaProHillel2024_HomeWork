package org.example.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.example.dto.Order;
import org.example.dto.Product;

import java.time.LocalDate;
import java.util.UUID;

public class JsonMapper {

    private static Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

    public static JsonElement objectToJson(Object object) {
        return getGson().toJsonTree(object);
    }

    public static Order orderFromJson(String jsonTree) {
        Order order = getGson().fromJson(jsonTree, Order.class);

        order.setId(UUID.randomUUID().toString());
        order.getProducts().forEach(product -> product.setId(UUID.randomUUID().toString()));
        order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

        return order;
    }
}
