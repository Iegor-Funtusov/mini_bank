package ua.com.alevel.solid.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:31 PM
 */

@Getter
@Setter
public class Personal extends AbstractData {

    private String name;
    private String email;
    private List<Balance> balances;
}
