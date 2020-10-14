package dao;

import model.GenderCustomer;

import java.util.List;

public interface GenderDAO {
    List<GenderCustomer> findAllGenderCustomer();

}
