package org.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class Order {
    private UUID id;
    private LocalDateTime date;
    private double cost = 0D;
    private List<Product> products = new ArrayList<>();
}
