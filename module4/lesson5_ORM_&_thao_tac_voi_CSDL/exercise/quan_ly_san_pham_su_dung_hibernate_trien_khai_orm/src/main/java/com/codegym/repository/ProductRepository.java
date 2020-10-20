package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findbyId(Integer id);

    void save(Product product);
}
