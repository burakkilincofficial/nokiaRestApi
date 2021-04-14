package com.app.nokia.common.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends Exception {
    private final HttpStatus status;

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
