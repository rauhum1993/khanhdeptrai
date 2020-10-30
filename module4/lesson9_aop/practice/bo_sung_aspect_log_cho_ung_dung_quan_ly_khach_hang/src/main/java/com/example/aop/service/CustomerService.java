package com.example.aop.service;

import com.example.aop.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

   Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id) throws Exception;


}
