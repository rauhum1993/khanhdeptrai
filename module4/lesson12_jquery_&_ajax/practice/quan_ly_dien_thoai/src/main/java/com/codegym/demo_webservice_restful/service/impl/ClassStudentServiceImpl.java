package com.codegym.demo_webservice_restful.service.impl;

import com.codegym.demo_webservice_restful.entity.ClassStudent;
import com.codegym.demo_webservice_restful.repository.ClassStudentRepository;
import com.codegym.demo_webservice_restful.service.ClassStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStudentServiceImpl implements ClassStudentService {
    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Override
    public List<ClassStudent> findAll() {
        return this.classStudentRepository.findAll();
    }
}
