package com.maciej_witkowski.rental.repository;

import com.maciej_witkowski.rental.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT product FROM Product product WHERE product.name = ?1 AND product.brand = ?2")
    Optional<Product> findProductByNameAndBrand(String name, String brand);

}
