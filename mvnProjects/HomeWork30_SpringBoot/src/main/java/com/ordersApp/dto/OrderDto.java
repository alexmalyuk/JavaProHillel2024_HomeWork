package com.ordersApp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class OrderDto {
    private LocalDateTime date;
    private String name;
    private Double cost;
    private List<ProductDto> products;
}
