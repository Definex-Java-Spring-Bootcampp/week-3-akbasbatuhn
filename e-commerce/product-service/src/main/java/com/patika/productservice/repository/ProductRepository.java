package com.patika.productservice.repository;

import com.patika.productservice.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class ProductRepository {

    private List<Product> productList;
    private Set<String> productNames;

    public ProductRepository() {
        productList = new ArrayList<>();
        productNames = new HashSet<>();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public Optional<Product> getProductByName(String productName) {
        return productList.stream()
                .filter(product -> productName.equals(product.getName()))
                .findFirst();
    }

    public void addProduct(Product other) {
        if(productNames.contains(other.getName())) {
            for(Product product: productList) {
                if(product.getName().equals(other.getName())) {
                    int amount = product.getStockAmount();
                    product.setStockAmount(amount + other.getStockAmount());
                }
            }
        } else {
            productList.add(other);
            productNames.add(other.getName());
        }
    }

    public void addProducts(List<Product> list) {
        for(Product product : list)
            productList.add(product);
    }

    private boolean determineCanOrderBeFulfilled(List<Product> orderedProducts) {
        for(Product other : orderedProducts) {
            for(Product product : productList) {
                boolean hasFound = other.getName().equals(product.getName());
                boolean hasEnoughStockAmount = other.getStockAmount() > product.getStockAmount();
                if(hasFound && !hasEnoughStockAmount) return false;
            }
        }

        return true;
    }
}
