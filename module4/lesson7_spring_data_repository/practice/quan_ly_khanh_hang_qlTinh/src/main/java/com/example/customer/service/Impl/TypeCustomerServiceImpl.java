package com.example.customer.service.Impl;

import com.example.customer.entity.TypeCustomer;
import com.example.customer.repository.TypeCustomerRepository;
import com.example.customer.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {
    @Autowired
    TypeCustomerRepository typeCustomerRepository;
    @Override
    public List<TypeCustomer> findAll() {
        return typeCustomerRepository.findAll();
    }
}
