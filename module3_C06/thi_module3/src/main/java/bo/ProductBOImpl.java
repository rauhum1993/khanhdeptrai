package bo;

import dao.ProductDAO;
import dao.ProductDAOImpl;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBOImpl implements ProductBO {

    ProductDAO customerDAO = new ProductDAOImpl();
    @Override
    public List<Product> showListProduct() {

        return customerDAO.showListProduct();
    }

    @Override
    public void insert(Product product) throws SQLException {
        customerDAO.insert(product);
    }

//    @Override
//    public void create(Customer customer) {
//
//    }
//

//
//    @Override
//    public Customer findByID(String id) {
//        return customerDAO.findByID(id);
//    }
//
//    @Override
//    public void update(Customer customer) {
//        customerDAO.update(customer);
//    }
//
    @Override
    public void delete(String id) {
        customerDAO.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return customerDAO.searchByName(name);
    }

    @Override
    public List<Product> searchByPrice(String name) {
        return customerDAO.searchByPrice(name);
    }
}
