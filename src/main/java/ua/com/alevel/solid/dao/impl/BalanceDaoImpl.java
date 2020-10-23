package ua.com.alevel.solid.dao.impl;

import ua.com.alevel.solid.dao.BalanceDao;
import ua.com.alevel.solid.data.Balance;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:54 PM
 */
public class BalanceDaoImpl implements BalanceDao {

    private final List<Balance> balances = new ArrayList<>();

    @Override
    public void createBalance(Balance balance) {
        balance.setId(generateId());
        balances.add(balance);
    }

    @Override
    public Balance findBalance(String id) {
        return findById(id);
    }

    @Override
    public List<Balance> findByPersonal(String id) {
        return balances
                .stream()
                .filter(balance -> balance.getPersonalId().equals(id))
                .collect(Collectors.toList());
    }

    private Balance findById(String id) {
        return balances
                .stream()
                .filter(balance -> balance.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        Balance balance = findById(id);
        if (balance == null) {
            return id;
        } else {
            return generateId();
        }
    }
}
