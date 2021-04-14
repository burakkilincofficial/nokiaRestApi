package com.app.nokia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@NoArgsConstructor
public class DepositTransaction extends Transaction {
    public DepositTransaction(double amount) {
        super(amount);
    }
}
