package com.app.nokia.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
    private Date date;
    private double amount;
    private String type;
    private String approvalCode;
}
