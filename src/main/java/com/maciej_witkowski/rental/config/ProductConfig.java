package com.maciej_witkowski.rental.config;

import com.maciej_witkowski.rental.model.Product;
import com.maciej_witkowski.rental.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunnerProduct(ProductRepository repository) {
        return args -> {
            Product product0 = new Product(
                    "Pralka",
                    "Bosch",
                    new BigDecimal("25.99")
            );

            Product product1 = new Product(
                    "Odkurzacz",
                    "Electrolux",
                    new BigDecimal("17")
            );

            Product product2 = new Product(
                    "Myjka",
                    "Karcher",
                    new BigDecimal("10.01")
            );

            repository.saveAll(List.of(product0, product1, product2));
        };
    }

}
