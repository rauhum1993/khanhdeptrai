package com.codegym.security.service;

import com.codegym.security.entity.Product;
import com.codegym.security.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> findALl();

    void save(Product product);


}
