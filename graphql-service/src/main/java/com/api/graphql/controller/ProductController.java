package com.api.graphql.controller;
import com.api.graphql.model.Product;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    
    private final List<Product> products = List.of(
        new Product(1L, "Laptop", 999.99),
        new Product(2L, "Mouse", 49.99),
        new Product(3L, "Keyboard", 79.99)
    );

    @QueryMapping
    public Product productById(@Argument Long id) {
        return products.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}