package com.app.nokia.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDetailResponse {
    private String accountNumber;
    private String owner;
    private double balance;
    private Date createDate;
    private List<BankResponse> transactions;
}
