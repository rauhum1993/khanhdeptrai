package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> fillAll();

    Product fillByID(String id);

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    void view(Product product);


}
