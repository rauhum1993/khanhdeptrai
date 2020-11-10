package com.product.service;

import com.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    public static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product("1", "I phone X", "18 trieu", "USA", "yellow"));
        productMap.put(2, new Product("2", "I phone Y", "20 trieu", "LAO", "Black"));
        productMap.put(3, new Product("3", "I phone Z", "22 trieu", "DONG LAO", "brown"));
        productMap.put(4, new Product("4", "I phone A", "23 trieu", "NGA", "red"));
        productMap.put(5, new Product("5", "I phone B", "24 trieu", "DONG NGA", "blue"));
    }

    @Override
    public List<Product> fillAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product fillByID(String id) {

        return productMap.get(Integer.parseInt(id));
    }

    @Override
    public void save(Product product) {
        productMap.put(Integer.parseInt(product.getId()), product);
    }

    @Override
    public void update(Product product) {
        productMap.put(Integer.parseInt(product.getId()), product);
    }

    @Override
    public void delete(Product product) {
        productMap.remove(Integer.parseInt(product.getId()));
    }

    @Override
    public void view(Product product) {

    }
}
