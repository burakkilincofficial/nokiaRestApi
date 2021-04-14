package com.app.nokia.common.exceptions;

import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@EqualsAndHashCode(callSuper = true)
public class UserAccountNotFoundException extends BaseException {
    public UserAccountNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("The user account number '%s', could not find", id));

    }
}
