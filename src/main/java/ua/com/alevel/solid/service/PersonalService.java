package ua.com.alevel.solid.service;

import ua.com.alevel.solid.data.Personal;

import java.util.List;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 9:18 PM
 */
public interface PersonalService {

    void createPersonal(Personal personal);
    void updatePersonal(Personal personal);
    void deletePersonal(String id);
    List<Personal> findAll();
    Personal findById(String id);
}
