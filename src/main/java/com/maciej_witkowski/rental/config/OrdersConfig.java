//package com.maciej_witkowski.rental.config;
//
//import com.maciej_witkowski.rental.model.Customer;
//import com.maciej_witkowski.rental.model.Orders;
//import com.maciej_witkowski.rental.model.Product;
//import com.maciej_witkowski.rental.repository.OrdersRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//@Configuration
//public class OrdersConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunnerOrders(OrdersRepository repository) {
//        return args -> {
//            Customer customer0 = new Customer(
//                    "Maciej",
//                    "Witkowski",
//                    "maciej.jan.witkowski@gmail.com",
//                    "723-377-677"
//            );
//
//            Product product0 = new Product(
//                    "Pralka",
//                    "Bosch",
//                    new BigDecimal("25.99")
//            );
//
//            Orders order0 = new Orders(
//                    customer0,
//                    product0,
//                    LocalDateTime.of(2021, 8, 23, 10, 8, 0),
//                    LocalDateTime.of(2021, 8, 23, 12, 32, 0)
//            );
//
//            repository.save(order0);
//        };
//    }
//
//}
