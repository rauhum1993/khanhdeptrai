package com.codegym.service.impl;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> fillAll();

    Customer fillById(Integer id);

    void save(Customer customer);

    void delete(Integer id);
}
