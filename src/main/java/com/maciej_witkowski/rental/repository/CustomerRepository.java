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

//    @Query(nativeQuery = true, value = """
//            SELECT orders.id, name, brand, date_of_loan, date_of_return, total_price FROM orders
//            INNER JOIN product ON orders.product_id=product.id
//            WHERE customer_id=1 AND EXTRACT(MONTH FROM date_of_loan) = 8""")
//    List<Object> findOrders();

}
