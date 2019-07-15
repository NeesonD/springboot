package com.neeson.code.spring;


import com.neeson.code.domain.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author : neeson
 * Date: 2019/7/15
 * Time: 22:02
 * Description: 
 */
public class PersonValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Person.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Person person = Person.class.cast(o);

		String name = person.getName();

		if (!StringUtils.hasLength(name)) {
			errors.reject("person.name.not.null", "人的名字不能为空");
		}
	}
}
