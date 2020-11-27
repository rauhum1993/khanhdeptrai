package com.codegym.case_study.service;

import com.codegym.case_study.entity.Customer;
import com.codegym.case_study.entity.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeCustomerService {

    List<CustomerType> findAll();


}
