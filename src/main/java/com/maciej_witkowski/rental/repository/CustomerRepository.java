package com.maciej_witkowski.rental.repository;

import com.maciej_witkowski.rental.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT customer FROM Customer customer WHERE customer.email = ?1")
    Optional<Customer> findCustomerByEmail(String email);

    @Query("SELECT customer FROM Customer customer WHERE customer.phoneNumber = ?1")
    Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);

    @Query("SELECT customer FROM Customer customer WHERE customer.email = ?1 AND customer.phoneNumber = ?2")
    Optional<Customer> findCustomerByEmailAndPhoneNumber(String email, String phoneNumber);

}
