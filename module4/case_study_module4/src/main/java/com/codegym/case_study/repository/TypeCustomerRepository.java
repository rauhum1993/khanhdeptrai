package com.codegym.case_study.repository;

import com.codegym.case_study.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCustomerRepository extends JpaRepository<CustomerType,Integer> {
}
