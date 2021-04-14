package com.app.nokia.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ValidationErrorResponse extends ApiResponse {
    private List<ValidationError> errors;

    public ValidationErrorResponse(List<FieldError> errors) {
        super(HttpStatus.BAD_REQUEST.value(), "request did not pass validation");
        this.errors = errors.stream().map(x -> new ValidationError(x.getField(), x.getRejectedValue(), x.getDefaultMessage(), x.getCode())).collect(Collectors.toList());
    }

    @Data
    @AllArgsConstructor
    public static class ValidationError {
        private String field;
        private Object rejectedValue;
        private String message;
        private String errorCode;
    }
}
