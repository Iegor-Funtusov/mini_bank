package ua.com.alevel.solid.dao;

import ua.com.alevel.solid.data.Personal;

import java.util.List;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:47 PM
 */

public interface PersonalDao {

    void createPersonal(Personal personal);
    void updatePersonal(Personal personal);
    void deletePersonal(String id);
    List<Personal> findAll();
    Personal findById(String id);
    Personal findByEmail(String email);
}
