package ua.com.alevel.solid.data;

import lombok.Getter;
import lombok.Setter;

import ua.com.alevel.solid.type.Currency;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Iehor Funtusov, created 23/10/2020 - 8:33 PM
 */

@Getter
@Setter
public class Balance extends AbstractData {

    private BigDecimal cash;
    private Currency currency;
    private Date date;
    private String personalId;
}
