package com.app.nokia.response;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ApiResponse extends ResponseData {
    public ApiResponse(String status, String approvalCode) {
        super(status, approvalCode);
    }

    public ApiResponse(Integer responseCode, String responseText) {
        super(responseCode.toString(), responseText);

    }

    public ApiResponse() {
        super("OK", "test");
    }
}