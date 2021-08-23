package com.maciej_witkowski.rental.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Report {

    private Long id;
    private String name;
    private String brand;
    private LocalDateTime dateOfLoan;
    private LocalDateTime dateOfReturn;
    private BigDecimal totalPrice;

    public Report(Long id, String name, String brand, LocalDateTime dateOfLoan, LocalDateTime dateOfReturn, BigDecimal totalPrice) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.dateOfLoan = dateOfLoan;
        this.dateOfReturn = dateOfReturn;
        this.totalPrice = totalPrice;
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

    public LocalDateTime getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(LocalDateTime dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public LocalDateTime getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDateTime dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
