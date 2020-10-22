package com.example.customer.repository;

import com.example.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findAllByNameContainingOrderByName(Pageable pageable, String name);

    //    @Query(value = "select * from student where `name` like %?1%", nativeQuery = true)
    @Query(value = "select * from customer where `name` like concat('%', ?1, '%')",nativeQuery = true)
    List<Customer> searchCustomerByName(String name);

    Page<Customer>  findByOrderByName(Pageable pageable);
}
