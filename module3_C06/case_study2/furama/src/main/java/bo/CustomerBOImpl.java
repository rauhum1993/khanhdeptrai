package bo;

import dao.cutomer.CustomerDAO;
import dao.cutomer.CustomerDAOImpl;
import model.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public List<Customer> showListCustomer() {

        return customerDAO.showListCustomer();
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void insert(Customer customer) throws SQLException {
        customerDAO.insert(customer);
    }

    @Override
    public Customer findByID(String id) {
        return customerDAO.findByID(id);
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public void delete(String id) {
        customerDAO.delete(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return customerDAO.searchByName(name);
    }
}
