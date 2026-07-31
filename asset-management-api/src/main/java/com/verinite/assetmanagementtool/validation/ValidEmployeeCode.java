package com.verinite.assetmanagementtool.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidEmployeeCodeValidator.class)
public @interface ValidEmployeeCode {

    String message() default "Invalid Employee ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
