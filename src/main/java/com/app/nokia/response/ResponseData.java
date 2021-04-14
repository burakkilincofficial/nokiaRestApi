package com.app.nokia.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public abstract class ResponseData {
    private String status;
    private String approvalCode;

}
