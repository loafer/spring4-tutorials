package com.github.loafer.car.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author zhaojh.
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {
    private CaseMode caseMode;
    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode =  constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintValidatorContext) {
        if(object == null) return true;

        if(caseMode == CaseMode.UPPER){
            return object.equals(object.toUpperCase());
        }else{
            return object.equals(object.toLowerCase());
        }
    }
}
