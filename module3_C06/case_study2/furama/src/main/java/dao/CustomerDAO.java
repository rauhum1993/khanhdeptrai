package dao;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    List<Customer> showListCustomer();

    void create(Customer customer) ;

    void insert(Customer customer) throws SQLException;

    Customer findByID(String id);

    void update(Customer customer);

    void delete(String id);

    List<Customer> searchByName(String name);
}
