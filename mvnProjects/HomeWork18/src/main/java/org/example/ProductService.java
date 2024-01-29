package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {

    public List<Product> getProductsByTypeOverPrice(List<Product> src, ProductType type, double minPrice) {
        return src.stream()
                .filter(e -> e.getType().equals(type) && e.getPrice() > minPrice)
                .toList();
    }

    public List<Product> getProductsByTypeApplyDiscount(List<Product> src, ProductType type, double discountRate) {
        return src.stream()
                .filter(e -> e.getType().equals(type))
                .peek(e -> e.setPrice(e.isDiscountAllowed() ? e.getPrice() * (1 - discountRate) : e.getPrice()))
                .toList();
    }

    public Product getCheapestByType(List<Product> src, ProductType type) {
        return src.stream()
                .filter(e -> e.getType().equals(type))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new RuntimeException("Продукт [категорія: " + type + "] не знайдено"));
    }

    public List<Product> getLastAdded(List<Product> src, int lastCount) {
        return src.stream()
                .sorted(Comparator.comparing(Product::getCreatingDate).reversed())
                .limit(lastCount)
                .toList();
    }

    public Double calcSumByType(List<Product> src, ProductType type) {
        int year = LocalDate.now().getYear();

        return src.stream()
                .filter(e -> e.getType().equals(type) && e.getCreatingDate().getYear() == year)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public Map<ProductType, List<Product>> groupByType(List<Product> src) {
        return src.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }
}
