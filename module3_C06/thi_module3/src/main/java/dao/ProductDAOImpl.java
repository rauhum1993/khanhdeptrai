package dao;

import model.Customer;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private BaseDAO baseDAO= new BaseDAO();
    private static final String SELECT_ALL_PRODUCT = "select* from product";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO  product" + "  (product_id,product_name,product_price," +
            "product_numbers,product_color,product_status,product_category) VALUES " +
            " (?,?,?,?,?,?,?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_type_id,customer_name,customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id =?";
    private static final String EDIT_CUSTOMER = "UPDATE customer SET customer_type_id = ?, customer_name = ?, " +
            "customer_birthday = ?,customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?," +
            " customer_address = ? WHERE customer_id = ?;";

    private static String DELETE_PRODUCT_BY_ID = "delete from product where product_id=?";

    private static String SEARCH_NAME_PRODUCT = "select*from product where product_name like ?";
    private static String SEARCH_PRICE_PRODUCT = "select*from product where product_price like ?";

    @Override
    public List<Product> showListProduct() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String productId = resultSet.getString("product_id");
                String productName = resultSet.getString("product_name");
                String productPrice = resultSet.getString("product_price");
                String productNumbers = resultSet.getString("product_numbers");
                String productColor = resultSet.getString("product_color");
                String productStatus = resultSet.getString("product_status");
                String productCategory = resultSet.getString("product_category");

                productList.add(new Product(productId,productName,productPrice,productNumbers,productColor,
                        productStatus,productCategory));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

//    @Override
//    public void create(Customer customer) {
//
//    }
//
    @Override
    public void insert(Product product)  {

        try {
         PreparedStatement   preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setString(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getPrice());
            preparedStatement.setString(4,product.getNumbers());
            preparedStatement.setString(5,product.getColor());
            preparedStatement.setString(6,product.getStatus());
            preparedStatement.setString(7,product.getCategory());


           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//
//    @Override
//    public Customer findByID(String id) {
//        Customer customer = null;
//        try {
//            PreparedStatement preparedStatement= this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
//            preparedStatement.setString(1,id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                String customerTypeId = resultSet.getString("customer_type_id");
//                String customerName = resultSet.getString("customer_name");
//                String customerBirthday = resultSet.getString("customer_birthday");
//                String customerGender = resultSet.getString("customer_gender");
//                String customerIdCard = resultSet.getString("customer_id_card");
//                String customerPhone = resultSet.getString("customer_phone");
//                String customerEmail = resultSet.getString("customer_email");
//                String customerAddress = resultSet.getString("customer_address");
//                customer = new Customer(id,customerTypeId,customerName,customerBirthday,customerGender,
//                        customerIdCard,customerPhone,customerEmail,customerAddress);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customer;
//    }
//
//    @Override
//    public void update(Customer customer) {
//        try {
//            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_CUSTOMER);
//            preparedStatement.setString(1,customer.getTypeId());
//            preparedStatement.setString(2,customer.getName());
//            preparedStatement.setString(3,customer.getBirthday());
//            preparedStatement.setString(4,customer.getGender());
//            preparedStatement.setString(5,customer.getIdCard());
//            preparedStatement.setString(6,customer.getPhone());
//            preparedStatement.setString(7,customer.getEmail());
//            preparedStatement.setString(8,customer.getAddress());
//            preparedStatement.setString(9,customer.getId());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
    @Override
    public void delete(String id) {

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_PRODUCT_BY_ID);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
//
    @Override
    public List<Product> searchByPrice(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement= this.baseDAO.getConnection().prepareStatement(SEARCH_PRICE_PRODUCT);
            preparedStatement.setString(1,"%"+ name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String productId = resultSet.getString("product_id");
                String productName = resultSet.getString("product_name");
                String productPrice = resultSet.getString("product_price");
                String productNumbers = resultSet.getString("product_numbers");
                String productColor = resultSet.getString("product_color");
                String productStatus = resultSet.getString("product_status");
                String productCategory = resultSet.getString("product_category");
                productList.add(new Product(productId,productName,productPrice,productNumbers,productColor,
                        productStatus,productCategory));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement= this.baseDAO.getConnection().prepareStatement(SEARCH_NAME_PRODUCT);
            preparedStatement.setString(1,"%"+ name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String productId = resultSet.getString("product_id");
                String productName = resultSet.getString("product_name");
                String productPrice = resultSet.getString("product_price");
                String productNumbers = resultSet.getString("product_numbers");
                String productColor = resultSet.getString("product_color");
                String productStatus = resultSet.getString("product_status");
                String productCategory = resultSet.getString("product_category");
                productList.add(new Product(productId,productName,productPrice,productNumbers,productColor,
                        productStatus,productCategory));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
