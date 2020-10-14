package dao;

import model.GenderCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenderDAOImpl implements GenderDAO {
    private BaseDAO baseDAO= new BaseDAO();
    private static final String SELECT_ALL_GENDER = "select* from gender";
    @Override
    public List<GenderCustomer> findAllGenderCustomer() {
        List<GenderCustomer> genderCustomerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_GENDER);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id =resultSet.getString("gender_id");
                String name =resultSet.getString("gender_name");

                genderCustomerList.add(new GenderCustomer(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genderCustomerList;
    }
}
