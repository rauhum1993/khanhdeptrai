package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    private BaseDAO baseDAO= new BaseDAO();
        private static final String SELECT_ALL_CATEGORY = "select* from category";
    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseDAO.getConnection().prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id =resultSet.getString("id_category");
                String name =resultSet.getString("name_category");

                categoryList.add(new Category(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
