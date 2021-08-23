package com.maciej_witkowski.rental.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class OrdersDTO {

    private Long id;
    private Long customerId;
    private Long productId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfLoan;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateOfReturn;

    public OrdersDTO() {}

    public OrdersDTO(Long id, Long customerId, Long productId, LocalDateTime dateOfLoan, LocalDateTime dateOfReturn) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.dateOfLoan = dateOfLoan;
        this.dateOfReturn = dateOfReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
}
