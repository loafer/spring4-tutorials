package com.github.loafer.user.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * @author zhaojh.
 */
@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class PasswordValidator implements ConstraintValidator<ValidatePassword, Object[]> {
    @Override
    public void initialize(ValidatePassword validatePassword) {

    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        if(objects == null || objects.length != 3){
            throw new IllegalArgumentException("must have two args");
        }

        if(objects[1] == null && objects[2] == null){
            return true;
        }

        if(objects[1].equals(objects[2])){
            return true;
        }
        return false;
    }
}
