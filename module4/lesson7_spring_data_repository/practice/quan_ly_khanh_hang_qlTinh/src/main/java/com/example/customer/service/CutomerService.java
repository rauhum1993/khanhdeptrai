package com.example.customer.service;

import com.example.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CutomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Page<Customer> findAll(Pageable pageable);

    Customer fillById(Integer id);

    Page<Customer> findByNameContaining(Pageable pageable, String name);

    void delete(Integer id);

}
