package com.app.nokia.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
@RequiredArgsConstructor
public class PhoneLengthValidator implements ConstraintValidator<PhoneLengthConstraint, String> {

    @Override
    public void initialize(PhoneLengthConstraint constraintAnnotation) {
        //empty
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return value.length() >= 9 && value.length() <= 12;
    }
}
