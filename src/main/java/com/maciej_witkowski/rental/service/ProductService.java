package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.model.Product;
import com.maciej_witkowski.rental.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addNewProduct(Product product) {
        if (productRepository.findProductByNameAndBrand(product.getName(), product.getBrand()).isPresent()) {
            throw new IllegalStateException("Given name and brand already exists!");
        }

        productRepository.save(product);
        return product;
    }

    public ResponseEntity<HttpStatus> deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalStateException("Product with id " + id + " does not exists!");
        }

        productRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
