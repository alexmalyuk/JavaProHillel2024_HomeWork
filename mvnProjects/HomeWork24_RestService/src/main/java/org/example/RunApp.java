package org.example;

import com.google.gson.Gson;
import org.example.dto.Order;
import org.example.mapper.JsonMapper;
import org.example.rest.StandardResponse;
import org.example.rest.StatusResponse;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceMySql;

import static spark.Spark.*;

public class RunApp {
    //private static final OrderService orderService = new OrderServiceMap();
    private static final OrderService orderService = new OrderServiceMySql();

    public static void main(String[] args) {

        get("/ping", (request, response) -> "Hello");

        get("/order", (request, response) -> {
            response.type("application/json");
            return new Gson()
                    .toJson(new StandardResponse(
                            StatusResponse.SUCCESS,
                            JsonMapper.objectToJson(orderService.getOrders())));
        });

        get("/order/:uuid", (request, response) -> {
            response.type("application/json");
            String id = request.params(":uuid");

            Order order = orderService.getOrderById(id);

            if (order != null) {
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.SUCCESS,
                                JsonMapper.objectToJson(order)));
            } else {
                response.status(404);
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.ERROR,
                                "Order not found"));
            }
        });

        post("/order", (request, response) -> {
            response.type("application/json");

            Order order = JsonMapper.orderFromJson(request.body());
            orderService.addOrder(order);
            response.status(201);
            return new Gson()
                    .toJson(new StandardResponse(
                            StatusResponse.SUCCESS,
                            JsonMapper.objectToJson(order)));
        });

        delete("/order/:idOrder/:idProduct", (request, response) -> {
            response.type("application/json");

            String idOrder = request.params(":idOrder");
            String idProduct = request.params(":idProduct");

            Order order = orderService.getOrderById(idOrder);

            if (order != null) {
                orderService.deleteProduct(order, idProduct);
                order = orderService.getOrderById(idOrder);
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.SUCCESS,
                                JsonMapper.objectToJson(order)));
            } else {
                response.status(404);
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.ERROR,
                                "Order not found"));
            }
        });
        delete("/order/:idOrder", (request, response) -> {
            response.type("application/json");

            String idOrder = request.params(":idOrder");
            Order order = orderService.getOrderById(idOrder);

            if (order != null) {
                orderService.deleteOrder(order);
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.SUCCESS));
            } else {
                response.status(404);
                return new Gson()
                        .toJson(new StandardResponse(
                                StatusResponse.ERROR,
                                "Order not found"));
            }
        });
    }
}