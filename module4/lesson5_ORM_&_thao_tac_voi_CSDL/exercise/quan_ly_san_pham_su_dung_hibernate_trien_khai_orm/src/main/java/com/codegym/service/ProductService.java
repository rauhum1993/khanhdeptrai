package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findbyId(Integer id);

    void save(Product product);
}
