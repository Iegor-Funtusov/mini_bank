package ua.com.alevel.solid.dao.impl;

import ua.com.alevel.solid.dao.PersonalDao;
import ua.com.alevel.solid.data.Personal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:53 PM
 */

public class PersonalDaoImpl implements PersonalDao {

    private final List<Personal> personals = new ArrayList<>();

    @Override
    public void createPersonal(Personal personal) {
        personal.setId(generateId());
        personals.add(personal);
    }

    @Override
    public void updatePersonal(Personal personal) {
        Personal existPersonal = findById(personal.getId());
        existPersonal.setEmail(personal.getEmail());
        existPersonal.setName(personal.getName());
    }

    @Override
    public void deletePersonal(String id) {
        personals.removeIf(personal -> personal.getId().equals(id));
    }

    @Override
    public List<Personal> findAll() {
        return personals;
    }

    @Override
    public Personal findById(String id) {
        return personals
                .stream()
                .filter(personal -> personal.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Personal findByEmail(String email) {
        return personals
                .stream()
                .filter(personal -> personal.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        Personal personal = findById(id);
        if (personal == null) {
            return id;
        } else {
            return generateId();
        }
    }
}
