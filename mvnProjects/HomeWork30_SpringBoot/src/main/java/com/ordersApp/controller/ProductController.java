package com.ordersApp.controller;

import com.ordersApp.dto.PageResponseDto;
import com.ordersApp.dto.ProductDto;
import com.ordersApp.entity.Product;
import com.ordersApp.mapper.PageResponseMapper;
import com.ordersApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private static final String CALL_ENDPOINT = "call endpoint : %s ";
    private final ProductService productService;

    @GetMapping()
    public List<Product> gerAllProducts() {
        log.info(String.format(CALL_ENDPOINT, "GET products"));
        return productService.getAllProducts();
    }

    @GetMapping("/page")
    public PageResponseDto<Product> getProductsPage(@RequestParam int page, @RequestParam int size) {
        log.info(String.format(CALL_ENDPOINT, "DELETE products/page " + page + "-" + size));
        return new PageResponseMapper<Product>().shrink(productService.getAllProducts(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public Product gerOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "GET products/" + id));
        return productService.getProductById(id);
    }

    @PostMapping("")
    public Product AddOrder(@RequestBody ProductDto productDto) {
        log.info(String.format(CALL_ENDPOINT, "POST products"));
        return productService.addProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        log.info(String.format(CALL_ENDPOINT, "DELETE products/" + id));
        productService.deleteProduct(id);
    }

}
