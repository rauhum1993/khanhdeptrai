package com.codegym.case_study.service;

import java.util.List;

public interface UserRole {

    List<UserRole> findAll();

    void save(UserRole userRole);
}
