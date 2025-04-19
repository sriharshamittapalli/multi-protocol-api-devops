package com.api.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping
    public List<Product> getAllProducts() {
        return List.of(
            new Product(1L, "Laptop", 999.99),
            new Product(2L, "Mouse", 49.99),
            new Product(3L, "Keyboard", 79.99)
        );
    }
}