package com.verinite.assetmanagementtool.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmployeeCodeValidator implements ConstraintValidator<ValidEmployeeCode,String> {

    @Override
    public void initialize(ValidEmployeeCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if(value==null|| value.trim().isEmpty()){
            context.buildConstraintViolationWithTemplate("Cannot be blank or null").addConstraintViolation();
        return false;
        }

        if(!value.matches("^V\\d{5}$")){
            context.buildConstraintViolationWithTemplate("Must be V followed by 5 digits").addConstraintViolation();
            return false;
        }

        return true;
    }
}
