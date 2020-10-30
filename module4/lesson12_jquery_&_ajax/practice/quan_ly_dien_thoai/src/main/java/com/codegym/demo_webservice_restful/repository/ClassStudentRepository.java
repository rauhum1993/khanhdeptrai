package com.codegym.demo_webservice_restful.repository;

import com.codegym.demo_webservice_restful.entity.ClassStudent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassStudentRepository extends JpaRepository<ClassStudent, Integer> {
}
