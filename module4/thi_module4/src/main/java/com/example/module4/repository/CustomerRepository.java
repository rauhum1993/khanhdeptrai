package com.codegym.case_study.repository;

import com.codegym.case_study.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Page<Customer> findByCustomerNameContaining(Pageable pageable, String name);

    Page<Customer> findByEmailContaining(Pageable pageable, String email);

    @Query(value = "select * from customer where customer_name  like %?1% and email like %?2%"
            , nativeQuery = true)
    Page<Customer> searchStudentByNameOrByEmail(Pageable pageable, String name,String mail);
    @Query(value = "select * from customer \n" +
            "order by customer_name ",nativeQuery = true)
    Page<Customer> sortByName(Pageable pageable);




}
