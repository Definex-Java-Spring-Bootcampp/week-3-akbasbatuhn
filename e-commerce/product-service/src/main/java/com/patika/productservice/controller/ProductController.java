package com.patika.productservice.controller;

import com.patika.productservice.model.Product;
import com.patika.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        System.out.println("Received----------------------------");
        service.addNewProduct(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    @GetMapping("/amount/{productName}")
    public ResponseEntity<Integer> getProductAmount(@PathVariable String productName) {
        return ResponseEntity.ok().body(service.getProductAmountByName(productName));
    }
}
