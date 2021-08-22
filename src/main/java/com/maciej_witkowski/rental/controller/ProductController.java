package com.maciej_witkowski.rental.controller;

import com.maciej_witkowski.rental.model.Product;
import com.maciej_witkowski.rental.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product addNewProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    @ResponseBody
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("productId") Long id) {
        return productService.deleteProduct(id);
    }

}
