package com;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam int wattage) {
        return productRepository.searchProductsByWattage(wattage);
    }
}


