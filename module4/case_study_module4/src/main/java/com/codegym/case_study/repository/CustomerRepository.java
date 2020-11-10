package com.codegym.case_study.repository;

import com.codegym.case_study.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    Page<Customer> findByCustomerNameContaining(Pageable pageable,String name);


}
