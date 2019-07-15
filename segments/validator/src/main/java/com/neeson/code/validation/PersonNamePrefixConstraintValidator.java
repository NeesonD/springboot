package com.neeson.code.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 22:08
 * Description: 
 */
public class PersonNamePrefixConstraintValidator implements ConstraintValidator<PersonNamePrefix, String> {

	private String prefix;

	@Override
	public void initialize(PersonNamePrefix constraintAnnotation) {
		this.prefix = constraintAnnotation.prefix();
	}

	@Override
	public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
		if (!s.startsWith(prefix)) {
			constraintValidatorContext.disableDefaultConstraintViolation();

			ConstraintValidatorContext.ConstraintViolationBuilder builder = constraintValidatorContext
					.buildConstraintViolationWithTemplate("人的名称必须以\"" + prefix + "\"起始！");

			builder.addConstraintViolation();
			return false;
		}
		return true;
	}
}
