package com.neeson.code.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 22:07
 * Description: 
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {PersonNamePrefixConstraintValidator.class})
public @interface PersonNamePrefix {

	String message() default "{person.name.prefix.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String prefix() default "sf-";

}
