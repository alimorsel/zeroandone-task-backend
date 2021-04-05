package com.example.demo.common.annotations.date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.sql.Date;

public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, Object> {


    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }

        try {
            Date.valueOf((String)object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}