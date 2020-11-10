package com.example.blog.repository;

import com.example.blog.entity.BlogClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogClass, Integer> {
}
