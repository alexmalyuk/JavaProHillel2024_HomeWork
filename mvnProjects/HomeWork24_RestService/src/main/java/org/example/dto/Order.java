package org.example.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Accessors(chain = true)
public class Order {
    private String id;
    @SerializedName("date")
    private LocalDate date;
    private double cost = 0D;
    private List<Product> products = new ArrayList<>();

    public void deleteProduct(String idProduct) {
        products.removeIf(product -> Objects.equals(product.getId(), idProduct));
    }
}
