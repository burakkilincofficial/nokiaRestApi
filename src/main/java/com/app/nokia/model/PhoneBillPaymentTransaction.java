package com.app.nokia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneBillPaymentTransaction extends Transaction {
    private String payee;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String payee, String phoneNumber, double amount) {
        super(amount);
        this.payee = payee;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneBillPaymentTransaction{" +
                "payee='" + payee + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
