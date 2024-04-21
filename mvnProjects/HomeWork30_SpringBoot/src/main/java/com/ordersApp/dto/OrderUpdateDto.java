package com.ordersApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderUpdateDto {
    private String name;
    private List<Long> productIds;
}
