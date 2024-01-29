package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private static List<Product> example() {
        return List.of(
                Product.builder()
                        .type(ProductType.Toy)
                        .price(45D)
                        .discountAllowed(false)
                        .creatingDate(LocalDate.parse("2023-10-15"))
                        .id(123)
                        .build(),
                Product.builder()
                        .type(ProductType.Toy)
                        .price(123.45D)
                        .discountAllowed(false)
                        .creatingDate(LocalDate.parse("2022-01-01"))
                        .id(456)
                        .build(),
                Product.builder()
                        .type(ProductType.Book)
                        .price(10.45D)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-17"))
                        .id(789)
                        .build(),
                Product.builder()
                        .type(ProductType.Book)
                        .price(255D)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-16"))
                        .id(147)
                        .build(),
                Product.builder()
                        .type(ProductType.Tool)
                        .price(455D)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2024-01-29"))
                        .id(258)
                        .build(),
                Product.builder()
                        .type(ProductType.Tool)
                        .price(59.12D)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-11-10"))
                        .id(369)
                        .build()
        );
    }

    @Test
    void getProductsByTypeOverPrice() {
        List<Product> expected = List.of(
                Product.builder()
                        .type(ProductType.Book)
                        .price(255D)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-16"))
                        .id(147)
                        .build()
        );
        assertEquals(expected, new ProductService().getProductsByTypeOverPrice(example(), ProductType.Book, 250f));
    }

    @Test
    void getProductsByTypeOverPriceNotFound() {
        ProductService ps = new ProductService();
        assertEquals(Collections.emptyList(), ps.getProductsByTypeOverPrice(example(), ProductType.Clothing, 250f));
        assertEquals(Collections.emptyList(), ps.getProductsByTypeOverPrice(example(), ProductType.Book, 5000f));
    }

    @Test
    void getProductsByTypeApplyDiscount() {
        List<Product> expected = List.of(
                Product.builder()
                        .type(ProductType.Book)
                        .price(10.45d * (1 - 0.10D))
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-17"))
                        .id(789)
                        .build(),
                Product.builder()
                        .type(ProductType.Book)
                        .price(255d * (1 - 0.10d))
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-16"))
                        .id(147)
                        .build()
        );
        ProductService ps = new ProductService();
        assertEquals(expected, ps.getProductsByTypeApplyDiscount(example(), ProductType.Book, 0.1d));
    }

    @Test
    void getProductsByTypeApplyDiscountNotFound() {
        ProductService ps = new ProductService();
        assertEquals(Collections.emptyList(), ps.getProductsByTypeApplyDiscount(example(), ProductType.Food, 0.1f));
    }

    @Test
    void getCheapestByType() {
        ProductService ps = new ProductService();
        Product expextedProduct = Product.builder()
                .type(ProductType.Book)
                .price(10.45d)
                .discountAllowed(true)
                .creatingDate(LocalDate.parse("2023-10-17"))
                .id(789)
                .build();

        assertEquals(expextedProduct, ps.getCheapestByType(example(), ProductType.Book));
    }

    @Test
    void getCheapestByTypeNotFound() {
        ProductService ps = new ProductService();
        var e = assertThrows(RuntimeException.class, () -> ps.getCheapestByType(example(), ProductType.Clothing));
        assertEquals("Продукт [категорія: Clothing] не знайдено", e.getMessage());
    }

    @Test
    void getLastAdded() {
        List<Product> exp = List.of(
                Product.builder()
                        .type(ProductType.Tool)
                        .price(455d)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2024-01-29"))
                        .id(258)
                        .build(),
                Product.builder()
                        .type(ProductType.Tool)
                        .price(59.12d)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-11-10"))
                        .id(369)
                        .build(),
                Product.builder()
                        .type(ProductType.Book)
                        .price(10.45d)
                        .discountAllowed(true)
                        .creatingDate(LocalDate.parse("2023-10-17"))
                        .id(789)
                        .build()
        );

        ProductService ps = new ProductService();
        assertEquals(exp, ps.getLastAdded(example(), 3));
    }

    @Test
    void getLastAddedNothing() {
        ProductService ps = new ProductService();
        assertEquals(Collections.emptyList(), ps.getLastAdded(example(), 0));
    }

    @Test
    void calcSumByType() {
        assertEquals(455d, new ProductService().calcSumByType(example(), ProductType.Tool));
        assertEquals(0d, new ProductService().calcSumByType(example(), ProductType.Food));
    }

    @Test
    void groupByType() {
        Map<ProductType, List<Product>> map = new ProductService().groupByType(example());

        assertEquals(3, map.keySet().size());

        assertTrue(map.containsKey(ProductType.Book));
        assertTrue(map.containsKey(ProductType.Tool));
        assertTrue(map.containsKey(ProductType.Toy));
    }
}