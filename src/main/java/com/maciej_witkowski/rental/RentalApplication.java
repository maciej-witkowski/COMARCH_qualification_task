package com.maciej_witkowski.rental;

import com.maciej_witkowski.rental.config.CustomerConfig;
import com.maciej_witkowski.rental.config.ProductConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({CustomerConfig.class, ProductConfig.class})
public class RentalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}

}
