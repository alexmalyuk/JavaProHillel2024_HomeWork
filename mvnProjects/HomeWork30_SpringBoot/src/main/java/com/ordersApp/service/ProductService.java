package com.ordersApp.service;

import com.ordersApp.dto.ProductDto;
import com.ordersApp.entity.Product;
import com.ordersApp.exception.ProductNotFoundException;
import com.ordersApp.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        log.info("call getAllProducts");
        return productRepository.findAll();
    }

    public Page<Product> getAllProducts(PageRequest of) {
        log.info("call getAllProducts " + of);
        return productRepository.findAll(of);
    }

    public Product getProductById(long id) {
        log.info("call getProductById : " + id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(Long.toString(id)));
    }

    public Product addProduct(ProductDto productDto) {
        log.info("call addProduct ");
        return productRepository.save(new Product()
                .setName(productDto.getName())
                .setCost(productDto.getCost()));
    }

    public void deleteProduct(long id) {
        log.info("call deleteProduct : " + id);
        productRepository.delete(getProductById(id));
    }

}
