package ua.com.alevel.solid.service.impl;

import ua.com.alevel.solid.dao.PersonalDao;
import ua.com.alevel.solid.dao.impl.PersonalDaoImpl;
import ua.com.alevel.solid.data.Personal;
import ua.com.alevel.solid.service.PersonalService;

import java.util.List;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 9:19 PM
 */
public class PersonalServiceImpl implements PersonalService {

    private final PersonalDao personalDao = new PersonalDaoImpl();

    @Override
    public void createPersonal(Personal personal) {
        findByEmail(personal.getEmail());
        personalDao.createPersonal(personal);
    }

    @Override
    public void updatePersonal(Personal personal) {
        findPersonal(personal.getId());
        findByEmail(personal.getEmail());
        personalDao.updatePersonal(personal);
    }

    @Override
    public void deletePersonal(String id) {
        findPersonal(id);
        personalDao.deletePersonal(id);
    }

    @Override
    public List<Personal> findAll() {
        return personalDao.findAll();
    }

    @Override
    public Personal findById(String id) {
        return personalDao.findById(id);
    }

    private Personal findPersonal(String id) {
        Personal existPersonal = findById(id);
        if (existPersonal == null) {
            throw new RuntimeException("user not found");
        }
        return existPersonal;
    }

    private Personal findByEmail(String email) {
        Personal exist = personalDao.findByEmail(email);
        if (exist != null) {
            throw new RuntimeException("personal exist by email");
        }
        return exist;
    }
}
