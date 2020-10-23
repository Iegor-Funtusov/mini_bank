package ua.com.alevel.solid.dao;

import ua.com.alevel.solid.data.Balance;

import java.util.List;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:46 PM
 */

public interface BalanceDao {

    void createBalance(Balance balance);
    Balance findBalance(String id);
    List<Balance> findByPersonal(String id);
}
