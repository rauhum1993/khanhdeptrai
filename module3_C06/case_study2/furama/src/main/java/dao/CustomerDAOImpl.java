package dao;

import model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private BaseDAO baseDAO= new BaseDAO();
    private static final String SELECT_ALL_CUSTOMER = "select* from customer";
    private static final String CREATE_NEW_CUSTOMER = "INSERT INTO customer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";
    private static final String INSERT_CUTOMER_SQL = "INSERT INTO customer" + "  (customer_id,customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_type_id,customer_name,customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id =?";
    private static final String EDIT_CUSTOMER = "UPDATE customer SET customer_type_id = ?, customer_name = ?, " +
            "customer_birthday = ?,customer_gender = ?, customer_id_card = ?, customer_phone = ?, customer_email = ?," +
            " customer_address = ? WHERE customer_id = ?;";

    private static String DELETE_CUSTOMER_BY_ID = "delete from customer where customer_id=?";

    private static String SEARCH_NAME_CUSTOMER = "select*from customer where customer_name like ?";

    @Override
    public List<Customer> showListCustomer() {
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("customer_id");
                String customerTypeId = resultSet.getString("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");

                customerList.add(new Customer(id,customerTypeId,customerName,customerBirthday,customerGender,
                        customerIdCard,customerPhone,customerEmail,customerAddress));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public void insert(Customer customer)  {
        PreparedStatement preparedStatement= null;
        try {
            preparedStatement = this.baseDAO.getConnection().prepareStatement(INSERT_CUTOMER_SQL);
            preparedStatement.setString(1,customer.getId());
            preparedStatement.setString(2,customer.getTypeId());
            preparedStatement.setString(3,customer.getName());
            preparedStatement.setString(4,customer.getBirthday());
            preparedStatement.setString(5,customer.getGender());
            preparedStatement.setString(6,customer.getIdCard());
            preparedStatement.setString(7,customer.getPhone());
            preparedStatement.setString(8,customer.getEmail());
            preparedStatement.setString(9,customer.getAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Customer findByID(String id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement= this.baseDAO.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String customerTypeId = resultSet.getString("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(id,customerTypeId,customerName,customerBirthday,customerGender,
                        customerIdCard,customerPhone,customerEmail,customerAddress);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(EDIT_CUSTOMER);
            preparedStatement.setString(1,customer.getTypeId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthday());
            preparedStatement.setString(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setString(9,customer.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement= this.baseDAO.getConnection().prepareStatement(SEARCH_NAME_CUSTOMER);
            preparedStatement.setString(1,"%"+ name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString("customer_id");
                String customerTypeId = resultSet.getString("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                String customerGender = resultSet.getString("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customerList.add(new Customer(id,customerTypeId,customerName,customerBirthday,customerGender,
                        customerIdCard,customerPhone,customerEmail,customerAddress) ) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
