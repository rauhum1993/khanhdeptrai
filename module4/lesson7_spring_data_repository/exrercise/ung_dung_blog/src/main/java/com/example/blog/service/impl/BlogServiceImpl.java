package com.example.blog.service.impl;

import com.example.blog.entity.BlogClass;
import com.example.blog.repository.BlogRepository;
import com.example.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;
    @Override
    public List<BlogClass> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(BlogClass blogClass) {
        blogRepository.save(blogClass);
    }

    @Override
    public Page<BlogClass> findAll(Pageable pageable) {
        return null;
    }
}
