package com.codegym.case_study.service.impl;

import com.codegym.case_study.entity.Customer;
import com.codegym.case_study.repository.CustomerRepository;
import com.codegym.case_study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null );
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void deleteById(String id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByAndCustomerName(Pageable pageable, String name) {
        return customerRepository.findByCustomerNameContaining(pageable,name);
    }

    @Override
    public Page<Customer> findAllByEmailContaining(Pageable pageable, String email) {
        return customerRepository.findByEmailContaining(pageable,email);
    }

    @Override
    public Page<Customer> searchStudentByNameOrByEmail(Pageable pageable, String name,String email) {
        return customerRepository.searchStudentByNameOrByEmail(pageable,name,email);
    }

    @Override
    public Page<Customer> sortByName(Pageable pageable) {
        return customerRepository.sortByName(pageable);
    }
}
