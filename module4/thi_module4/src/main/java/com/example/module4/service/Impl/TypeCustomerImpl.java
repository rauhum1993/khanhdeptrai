package com.codegym.case_study.service.impl;

import com.codegym.case_study.entity.CustomerType;
import com.codegym.case_study.repository.TypeCustomerRepository;
import com.codegym.case_study.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeCustomerImpl implements TypeCustomerService {

    @Autowired
    TypeCustomerRepository typeCustomerRepository;

    @Override
    public List<CustomerType> findAll() {
        return typeCustomerRepository.findAll();
    }
}
