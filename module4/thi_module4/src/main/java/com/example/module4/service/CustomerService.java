package com.codegym.case_study.service;

import com.codegym.case_study.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(String id);

    void delete(Customer customer);

    void deleteById(String id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByAndCustomerName(Pageable pageable, String name);


    Page<Customer> findAllByEmailContaining(Pageable pageable, String name);

    Page<Customer> searchStudentByNameOrByEmail(Pageable pageable,String name,String email);

    Page<Customer> sortByName(Pageable pageable);

}
