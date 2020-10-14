package dao;

import model.Customer;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> showListProduct();

//    void create(Product product) ;
//
    void insert(Product product) throws SQLException;
//
//    Product findByID(String id);
//
//    void update(Product product);
//
    void delete(String id);

    List<Product> searchByName(String name);
    List<Product> searchByPrice(String name);
}
