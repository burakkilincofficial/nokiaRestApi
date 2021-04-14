package com.app.nokia.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneLengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneLengthConstraint {
    String message() default "Invalid phone value, the phone must be between 9 and 12 in length ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

