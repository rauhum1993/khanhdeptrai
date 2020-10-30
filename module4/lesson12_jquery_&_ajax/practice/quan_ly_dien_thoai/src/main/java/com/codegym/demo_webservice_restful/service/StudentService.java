package com.codegym.demo_webservice_restful.service;


import com.codegym.demo_webservice_restful.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Page<Student> findAll(Pageable pageable);

    Student findById(Integer id) throws Exception;

    void save(Student student);

    Page<Student> findByNameContaining(Pageable pageable, String name);
}
