package com.maciej_witkowski.rental.config;

import com.maciej_witkowski.rental.model.Customer;
import com.maciej_witkowski.rental.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunnerCustomer(CustomerRepository repository) {
        return args -> {
            Customer customer0 = new Customer(
                    "Maciej",
                    "Witkowski",
                    "maciej.jan.witkowski@gmail.com",
                    "723-377-677"
            );

            Customer customer1 = new Customer(
                    "Kajetan",
                    "Kęsik",
                    "kesik@gmail.com",
                    "689-634-852"
            );

            repository.saveAll(List.of(customer0, customer1));
        };
    }

}
