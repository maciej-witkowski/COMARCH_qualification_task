package com.maciej_witkowski.rental.repository;

import com.maciej_witkowski.rental.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {}
