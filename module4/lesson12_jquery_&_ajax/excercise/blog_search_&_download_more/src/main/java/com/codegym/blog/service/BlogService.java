package com.codegym.blog.service;

import com.codegym.blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);
}
