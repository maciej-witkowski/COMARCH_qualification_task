package com.maciej_witkowski.rental.service;

import com.maciej_witkowski.rental.model.Product;
import com.maciej_witkowski.rental.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
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

    @Transactional
    public ResponseEntity<HttpStatus> updateProduct(Long id, String name, String brand, BigDecimal price) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Product with id " + id + " does not exists!")
        );

        if (productRepository.findProductByNameAndBrand(name, brand).isPresent()) {
            throw new IllegalStateException("Given name and brand already exists!");
        }

        if (name != null && name.length() > 0 && !name.equals(product.getName())) {
            product.setName(name);
        }

        if (brand != null && brand.length() > 0 && !brand.equals(product.getBrand())) {
            product.setBrand(brand);
        }

        if (price != null && price.compareTo(BigDecimal.ZERO) > 0 && !price.equals(product.getPrice())) {
            product.setPrice(price);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
