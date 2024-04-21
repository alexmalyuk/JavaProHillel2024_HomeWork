package com.ordersApp.mapper;

import com.ordersApp.dto.ProductDto;
import com.ordersApp.entity.Product;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        log.info("call toProductDto");
        return new ProductDto()
                .setName(product.getName())
                .setCost(product.getCost());
    }
}
