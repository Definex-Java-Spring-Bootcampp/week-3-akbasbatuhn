package com.patika.productservice.service;

import com.patika.productservice.exception.ResourceNotFoundException;
import com.patika.productservice.model.Product;
import com.patika.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addNewProduct(Product product) {
        repository.addProduct(product);
    }

    public List<Product> getAllProducts() {
        return repository.getAllProducts();
    }

    public Integer getProductAmountByName(String productName) {
        Product product = repository.getProductByName(productName).orElseThrow(
                () -> new ResourceNotFoundException("Product not found with name: " + productName)
        );

        return product.getStockAmount();
    }
}
