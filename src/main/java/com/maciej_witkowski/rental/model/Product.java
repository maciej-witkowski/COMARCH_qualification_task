package com.maciej_witkowski.rental.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;

    public Product() {}

    public Product(Long id, String name, String brand, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Product(String name, String brand, BigDecimal price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}