package com.example.demo.Validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IpAddressImpl.class}
)
public @interface IpAddress {
    String message() default "{jakarta.validation.constraints.ip-address.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
