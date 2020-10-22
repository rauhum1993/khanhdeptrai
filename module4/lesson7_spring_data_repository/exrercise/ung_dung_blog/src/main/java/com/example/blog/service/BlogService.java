package com.example.blog.service;

import com.example.blog.entity.BlogClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<BlogClass> findAll();

    void  save(BlogClass blogClass);

    Page<BlogClass> findAll(Pageable pageable);

}
