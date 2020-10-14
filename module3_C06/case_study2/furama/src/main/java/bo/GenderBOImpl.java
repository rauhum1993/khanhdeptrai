package bo;

import dao.cutomer.GenderDAO;
import dao.cutomer.GenderDAOImpl;
import model.GenderCustomer;

import java.util.List;

public class GenderBOImpl implements GenderBO{
    GenderDAO genderDAO = new GenderDAOImpl();
    @Override
    public List<GenderCustomer> findAllGenderCustomer() {
        return genderDAO.findAllGenderCustomer() ;
    }
}
