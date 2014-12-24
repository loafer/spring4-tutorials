package com.github.loafer.user.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author zhaojh.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface ValidatePassword {
    String message() default "{password.confirmation.error}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
