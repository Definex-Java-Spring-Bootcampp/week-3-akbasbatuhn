package com.patika.productservice.model;

import com.patika.productservice.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private CategoryType category;
    private BigDecimal price;
    private String name;
    private int stockAmount;

    public Product(String name, BigDecimal price, int stockAmount, CategoryType category) {
        this.price = price;
        this.name = name;
        this.stockAmount = stockAmount;
        this.category = category;
    }
}
