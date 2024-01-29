package org.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Product {
    public ProductType type;
    public Double price;
    public boolean discountAllowed;
    public LocalDate creatingDate;
    public int id;
}
